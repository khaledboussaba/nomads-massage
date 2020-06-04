TITLE RUN WEB APP
cd ..
call mvn -f nomadsProjectSpringBootJsfWeb install -Dmaven.test.skip=true
call java -jar -Dspring.profiles.active=configEclipse,initData nomadsProjectSpringBootJsfWeb\target\nomadsProjectSpringBootJsfWeb.jar
pause

