package disciplines;

import countTools.unitConverter;

public class LongJump extends Discipline{
    private static final double PARAM_A = 0.14354;
    private static final double PARAM_B = 220;
    private static final double PARAM_C = 1.4;
    private static final boolean IS_TRACK_EVENT = true;

    public LongJump() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return unitConverter.metersToCentimeters(result);
    }

    @Override
    public String toString() {
        return "LongJump";
    }
}
