TITLE INSTALL ITF AND PACKAGE ALL (MAIN RUN)

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

call mvn -f nomadsProjectSpringBootJsfWsRest package -Dmaven.test.skip=true
call mvn -f nomadsProjectSpringBootJsfWeb package -Dmaven.test.skip=true
call mvn -f AnnuaireMasseur package -Dmaven.test.skip=true
call mvn -f wsRestCurrencies package -Dmaven.test.skip=true
call mvn -f nomadsProjectStocks package -Dmaven.test.skip=true


