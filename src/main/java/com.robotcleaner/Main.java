

import application.CleanCommandHandler;
import infrastructure.RobotController;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Instructions file located in /resources folder
        String file = "clean_instructions.txt";

        // Initialisation of Robot Controller, getting also the lines from file input
        CleanCommandHandler cleanCommandHandler = new CleanCommandHandler();
        RobotController robotController = new RobotController(cleanCommandHandler);

        List<String> output = robotController.executeClean(file);

        // Printing the result of executing the clean over the input sequence
        output.forEach(System.out::println);
    }
}
