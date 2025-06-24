package test;

import com.robotcleaner.application.CleanCommandHandler;
import com.robotcleaner.infrastructure.RobotController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationTest {

    @Test
    void testAllFunctionalitySuccess() {
        String file = "instructions_example.txt";

        CleanCommandHandler cleanCommandHandler = new CleanCommandHandler();
        RobotController robotController = new RobotController(cleanCommandHandler);
        List<String> output = robotController.executeClean(file);
        List<String> expectedOutput = List.of("1 3 N");

        assertEquals(1, output.size());
        assertEquals(expectedOutput, output);
    }

    @Test
    void testAllFunctionalityWithWrongInstructions() {
        String file = "wrong_instructions_example.txt";

        CleanCommandHandler cleanCommandHandler = new CleanCommandHandler();
        RobotController robotController = new RobotController(cleanCommandHandler);
        try {
            robotController.executeClean(file);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid instruction: X", e.getMessage());
        }
    }
}
