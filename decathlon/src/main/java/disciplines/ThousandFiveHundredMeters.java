package disciplines;

import countTools.unitConverter;

public class ThousandFiveHundredMeters extends Discipline {
    private static final double PARAM_A = 0.03768;
    private static final double PARAM_B = 480;
    private static final double PARAM_C = 1.85;
    private static final boolean IS_TRACK_EVENT = false;

    public ThousandFiveHundredMeters() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return unitConverter.MinutesToSeconds(result);
    }

    @Override
    public String toString() {
        return "ThousandFiveHundredMetersRun";
    }
}
