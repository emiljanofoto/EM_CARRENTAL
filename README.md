EM_CarRental

This is a web-based application designed to function as a car rental service. 
Users can browse through a selection of available vehicles, pay for their chosen rental package, and then pick up their selected car. 
The primary motivation behind developing this application was to gain proficiency in JUnit and Mockito testing frameworks.

To build and run the application, ensure you have the following:

JDK 22
Maven 4 

Instructions to Run
Install MySQL.
Execute the command: git clone https://github.com/emiljanofoto/EM_CarRental.git
Navigate to the project directory: cd em_rental
Configure the datasource in main/resources/application.yml.(add your own password)

Execute command -  mvn clean install
Execute command - mvn spring-boot:run

The server is running on localhost:8080
The software is using Swagger, so after running navigate to:
http://localhost:8080/swagger-ui.html

To login, enter the username and password for the account with selected role:

User	user	  user 
or
Manager	manager	  manager
or
Admin	admin	  admin





NOTE: SoftWare is still under development!!!
