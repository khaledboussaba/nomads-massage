FROM openjdk:8-jre

COPY ./target/AnnuaireMasseur-0.0.1-SNAPSHOT.jar AnnuaireMasseur.jar

COPY ./wait-for-it.sh wait-for-it.sh
RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["java","-Dspring.profiles.active=initData,configProd","-Djava.security.edg=file:/dev/.urandom","-jar","/AnnuaireMasseur.jar"]
