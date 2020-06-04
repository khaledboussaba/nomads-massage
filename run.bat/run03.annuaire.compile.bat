TITLE COMPILE AND RUN ANNUAIRE SERVICE
cd ..
call mvn -f AnnuaireMasseur install -Dmaven.test.skip=true
call java -jar -Dspring.profiles.active=configEclipse,initData AnnuaireMasseur\target\AnnuaireMasseur-0.0.1-SNAPSHOT.jar
pause

