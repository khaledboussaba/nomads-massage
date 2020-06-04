FROM openjdk:8-jre

COPY ./target/nomadsProjectStocks-0.0.1-SNAPSHOT.jar nomadsProjectStocks.jar

COPY ./wait-for-it.sh wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["java","-Dspring.profiles.active=initData,configProd","-Djava.security.edg=file:/dev/.urandom","-jar","/nomadsProjectStocks.jar"]
