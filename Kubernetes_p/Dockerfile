FROM maven:3.6.2-jdk-8-openj9

RUN apt-get update -y
RUN apt-get --assume-yes install git
RUN git clone "https://Mykhailo25:250597950815Misha@github.com/niebieska/Projekt_PSI_implementacja"
RUN cd Projekt_PSI_implementacja/ && git checkout lokalny
RUN cd Projekt_PSI_implementacja/SystemKadrowy/HRSystem && mvn clean install 

