TITLE CLEAN ALL

cd ..

call mvn -f AnnuaireMasseurItf clean 
call mvn -f nomadsProjectStocksItf clean 
call mvn -f wsRestCurrenciesItf clean 
call mvn -f nomadsProjectSpringBootJsfItf clean

call mvn -f nomadsProjectSpringBootJsfWsRest clean  
call mvn -f nomadsProjectSpringBootJsfWeb clean 
call mvn -f AnnuaireMasseur clean
call mvn -f wsRestCurrencies clean 
call mvn -f nomadsProjectStocks clean 
