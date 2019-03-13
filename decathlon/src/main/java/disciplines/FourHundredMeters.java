package disciplines;

public class FourHundredMeters extends Discipline {
    private static final double PARAM_A = 1.53775;
    private static final double PARAM_B = 82;
    private static final double PARAM_C = 1.81;
    private static final boolean IS_TRACK_EVENT = true;

    public FourHundredMeters() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }


    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return Double.parseDouble(result);
    }

    @Override
    public String toString() {
        return "FourHundredMetersRun";
    }
}
