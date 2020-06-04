FROM openjdk:8-jre

COPY ./rest/nomadsProjectSpringBootJsfWsRest-0.0.1-SNAPSHOT.jar nomadsRest.jar

COPY ./rest/wait-for-it.sh wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["java","-Dspring.profiles.active=initData,configProd","-Djava.security.edg=file:/dev/.urandom","-jar","/nomadsRest.jar"]
