#! /usr/bin/python
# -*- coding:utf-8 -*-
from flask import Flask, request, render_template, redirect, url_for, abort, flash

app = Flask(__name__)
app.secret_key = 'une cle(token) : grain de sel(any random string)'

stations=[
    { 'id' : 1, 'nomStation':'OZAN', 'altitude' :'206'},
    { 'id' : 2, 'nomStation':'CORMORANCHE-SUR-SAONE', 'altitude' :'211'},
    { 'id' : 3, 'nomStation':'PLAGNE', 'altitude' :'922'},
    { 'id' : 4, 'nomStation':'TOSSIAT', 'altitude' :'501'},
    { 'id' : 5, 'nomStation':'POUILLAT', 'altitude' :'770'}
]

hotels=[
    {'id' : 1, 'nomHotel':'Le saint joseph ', 'nombreChambre' :'16' ,  'categorie' :'2' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-02-03' ,  'station_id' :1},
    {'id' : 2, 'nomHotel':'La castana', 'nombreChambre' :'83' ,  'categorie' :'3' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-28' ,  'station_id' :2},
    {'id' : 3, 'nomHotel':'Grand Baraille', 'nombreChambre' :'46' ,  'categorie' :'3' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-05' ,  'station_id' :3},
    {'id' : 4, 'nomHotel':'Pershing hall', 'nombreChambre' :'26' ,  'categorie' :'4' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-29' ,  'station_id' :4},
    {'id' : 5, 'nomHotel':'Villa Gallici', 'nombreChambre' :'470' ,  'categorie' :'1' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-30' ,  'station_id' :5},
    {'id' : 6, 'nomHotel':'Mandarin oriental party', 'nombreChambre' :'14' ,  'categorie' :'4' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-29' ,  'station_id' :1},
    {'id' : 7, 'nomHotel':'Roch hotel et spa', 'nombreChambre' :'71' ,  'categorie' :'4' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-30' ,  'station_id' :2},
    {'id' : 8, 'nomHotel':'Villa lara', 'nombreChambre' :'570' ,  'categorie' :'1' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-23' ,  'station_id' :3},
    {'id' : 9, 'nomHotel':'La reserve', 'nombreChambre' :'6' ,  'categorie' :'5' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-24' ,  'station_id' :4},
    {'id' : 10, 'nomHotel':'residence de france', 'nombreChambre' :'65' ,  'categorie' :'5' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-29' ,  'station_id' :1},
    {'id' : 11, 'nomHotel':'antibes les beau près' ,  'nombreChambre' :'36' ,  'categorie' :'4' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-21' ,  'station_id' :2},
    {'id' : 12, 'nomHotel':'le savoie', 'nombreChambre' :'585' ,  'categorie' :'1' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-18' ,  'station_id' :3},
    {'id' : 13, 'nomHotel':'hotel juana', 'nombreChambre' :'68' ,  'categorie' :'3' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-16' ,  'station_id' :4},
    {'id' : 14, 'nomHotel':'le sereno', 'nombreChambre' :'455' ,  'categorie' :'3' ,  'prixBaseChambre':'51.5', 'dateCreation' :'2017-04-14' ,  'station_id' :5},
]



@app.route('/')
def show_accueil():
    return render_template('layout.html')

if __name__ == '__main__':
    app.run()

@app.route('/station/show')
def show_stations():
    return render_template('stations/show_stations.html', stations=stations)

@app.route('/hotel/show')
def show_hotels():
    return render_template('hotels/show_hotels.html', hotels=hotels)





@app.route('/station/add', methods=['GET'])
def add_stations():
    return render_template('stations/add_stations.html')

@app.route('/hotel/add', methods=['GET'])
def add_hotels():
    return render_template('hotels/add_hotels.html' ,stations=stations)






@app.route('/station/add', methods=['POST'])
def valid_add_stations():
    nomStation = request.form.get('nomStation', '')
    print(u'station ajouté , nomStation :', nomStation)
    altitude = request.form.get('altitude', '')
    print(u'station ajouté , altitude :', altitude)
    message = u'station ajouté , nomStation :'+nomStation + ', altitude : ' +altitude
    flash(message, 'alert-success')
    return redirect('/station/show')

@app.route('/hotel/add', methods=['POST'])
def valid_add_hotels():
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
    station_id = request.form.get('station_id', '')
    print(u'station ajouté , station_id :', station_id)
    message = u'station ajouté , nom :'+nomHotel + u', nombre de Chambre : ' +nombreChambre  + u', categorie : ' +categorie +u', prix de base d\'une Chambre : ' + prixBaseChambre + u', date de Creation : ' + dateCreation + u', station_id : ' + station_id
    flash(message, 'alert-success')
    return redirect('/hotel/show')


@app.route('/station/delete', methods=['GET'])
def delete_stations():
    id = request.args.get('id', '')
    print ("une station supprimé, id :",id)
    message=u'une station supprimé, id : ' + id
    flash(message, 'alert-warning')
    return redirect('/station/show')

@app.route('/hotel/delete', methods=['GET'])
def delete_hotels():
    id = request.args.get('id', '')
    print ("un hotel supprimé, id :",id)
    message=u'un hotel supprimé, id : ' + id
    flash(message, 'alert-warning')
    return redirect('/hotel/show')



@app.route('/station/edit', methods=['GET'])
def edit_stations():
    id = request.args.get('id', '')
    #nomStation = request.args.get('nomStation', '')     # comment passé plusieurs paramètres (clé primaire composés)
    #altitude = request.args.get('altitude', '')
    id=int(id)
    station = stations[id-1]
    return render_template('stations/edit_station.html', station=station)



@app.route('/station/edit', methods=['POST'])
def valid_edit_stations():
    nomStation = request.form['nomStation']
    altitude = request.form['altitude']
    id = request.form.get('id', '')
    print(u'type Station, id: ', id , " nomStation :" , nomStation ," altitude : " , altitude)
    message=u'Station modifié, '+ " nomStation :"+ nomStation + ",  altitude : " + altitude
    flash(message, 'alert-success')
    return redirect('/station/show')





@app.route('/hotel/edit', methods=['GET'])
def edit_hotels():
    id = request.args.get('id', '')
    nomHotel = request.args.get('nomHotel', '')     # comment passé plusieurs paramètres (clé primaire composés)
    nombreChambre = request.args.get('nombreChambre', '')
    categorie = request.args.get('categorie', '')
    prixBaseChambre = request.args.get('prixBaseChambre', '')
    dateCreation = request.args.get('dateCreation', '')
    station_id = request.args.get('station_id', '')
    id=int(id)
    hotel = hotels[id-1]
    return render_template('hotels/edit_hotels.html', hotel=hotel, stations=stations)



@app.route('/hotel/edit', methods=['POST'])
def valid_edit_hotels():
    nomHotel = request.form['nomHotel']
    nombreChambre = request.form['nombreChambre']
    categorie = request.form['categorie']
    prixBaseChambre = request.form['prixBaseChambre']
    dateCreation = request.form['dateCreation']
    station_id = request.form['station_id']
    id = request.form.get('id', '')
    print(u'Hotel modifié id : ', id, "nomHotel :" , nomHotel ," nombreChambre : " , nombreChambre , " categorie : ",categorie , " prixBaseChambre : ", prixBaseChambre, " dateCreation : ",dateCreation," station_id : ",station_id)
    message=u'Hotel modifié, nomHotel : '+ nomHotel + ", nombreChambre : " + nombreChambre + ",  categorie : " + categorie + ", prixBaseChambre : " + prixBaseChambre +", dateCreation : "+dateCreation+ ", station_id : "+ station_id
    flash(message, 'alert-success')
    return redirect('/hotel/show')



@app.route ('/hotel/filtre', methods=['GET'])
def filtre_hotels():
    filter_word = request.args.get('filter_word',None)
    filter_value_min = request.args.get('filter_value_min',None)
    filter_value_max = request.args.get('filter_value_max',None)
    filter_items = request.args.getlist('filter_items',None)
    if filter_word and  filter_word != "":
        message = u'filtre sur le mot : ' + filter_word
        flash(message, 'alert-success')
    if filter_value_min or filter_value_max:
        if filter_value_min.isdecimal() and filter_value_max.isdecimal():
            if int(filter_value_min) < int(filter_value_max) :
                message = u'filtre sur la colonne avec un prix entre ' + filter_value_min + ' et ' + filter_value_max
                flash(message, 'alerte-success')
            else:
                message= u'min<max'
                flash(message, 'alert-warning')
        else:
            message = u'min et max doivent etre des numeriques'
            flash(message, 'alert-warning')
    if filter_items and filter_items != []:
        message= u'case à cocher selectionner : '
        for case in filter_items :
            message += 'id ' +case + ' '
        flash(message,'alert-success')
    return render_template('hotels/filtre_hotel.html',hotels=hotels,stations=stations)




















