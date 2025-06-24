package test;

import com.robotcleaner.application.CleanCommandHandler;
import com.robotcleaner.infrastructure.RobotController;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for RobotController Class. Mocks are used
 * to avoid replicate same logic as the Integration test
 */
public class RobotControllerTest {

    @Mocked
    private CleanCommandHandler mockHandler;
    private RobotController controller;

    @BeforeEach
    void setUp() {
        controller = new RobotController(mockHandler);
    }

    @Test
    void testExecuteCleanSuccess() {
        String filePath = "input.txt";

        // Simulate file content
        List<String> mockInputLines = Arrays.asList(
                "5 5",
                "1 2 N",
                "LMLMLMLMM"
        );

        // Expected result from cleanCommandHandler
        List<String> expectedOutput = Arrays.asList("1 3 N");

        // Mock readLines and handler behavior
        new Expectations(controller) {{
            controller.readLines(filePath);
            result = mockInputLines;

            mockHandler.execute((CleanCommandHandler.CleanCommandDTO) any);
            result = expectedOutput;
        }};

        List<String> result = controller.executeClean(filePath);

        assertEquals(expectedOutput, result);
    }

    @Test
    void testRobotControllerErrorWhenReadingFileDoesNotExist() {
        String file = "instructions_other_example.txt";
        try {
            controller.executeClean(file);
        } catch (RuntimeException e) {
            assertEquals("Failed to read instruction file\n", e.getMessage());
        }
    }

}
