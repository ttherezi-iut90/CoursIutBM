#! /usr/bin/python
# -*- coding:utf-8 -*-
from flask import Flask, request, render_template, redirect, url_for, abort, flash , session, g
import pymysql.cursors
app = Flask(__name__)
app.secret_key = 'une cle(token) : grain de sel(any random string)'


def get_db():
    if 'db' not in g:
        g.db = pymysql.connect(
            host="serveurmysql.iut-bm.univ-fcomte.fr",
            user="ttherezi",
            password="0806",
            database="BDD_ttherezi",
            charset='utf8mb4',  # 2 attributs à ajouter
            cursorclass=pymysql.cursors.DictCursor  # 2 attributs à ajouter
        )
    return g.db




@app.route('/')
def show_accueil():
    return render_template('layout.html')




@app.route('/station/show')
def show_stations():
    mycursor= get_db().cursor()

    idtri = request.args.get('idtri', None)
    destri = request.args.get('destri', None)
    nbrtri = request.args.get('nbrtri', None)
    alttri = request.args.get('alttri', None)


    sql = "SELECT id_station as id, " \
          "nom_station as nomStation, " \
          "COUNT( id_hotel ) as nbr, " \
          "altitude as altitude " \
          "FROM station " \
          "left join hotel  on station.id_station = hotel.station_id " \
          "group by id_station  "

    if idtri != None:
        sql = sql + " order by id "
    elif nbrtri != None:
        sql = sql + " order by nbr "
    elif destri != None:
        sql = sql + " order by nomStation "
    elif alttri != None:
        sql = sql + " order by altitude "
    else:
        sql = sql + " order by id "
    mycursor.execute(sql)
    stations = mycursor.fetchall()
    sql = "SELECT * from hotel;"
    mycursor.execute(sql)
    hotels = mycursor.fetchall()
    return render_template('stations/show_stations.html', stations=stations,hotels=hotels)

@app.route('/hotel/show')
def show_hotels():

    idtri = request.args.get('idtri',None)
    nbrtri = request.args.get('nbrtri',None)
    nomtri = request.args.get('nomtri',None)
    cattri = request.args.get('cattri',None)
    prixtri = request.args.get('prixtri',None)
    datetri = request.args.get('datetri',None)
    phototri = request.args.get('phototri',None)
    stationtri = request.args.get('stationtri',None)



    mycursor = get_db().cursor()
    sql = "SELECT id_hotel as id," \
          "nom_hotel as nomHotel," \
          "nombre_chambre as nombreChambre ," \
          "categorie," \
          "prix_base_chambre as prixBaseChambre," \
          "date_creation as dateCreation ," \
          "photo as image," \
          "station_id FROM hotel "

    if idtri != None:
        sql = sql + " order by id_hotel "
    elif nomtri != None :
        sql = sql + " order by nom_hotel "
    elif nbrtri != None :
        sql = sql + " order by nombre_chambre "
    elif cattri != None :
        sql = sql + " order by categorie "
    elif prixtri != None :
        sql = sql + " order by prix_base_chambre "
    elif datetri != None :
        sql = sql + " order by date_creation "
    elif phototri != None :
        sql = sql + " order by photo "
    elif stationtri != None :
        sql = sql + " order by station_id "
    else :
        sql = sql + " order by id_hotel "

    mycursor.execute(sql)
    hotels = mycursor.fetchall()
    sql = "SELECT id_station as id," \
          " nom_station as nomStation," \
          " altitude as altitude FROM station ORDER BY id_station"
    mycursor.execute(sql)
    stations = mycursor.fetchall()
    return render_template('hotels/show_hotels.html', stations=stations, hotels=hotels)





@app.route('/station/add', methods=['GET'])
def add_stations():
    return render_template('stations/add_stations.html')

@app.route('/hotel/add', methods=['GET'])
def add_hotels():
    mycursor = get_db().cursor()
    sql = "SELECT id_station as id, nom_station as nomStation, altitude as altitude FROM station ORDER BY id_station;"
    mycursor.execute(sql)
    stations = mycursor.fetchall()
    return render_template('hotels/add_hotels.html' ,stations=stations)






@app.route('/station/add', methods=['POST'])
def valid_add_stations():
    mycursor = get_db().cursor()

    nomStation = request.form.get('nomStation', '')
    print(u'station ajouté , nomStation :', nomStation)
    altitude = request.form.get('altitude', '')
    print(u'station ajouté , altitude :', altitude)

    tuple_insert = (nomStation,altitude)
    sql = "INSERT INTO station (nom_station,altitude) VALUES (%s,%s);"
    mycursor.execute(sql,tuple_insert)
    get_db().commit()

    message = u'station ajouté , nomStation :'+nomStation + ', altitude : ' +altitude
    flash(message, 'alert-success')
    return redirect('/station/show')

@app.route('/hotel/add', methods=['POST'])
def valid_add_hotels():
    mycursor = get_db().cursor()

    nomHotel = request.form.get('nomHotel', '')
    print(u'station ajouté , nomHotel :', nomHotel)
    nombreChambre = request.form.get('nombreChambre', '')
    print(u'station ajouté , nombreChambre :', nombreChambre)
    categorie = request.form.get('categorie', '')
    print(u'station ajouté , categorie :', categorie)
    prixBaseChambre = request.form.get('prixBaseChambre', '')
    print(u'station ajouté , prixBaseChambre :', prixBaseChambre)
    dateCreation = request.form.get('dateCreation', '')
    print(u'station ajouté , dateCreation :', dateCreation)
    image = request.form.get('image', '')
    print(u'station ajouté , image :', image)
    station_id = request.form.get('station_id', '')
    print(u'station ajouté , station_id :', station_id)

    tuple_insert = (nomHotel, nombreChambre,categorie,prixBaseChambre,dateCreation,image,station_id)
    sql = "INSERT INTO hotel (nom_hotel,nombre_chambre,categorie,prix_base_chambre,date_creation, photo, station_id) VALUES (%s,%s,%s,%s,%s,%s,%s)"
    mycursor.execute(sql, tuple_insert)
    get_db().commit()

    message = u'station ajouté , nom :'+nomHotel + u', nombre de Chambre : ' +nombreChambre  + u', categorie : ' +categorie +u', prix de base d\'une Chambre : ' + prixBaseChambre + u', date de Creation : ' + dateCreation + u', image : ' + image + u', station_id : ' + station_id
    flash(message, 'alert-success')
    return redirect('/hotel/show')







@app.route('/station/delete', methods=['GET'])
def delete_stations():
    mycursor = get_db().cursor()
    id = request.args.get('id', '')
    tuple_insert = (id,)
    sql = "DELETE FROM station WHERE id_station = %s;"
    mycursor.execute(sql,tuple_insert)
    get_db().commit()
    message = u'une station supprimé, id_station : ' + id
    print(message)
    flash(message, 'alert-warning')
    return redirect('/station/show')



@app.route('/station/deleteGroup', methods=['GET'])
def delete_stationsGroup():
    mycursor = get_db().cursor()
    id = request.args.get('id', '')
    tuple_insert = (id,)
    sql = "SELECT id_hotel as id," \
          "nom_hotel as nomHotel," \
          "nombre_chambre as nombreChambre ," \
          "categorie," \
          "prix_base_chambre as prixBaseChambre," \
          "date_creation as dateCreation ," \
          "photo as image," \
          "station_id FROM hotel WHERE station_id = %s ORDER BY id_hotel"
    mycursor.execute(sql,tuple_insert)
    hotels = mycursor.fetchall()
    if (len(hotels)==0) :
        return redirect('/station/delete?id='+id)
    sql = "SELECT id_station as id," \
          " nom_station as nomStation," \
          " altitude as altitude FROM station ORDER BY id_station"
    mycursor.execute(sql)
    stations = mycursor.fetchall()

    return render_template('hotels/delete_hotel.html', stations=stations, hotels=hotels, id=id)





@app.route('/hotel/delete', methods=['GET'])
def delete_hotels():
    mycursor = get_db().cursor()

    id = request.args.get('id', '')
    tuple_insert = (id)
    sql = "DELETE FROM hotel WHERE id_hotel = %s;"
    mycursor.execute(sql, tuple_insert )
    get_db().commit()

    print ("un hotel supprimé, id :",id)
    message=u'un hotel supprimé, id : ' + id
    flash(message, 'alert-warning')
    return redirect('/hotel/show')

@app.route('/hotel/deleteGroupe', methods=['GET'])
def delete_hotel():
    mycursor = get_db().cursor()

    id = request.args.get('id', '')
    tuple_insert = (id)
    idStation = request.args.get('idStation', '')

    sql = "DELETE FROM hotel WHERE id_hotel = %s;"
    mycursor.execute(sql, tuple_insert )
    get_db().commit()

    print ("un hotel supprimé, id :",id)
    message=u'un hotel supprimé, id : ' + id
    flash(message, 'alert-warning')
    return redirect('/station/deleteGroup?id='+idStation)





@app.route('/station/edit', methods=['GET'])
def edit_stations():
    mycursor = get_db().cursor()

    idStation = request.args.get('id', '')

    sql = "SELECT id_station as id, nom_station as nomStation, altitude as altitude FROM station where id_station = %s"
    mycursor.execute(sql,(idStation,))
    station = mycursor.fetchone()

    return render_template('stations/edit_station.html', station=station)



@app.route('/station/edit', methods=['POST'])
def valid_edit_stations():
    mycursor = get_db().cursor()

    nomStation = request.form['nomStation']
    altitude = request.form['altitude']
    id = request.form.get('id', '')

    tuple_Insert = (nomStation,altitude,id)
    sql="UPDATE station SET nom_station = %s,altitude = %s WHERE id_station = %s"
    mycursor.execute(sql,tuple_Insert)
    get_db().commit()

    print(u'type Station, id: ', id , " nomStation :" , nomStation ," altitude : " , altitude)
    message=u' Station modifié, id :  ' + id + " ,nomStation :"+ nomStation + " , altitude : " + altitude
    flash(message, 'alert-success')
    return redirect('/station/show')





@app.route('/hotel/edit', methods=['GET'])
def edit_hotels():
    mycursor = get_db().cursor()
    idHotel = request.args.get('id', '')


    sql="SELECT id_hotel as id," \
        "nom_hotel as nomHotel," \
        "nombre_chambre as nombreChambre," \
        "categorie,prix_base_chambre as prixBaseChambre, " \
        "date_creation as dateCreation ," \
        "photo," \
        "station_id " \
        "from hotel where id_hotel = %s"

    mycursor.execute(sql, (idHotel,))
    hotel = mycursor.fetchone()
    sql = "SELECT id_station as id," \
          " nom_station as nomStation" \
          " FROM station"
    mycursor.execute(sql)
    stations = mycursor.fetchall()
    return render_template('hotels/edit_hotels.html', hotel=hotel, stations=stations)




@app.route('/hotel/edit', methods=['POST'])
def valid_edit_hotels():
    mycursor = get_db().cursor()

    nomHotel = request.form['nomHotel']
    nombreChambre = request.form['nombreChambre']
    categorie = request.form['categorie']
    prixBaseChambre = request.form['prixBaseChambre']
    dateCreation = request.form['dateCreation']
    image = request.form['image']
    station_id = request.form['station_id']

    id = request.form.get('id', '')
    tuple_Insert = (nomHotel,nombreChambre,categorie,prixBaseChambre,dateCreation,image,station_id,id)

    sql = "UPDATE hotel " \
          "SET nom_hotel = %s," \
          " nombre_chambre = %s, " \
          " categorie = %s," \
          " prix_base_chambre=%s ," \
          " date_creation = %s, " \
          " photo = %s," \
          " station_id = %s WHERE id_hotel = %s"
    mycursor.execute(sql,tuple_Insert)
    get_db().commit()
    print(u'Hotel modifié id : ', id, " ,nomHotel :" , nomHotel ," ,nombreChambre : " , nombreChambre , " ,categorie : ",categorie , " prixBaseChambre : ", prixBaseChambre, " ,dateCreation : ",dateCreation, " ,image : ",image," ,station_id : ",station_id)
    message='Hotel modifié -> id : ' + id +u',  nom : '+ nomHotel + " , nombre de Chambre : " + nombreChambre + " ,  categorie : " + categorie + " , prix d'une Chambre : " + prixBaseChambre +" , date de Creation : "+dateCreation + " , image : " + image + " , station : "+ station_id

    flash(message, 'alert-success')
    return redirect('/hotel/show')




@app.route('/hotel/filtre',methods=['GET'])
def filtre_hotel():

    mycursor = get_db().cursor()
    sql = "SELECT id_hotel as id," \
          "nom_hotel as nomHotel," \
          "nombre_chambre as nombreChambre ," \
          "categorie," \
          "prix_base_chambre as prixBaseChambre," \
          "date_creation as dateCreation ," \
          "photo as image,"  \
          "station_id FROM hotel "

    list_param = []
    condition_and = " "

    if 'filter_word' in session or 'filter_value_min' in session \
            or 'filter_value_max' in session or 'filter_items' in session :
        sql = sql + " WHERE "
    if 'filter_word' in session :
        sql = sql + " nom_hotel LIKE %s "
        recherche = "%" + session['filter_word'] + "%"
        list_param.append(recherche)
        condition_and = " AND "
    if 'filter_value_min' in session or 'filter_value_max' in session :
        sql = sql + condition_and + "prix_base_chambre BETWEEN %s AND %s "
        list_param.append(session['filter_value_min'])
        list_param.append(session['filter_value_max'])
        condition_and = " AND "
    if "filter_items" in session :
        sql = sql + condition_and + "("
        last_item = session['filter_items'][-1]
        for item in session['filter_items']:
            sql = sql + " station_id = %s "
            if last_item != item:
                sql = sql + " or "
            list_param.append(item)
        sql = sql + ")"
    tuple_sql = tuple(list_param)
    print(sql)
    print(tuple_sql)

    mycursor.execute(sql,tuple_sql)
    hotels = mycursor.fetchall()
    sql = "SELECT id_station as id, " \
          " nom_station as nomStation, " \
          " altitude as altitude FROM station ;"
    mycursor.execute(sql)
    stations = mycursor.fetchall()
    return render_template('hotels/filtre_hotel.html',
                           hotels=hotels, stations=stations)


@app.route ('/hotel/filtre', methods=['POST'])
def filtre_hotels_valid():

    mycursor = get_db().cursor()

    filter_word = request.form.get('filter_word', None)
    filter_value_min = request.form.get('filter_value_min', None)
    filter_value_max = request.form.get('filter_value_max', None)
    filter_items = request.form.getlist('filter_items', None)
    if filter_word and filter_word != "":
        if len(filter_word) > 1 :
            if filter_word.isalpha():
                session['filter_word'] = filter_word
                flash('votre mot recherche est "' + filter_word +'"','alert-success' )
            else:
                flash('votre mot recherche doit etre composé uniquement de lettre ','alert-warning')
        else :
            if len(filter_word) <= 1:
                flash('votre mot recherché doit etre composé de au moins 2 lettre ','alert-warning')
    else:
        session.pop('filter_word',None)

    if filter_value_min or filter_value_max:
        if filter_value_min.isdecimal() and filter_value_max.isdecimal():
            if int(filter_value_min) < int(filter_value_max):
                session['filter_value_min'] = filter_value_min
                session['filter_value_max'] = filter_value_max
                message = u'filtre sur la colonne avec un prix entre ' + filter_value_min + ' et ' + filter_value_max
                flash(message, 'alert-success')
            else:
                message = u'min<max'
                flash(message, 'alert-warning')
        else:
            message = u'min ET max doivent etre rempli de numeriques'
            flash(message, 'alert-warning')
    else:
        session.pop('filter_value_min',None)
        session.pop('filter_value_max', None)
    if filter_items and filter_items != []:
        message = u'case à cocher selectionner : '
        check = True
        for number_type in filter_items :
            message = message +' - '+ number_type + ' -'
            if not number_type.isdecimal():
                check = False
        if check :
            session['filter_items'] = filter_items
        flash(message,'alert-success')
    else:
        session.pop('filter_items',None)
    return redirect('/hotel/filtre')



@app.route('/hotel/filtre_suppr',methods=['GET'])
def filtre_hotel_suppr():
    session.pop('filter_word', None)
    session.pop('filter_value_min', None)
    session.pop('filter_value_max', None)
    session.pop('filter_items', None)
    return redirect('/hotel/filtre')



@app.route('/hotel/etat_show',methods=['GET'])
def show_hotel_etat():
    mycursor = get_db().cursor()
    sql = "select  nom_station, round(avg(h.prix_base_chambre),2) as moyenne, count(h.id_hotel) as quantite from station " \
          "left join hotel h on station.id_station = h.station_id " \
          "group by  nom_station " \
          "order by nom_station ;"
    mycursor.execute(sql)
    etat1 = mycursor.fetchall()


    return render_template('hotels/etat_hotels.html',etat1 = etat1)



if __name__ == '__main__':
    app.run()
















