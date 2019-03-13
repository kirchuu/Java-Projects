import countTools.ResultHandler;
import fileHandler.InputFileHandler;
import fileHandler.OutputFileHandler;
import participant.Participant;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/inputFile/results.csv";
        String outputFilePath = "src/main/resources/outputFile/results.xml";
        InputFileHandler inputFileHandler = new InputFileHandler();
        ResultHandler resultHandler = new ResultHandler();

        List<Participant> participantData = inputFileHandler.getParticipantData(inputFilePath);
        resultHandler.calculateScores(participantData);
        resultHandler.sortListByTotalScore(participantData);
        new OutputFileHandler().writeScoreTableToXML(participantData, outputFilePath);
    }
}