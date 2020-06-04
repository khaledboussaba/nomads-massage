TITLE COMPILE AND RUN CURRENCIES SERVICE
cd ..
call mvn -f wsRestCurrencies install -Dmaven.test.skip=true
call java -jar -Dspring.profiles.active=configEclipse,initData wsRestCurrencies\target\wsRestCurrencies-0.0.1-SNAPSHOT.jar
pause

