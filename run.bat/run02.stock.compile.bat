TITLE COMPILE AND RUN STOCK SERVICE
cd ..
call mvn -f nomadsProjectStocks install -Dmaven.test.skip=true
call java -jar -Dspring.profiles.active=configEclipse,initData nomadsProjectStocks\target\nomadsProjectStocks-0.0.1-SNAPSHOT.jar
pause

