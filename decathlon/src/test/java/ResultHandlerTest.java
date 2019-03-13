import countTools.ResultHandler;
import fileHandler.InputFileHandler;
import org.junit.jupiter.api.Test;
import participant.Participant;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultHandlerTest {

    @Test
    void calculateScores_EmptyParticipantList() {
        List<Participant> emptyList = new ArrayList<>();
        ResultHandler resultHandler = new ResultHandler();
        resultHandler.calculateScores(emptyList);
    }

    @Test
    void calculateScores_NonDigitValuesInParticipantResults() {
        String inputFilePath = "src/test/resources/inputFile/charsInResults.csv";
        InputFileHandler inputFileHandler = new InputFileHandler();
        List<Participant> participantData = inputFileHandler.getParticipantData(inputFilePath);
        new ResultHandler().calculateScores(participantData);
    }

    @Test
    void sortListByTotalScore_IncorrectDescendingOrder() {
        String[] resultArr = new String[]{"0", "1", "2"};
        List<Participant> participantList = createParticipantList();
        ResultHandler resultHandler = new ResultHandler();
        resultHandler.sortListByTotalScore(participantList);
        for (int i = 0; i < participantList.size(); i++) {
            Participant participant = participantList.get(i);
            assertNotEquals(resultArr[i], participant);
        }
    }

    @Test
    void sortListByTotalScore_CorrectAscendingOrder() {
        String[] resultArr = new String[] {"2", "1", "0"};
        List<Participant> participantList = createParticipantList();
        ResultHandler resultHandler = new ResultHandler();
        resultHandler.sortListByTotalScore(participantList);
        for (int i = 0; i < participantList.size(); i++) {
            Participant participant = participantList.get(i);
            assertEquals(resultArr[i], participant.getTotalScore());
        }
    }

    private List<Participant> createParticipantList() {
        List<Participant> participantList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Participant participant = new Participant();
            participant.setTotalScore(Integer.toString(i));
            participantList.add(participant);
        }
        return participantList;
    }
}