package countTools;

import disciplines.Discipline;

public class ScoreCalculator {
    private boolean isTrackEvent;
    private double participantResult;
    private double paramA;
    private double paramB;
    private double paramC;

    public ScoreCalculator(Discipline discipline, double participantResult) {
        if (discipline != null) {
            this.paramA = discipline.getParamA();
            this.paramB = discipline.getParamB();
            this.paramC = discipline.getParamC();
            this.isTrackEvent = discipline.getIsTrackEvent();
            this.participantResult = participantResult;
        }
    }

    public int calculateScore() {
        if (isTrackEvent) {
            return calculateTrackEventScore();
        } else {
            return calculateFieldEventScore();
        }
    }

    private int calculateTrackEventScore() {
        if (participantResult == 0) {
            return 0;
        }
        return (int) Math.rint(paramA * (Math.pow((Math.abs(paramB - participantResult)), paramC)));
    }

    private int calculateFieldEventScore() {
        if (participantResult == 0) {
            return 0;
        }
        return (int) Math.rint(paramA * (Math.pow((Math.abs(participantResult - paramB)), paramC)));
    }
}
