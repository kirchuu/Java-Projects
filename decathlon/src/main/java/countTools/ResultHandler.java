package countTools;

import disciplines.Discipline;
import disciplines.DisciplineHandler;
import participant.Participant;

import java.util.Collections;
import java.util.List;

public class ResultHandler {

    public void calculateScores(List<Participant> participantList) {
        for (Participant participant : participantList) {
            int totalScore = getTotalScore(participant.getResults());
            participant.setTotalScore(Integer.toString(totalScore));
        }
    }

    private int getTotalScore(List<String> participantResults) {
        return calculateTotalScoreForParticipant(participantResults);
    }

    private int calculateTotalScoreForParticipant(List<String> participantResults) {
        int totalScore = 0;
        for (int i = 0; i < participantResults.size(); i++) {
            String result = participantResults.get(i);
            totalScore += calculateSingleScore(i, result);
        }
        return totalScore;
    }

    private int calculateSingleScore(int index, String result) {
        List<Discipline> disciplineList = DisciplineHandler.getDisciplinesList();
        Discipline discipline = disciplineList.get(index);
        double parsedToDoubleValue = discipline.convertResultToSpecificDiscipline(result);
        return new ScoreCalculator(discipline, parsedToDoubleValue).calculateScore();
    }

    public void sortListByTotalScore(List<Participant> list) {
        Collections.sort(list);
        Collections.reverse(list);
    }
}
