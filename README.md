# Travel Package Manager

This application is used to manage several packages that contain details regarding destinations and the activites present in the destinations, It also keeps a record of how many people have enrolled in this package.
## Description

### Introduction
* The application is built with DTO layer, Service layers, Exchange classes, Exceptions and multiple helper functions.
* The Data transfer object layer consists of classes like TravelPackage, Activity, Destination and Passenger. These are
  transferred from one layer to another.
* The service layer consists of the functions that contain the business logic needed to print out the required details.
* The results of the service layer is mapped to classes contained in exchanges.
* The signUp service is used to register a passenger to an activity. It uses balance update function based on its category
  which is provided using a Factory Method.
* The print functions are present in Printer Package.
* The Test package contains different test methods verifying different functionalities of the application.

### Methodology
* High Level Block Diagram : https://drive.google.com/file/d/10MKxaco9xEnSkE8UkPKbHoZ7v-8x1UsH/view?usp=sharing
* Low level Class Diagram : https://drive.google.com/file/d/1xllzKkfyl2UuFyP_U2rtuqgSiuhkAfdt/view?usp=sharing

### Results
* Checking if a passenger gets a gold discount while signing up.

![Alt text](https://github.com/sahil-13399/Travel-Application-Nymble/blob/master/pic1.png)

* Checking if a single passenger and multiple passenger details are being printed

![Alt text](https://github.com/sahil-13399/Travel-Application-Nymble/blob/master/pic2.png)

## Getting Started

### Dependencies

* Windows/MacOS/Ubuntu
* IntelliJ IDEA or VSCode
* SpringBoot
* Gradle

### Installing

* Clone the repo and open it in your IDE
* The gradle build tool will take care of the dependencies
* Run the TravelApplication Class to check if the code is working or not

### Executing program

* Build the program (Run the tests)
```
./gradlew build
```
* Run the SpringBoot Application
```
./gradlew bootRun
```

## Help

Any advise for common problems or issues. Run the following in terminal
```
./gradlew build --stacktrace --info
```

## Authors

Contributors names and contact info

ex. Sahil Samantaray, sahil13399@gmail.com

## Acknowledgements
* https://www.baeldung.com/
* https://stackoverflow.com/
* https://www.journaldev.com/
