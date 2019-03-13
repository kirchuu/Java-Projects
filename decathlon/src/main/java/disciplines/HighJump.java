package disciplines;

import countTools.unitConverter;

public class HighJump extends Discipline {
    private static final double PARAM_A = 0.8465;
    private static final double PARAM_B = 75;
    private static final double PARAM_C = 1.42;
    private static final boolean IS_TRACK_EVENT = true;

    public HighJump() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return unitConverter.metersToCentimeters(result);
    }

    @Override
    public String toString() {
        return "HighJump";
    }
}
