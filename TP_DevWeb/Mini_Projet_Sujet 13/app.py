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

@app.route('/stations/show')
def show_stations():
    #print(stations)
    return render_template('stations/show_stations.html', stations=stations)

@app.route('/stations/add', methods=['GET'])
def add_stations():
    return render_template('stations/add_stations.html')


@app.route('/stations/add', methods=['POST'])
def valid_add_stations():
    nomStation = request.form.get('nomStation', '')
    print(u'Station , nom :', nomStation)
    message = u'Station ajouté , nom :'+nomStation
    flash(message, 'alert-success')
    return redirect('/stations/show')


@app.route('/stations/delete', methods=['GET'])
def delete_type_article():
    id = request.args.get('id', '')
    print ("une station supprimé, id :",id)
    message=u'une station de supprimé, id : ' + id
    flash(message, 'alert-warning')
    return redirect('/stations/show')


@app.route ('stations/edit', methods=['GET'])
def edit_stations():
    id = request.args.get('id','')
    nomStations = request.args.get('nomStation','')
    id = int(id)
















