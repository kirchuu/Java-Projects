package disciplines;

import countTools.unitConverter;

public class PoleVault extends Discipline {
    private static final double PARAM_A = 0.2797;
    private static final double PARAM_B = 100;
    private static final double PARAM_C = 1.35;
    private static final boolean IS_TRACK_EVENT = false;

    public PoleVault() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return unitConverter.metersToCentimeters(result);
    }

    @Override
    public String toString() {
        return "PoleVault";
    }
}
