mysql --user=ttherezi  --password=0806 --database=BDD_ttherezi --host=serveurmysql.iut-bm.univ-fcomte.fr  < sql_projet.sql
python3 -m flask --debug  --app app  run  --host 0.0.0.0
