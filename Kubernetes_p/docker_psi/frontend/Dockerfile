FROM node:latest

RUN apt-get update -y
RUN apt-get --assume-yes install git
RUN git clone "https://github.com/niebieska/Projekt_PSI_implementacja"
RUN cd Projekt_PSI_implementacja/ 
RUN cd Projekt_PSI_implementacja/Frontend/assignment_system && npm install -g serve
CMD cd Projekt_PSI_implementacja/Frontend/assignment_system && serve -s build -l 3000
