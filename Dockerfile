FROM openjdk:8
EXPOSE 8082
ADD target/IPTreatmentService.jar IPTreatmentService.jar
ENTRYPOINT ["java","-jar","/IPTreatmentService.jar"]