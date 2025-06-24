README FILE FOR ROBOT-CLEANER PROJECT
- Author: Diego Hernández

DOMAIN MODEL CHOSEN

- The project has been structured around the Model Aggregated Root
classes of Grid and Robot, as they have been identified as the
major actors for this exercise. The rest of the Model classes are
mainly Value Objects that allow the Aggregated Root classes to set
their properties, and define and check specific constrains.

- There is also a Command Handler in the Application Layer, that
orchestrates the main behavior of the clean execution, which contains
also a CommandDTO to be executed and a list of Robot DTOs related to
capabilities and instructions of each robot, getting primitive values
for each parameter. This Command Handler gets a single CommandDTO
with all the information read from input file for the Grid and all
the robots, and for each RobotDTO, creates all the Domain classes
and executes the instructions for each robot, as well as the output
which each robot returns.

- In the Infrastructure Layer, it has been included a Controller to
read directly the instructions from a text file, and after getting
the commands input, creates a list to save each RobotDTO capabilities
and instructions to be executed by the Command Handler Orchestrator.

- Finally, the entry point for the whole program has been set as an
Main class, by initialising the Infrastructure layer to start the
execution, providing an instruction file saved on the resources'
folder.

-------PROJECT STRUCTURE--------

robot-cleaner/
├── pom.xml
├── .gitignore
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── application/
│   │   │   │   └── CleanCommandHandler.java
│   │   │   ├── domain/
│   │   │   │   ├── model/
│   │   │   │   │   ├── Grid.java
│   │   │   │   │   ├── GridLength.java
│   │   │   │   │   ├── GridWidth.java
│   │   │   │   │   ├── Instructions.java
│   │   │   │   │   ├── Orientation.java
│   │   │   │   │   ├── Position.java
│   │   │   │   │   └── Robot.java
│   │   │   ├── infrastructure/
│   │   │   │   └── RobotController.java
│   │   │   └── Main.java
│   │   └── resources/
│   │       └── clean_instructions.txt
│   └── test/
│       ├── java/
│       │   └── test/
│       │       ├── CleanCommandHandlerTest.java
│       │       ├── IntegrationTest.java
│       │       └── RobotControllerTest.java
│       └── resources/
│           ├── instructions_example.txt
│           └── wrong_instructions_example.txt


GENERAL ASSUMPTIONS

- Input instructions are considered as a file input type, instead of other
input systems procedures, such as console input, http input, etc.
File inputs are always considered as created on right format. Validations
should be added for increased robustness, but in this exercise they
have not been included for simplicity.
Also, the assumed entry point for Maintenance Department mentioned on the
Technical Test document will be the src/main/resources folder.
In a real environment, maybe such behavior could be included as a
SFTP connection to allow Maintenance Department to leave the files on an
internal directory of their own systems.

- The program does not save the state of execution, so all execution is set
in one continuous thread, for simplicity. To improve the solution and provide
stability and reliability, it would be necessary to incorporate some kind of
persistence system, chosen depending on the cost of the project and the
complexity of the program. With this, the main aim would be to save the
configuration of the cleaning Grid Layout, the execution sequence of each robot,
the state of the robots at each moment, so that if the process is stopped for
any internal or external reason, when restarting the program, it would be
possible to choose whether to resume execution or start again.

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
