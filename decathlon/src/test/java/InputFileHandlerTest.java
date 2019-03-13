import fileHandler.InputFileHandler;
import org.junit.jupiter.api.Test;
import participant.Participant;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileHandlerTest {

    @Test
    public void getParticipantData_emptyCSV() {
        String inputFilePath = "src/test/resources/inputFile/empty.csv";
        List<Participant> expected = new ArrayList<>();
        List<Participant> actual = readFile(inputFilePath);
        assertEquals(expected, actual);
    }

    @Test
    public void getParticipantData_correctCSV() {
        String inputFilePath = "src/test/resources/inputFile/correct.csv";
        readFile(inputFilePath);
    }

    @Test
    void getParticipantData_BrokenCSV() {
        String inputFilePath = "src/test/resources/inputFile/charsInResults.csv";
        InputFileHandler inputFileHandler = new InputFileHandler();
        inputFileHandler.getParticipantData(inputFilePath);
    }

    private List<Participant> readFile(String inputFilePath) {
        InputFileHandler fileHandler = new InputFileHandler();
        return fileHandler.getParticipantData(inputFilePath);
    }
}