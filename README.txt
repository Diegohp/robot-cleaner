README FILE FOR ROBOT-CLEANER PROJECT
- Author: Diego Hernández

DOMAIN MODEL CHOSEN

- The project has been structured around the Model Aggregated Root
classes of Grid and Robot, as they have been identified as the
major actors for this exercise. The rest of the Model classes are
mainly Value Objects that allow the Aggregated Root classes to set
their properties, and define and check specific constrains.

-------PROJECT STRUCTURE--------

robot-cleaner/
├── pom.xml
├── .gitignore
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── application/
│   │   │   ├── domain/
│   │   │   ├── infrastructure/
│   │   │   └── Main.java
│   │   └── resources/
│   └── test/
│       ├── java/
│       │   └── test/
│       └── resources/


GENERAL ASSUMPTIONS

- The program does not save the state of execution, so all execution is set
in one continuous thread, for simplicity. To improve the solution and provide
stability and reliability, it would be necessary to incorporate some kind of
persistence system, chosen depending on the cost of the project and the
complexity of the program.

- Entry point for this program has been set as the Main class, to
explicitly declare the execution of the program as an Integration Test of the
whole project.

- Due to the simplicity of the solution, Exceptions treatment and logging
has been excluded from the implementation.

BUILD AND RUN

Compile the project:
mvn clean install

Run the application:
mvn exec:java -Dexec.mainClass="Main"
