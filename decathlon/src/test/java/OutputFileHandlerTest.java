import fileHandler.InputFileHandler;
import fileHandler.OutputFileHandler;
import org.junit.jupiter.api.Test;
import participant.Participant;

import java.util.ArrayList;
import java.util.List;

class OutputFileHandlerTest {

    @Test
    public void writeScoreTableToXML_EmptyParticipantList() {
        String outputFilePath = "src/test/resources/outputFile/empty.xml";
        List<Participant> participantList = new ArrayList<>();
        writeToXML(participantList, outputFilePath);
    }

    @Test
    public void writeScoreTableToXML_ParticipantObjectWithNoParams() {
        String outputFilePath = "src/test/resources/outputFile/emptyTotalResults.xml";
        List<Participant> participantList = new ArrayList<>();
        participantList.add(new Participant());
        writeToXML(participantList, outputFilePath);
    }

    @Test
    public void writeScoreTableToXML_ProperParticipantList() {
        String outputFilePath = "src/test/resources/outputFile/correct.xml";
        String inputFilePath = "src/test/resources/inputFile/correct.csv";
        InputFileHandler inputFileHandler = new InputFileHandler();
        List<Participant> participantData = inputFileHandler.getParticipantData(inputFilePath);
        writeToXML(participantData, outputFilePath);
    }

    private void writeToXML(List<Participant> participantList, String filePath) {
        new OutputFileHandler().writeScoreTableToXML(participantList, filePath);
    }
}