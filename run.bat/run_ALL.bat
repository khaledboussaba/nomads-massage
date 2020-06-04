TITLE INSTALL ITF AND COMPILE ALL (MAIN RUN)

cd ..

call mvn -f AnnuaireMasseurItf clean install -Dmaven.test.skip=true
call mvn -f nomadsProjectStocksItf clean install -Dmaven.test.skip=true
call mvn -f wsRestCurrenciesItf clean install -Dmaven.test.skip=true
call mvn -f nomadsProjectSpringBootJsfItf clean install -Dmaven.test.skip=true

call mvn -f nomadsProjectSpringBootJsfWsRest clean  
call mvn -f nomadsProjectSpringBootJsfWeb clean 
call mvn -f AnnuaireMasseur clean
call mvn -f wsRestCurrencies clean 
call mvn -f nomadsProjectStocks clean 

call mvn -f nomadsProjectSpringBootJsfWsRest install -Dmaven.test.skip=true
call mvn -f nomadsProjectSpringBootJsfWeb install -Dmaven.test.skip=true
call mvn -f AnnuaireMasseur install -Dmaven.test.skip=true
call mvn -f wsRestCurrencies install -Dmaven.test.skip=true
call mvn -f nomadsProjectStocks install -Dmaven.test.skip=true

START run.bat\run\run000.startMongo.bat
START run.bat\run\run010.currency.bat
START run.bat\run\run020.stock.bat
START run.bat\run\run030.annuaire.bat
START run.bat\run\run040.nodeLogDatabase.bat
timeout /t 20
START run.bat\run\run050.rest.bat
timeout /t 20
START run.bat\run\run060.web.bat
pause

