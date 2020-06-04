TITLE COMPILE AND RUN REST MACRO SERVICE
cd ..
call mvn -f nomadsProjectSpringBootJsfWsRest install -Dmaven.test.skip=true
call java -jar -Dspring.profiles.active=configEclipse,initData nomadsProjectSpringBootJsfWsRest\target\nomadsProjectSpringBootJsfWsRest-0.0.1-SNAPSHOT.jar
pause
