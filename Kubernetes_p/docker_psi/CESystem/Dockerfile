FROM maven:3.6.2-jdk-8-openj9

RUN apt-get update -y
RUN apt-get --assume-yes install git
RUN git clone "https://github.com/niebieska/Projekt_PSI_implementacja"
RUN cd Projekt_PSI_implementacja/ 
RUN cd Projekt_PSI_implementacja/SystemZapisow/CourseEnrollmentSystem && mvn clean install 
CMD java -jar Projekt_PSI_implementacja/SystemZapisow/CourseEnrollmentSystem/target/CourseEnrollmentSystem-0.0.1-SNAPSHOT.jar
