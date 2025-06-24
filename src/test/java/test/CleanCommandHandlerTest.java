package test;

import com.robotcleaner.application.CleanCommandHandler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit tests for CleanCommandHandler Class.
 */
public class CleanCommandHandlerTest {

    private final String expectedOutput = "2 2 E";
    private final int gridWidth = 2;
    private final int gridLength = 2;

    @Test
    void testCleanCommandHandlerSuccessExecution() {
        String instructions = "RM";
        List<CleanCommandHandler.CleanCommandDTO.RobotDTO> robots = new ArrayList<>();
        CleanCommandHandler.CleanCommandDTO.RobotDTO robotDTO=
                new CleanCommandHandler.CleanCommandDTO.RobotDTO(1,2,"N",
                        instructions.toCharArray());
        robots.add(robotDTO);
        CleanCommandHandler.CleanCommandDTO cleanCommandDTO
                = new CleanCommandHandler.CleanCommandDTO(gridWidth, gridLength, robots);
        CleanCommandHandler cleanCommandHandler = new CleanCommandHandler();
        List<String> endResult = cleanCommandHandler.execute(cleanCommandDTO);

        assertEquals(expectedOutput, endResult.get(0));
    }

    @Test
    void testCleanCommandHandlerOutOfGridExecution() {
        String instructions = "RMM";
        List<CleanCommandHandler.CleanCommandDTO.RobotDTO> robots = new ArrayList<>();
        CleanCommandHandler.CleanCommandDTO.RobotDTO robotDTO=
                new CleanCommandHandler.CleanCommandDTO.RobotDTO(1,2,"N",
                        instructions.toCharArray());
        robots.add(robotDTO);
        CleanCommandHandler.CleanCommandDTO cleanCommandDTO
                = new CleanCommandHandler.CleanCommandDTO(gridWidth, gridLength, robots);
        CleanCommandHandler cleanCommandHandler = new CleanCommandHandler();
        List<String> endResult = cleanCommandHandler.execute(cleanCommandDTO);

        assertEquals(expectedOutput, endResult.get(0));
    }

    @Test
    void testCleanCommandHandlerIllegalInstructionExecution() {
        String instructions = "XM";
        List<CleanCommandHandler.CleanCommandDTO.RobotDTO> robots = new ArrayList<>();
        CleanCommandHandler.CleanCommandDTO.RobotDTO robotDTO=
                new CleanCommandHandler.CleanCommandDTO.RobotDTO(1,2,"N",
                        instructions.toCharArray());
        robots.add(robotDTO);
        CleanCommandHandler.CleanCommandDTO cleanCommandDTO
                = new CleanCommandHandler.CleanCommandDTO(gridWidth, gridLength, robots);
        CleanCommandHandler cleanCommandHandler = new CleanCommandHandler();
        try {
            cleanCommandHandler.execute(cleanCommandDTO);
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid instruction: X", e.getMessage());
        }
    }

}
