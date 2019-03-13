package fileHandler;

import participant.Participant;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileHandler {
    private static final String CSV_DELIMITER = ";";

    public List<Participant> getParticipantData(String filePath) {
        return createParticipantList(filePath);
    }

    private List<Participant> createParticipantList(String filePath) {
        List<Participant> participantList = new ArrayList<>();
        return readInputFile(filePath, participantList);
    }

    public List<Participant> readInputFile(String filepath, List<Participant> participantList) {
        String line;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            while ((line = reader.readLine()) != null) {
                participantList.add(createNewParticipantWithResults(line));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return participantList;
    }

    private Participant createNewParticipantWithResults(String resultString) {
        Participant participant = new Participant();
        addResultsToParticipant(participant, resultString);
        return participant;
    }

    private void addResultsToParticipant(Participant participant, String resultString) {
        String[] results = createResultsStringArray(resultString);
        fillParticipantListData(participant, results);
    }

    private String[] createResultsStringArray(String line) {
        return splitByDelimiter(line);
    }

    private String[] splitByDelimiter(String line) {
        return line.split(CSV_DELIMITER);
    }

    private void fillParticipantListData(Participant participant, String[] values) {
        for (int i = 0; i < values.length; i++) {
            if (i == 0) {
                participant.setName(values[0]);
            } else {
                if (isValueNumeric(values[i])) {
                    participant.addResult(values[i]);
                } else {
                    participant.addResult("0");
                }
            }
        }
    }

    private boolean isValueNumeric(String value) {
        for (Character c: value.toCharArray()) {
            if (c != '.' && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}