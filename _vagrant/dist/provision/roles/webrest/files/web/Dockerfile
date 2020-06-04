FROM openjdk:8-jre

COPY ./web/nomadsProjectSpringBootJsfWeb.jar nomadsWeb.jar

ENTRYPOINT ["java","-Dspring.profiles.active=initData,configProd","-Djava.security.edg=file:/dev/.urandom","-jar","/nomadsWeb.jar"]
