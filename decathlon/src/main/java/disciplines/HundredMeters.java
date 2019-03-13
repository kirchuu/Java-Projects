package disciplines;

public class HundredMeters extends Discipline {
    private static final double PARAM_A = 25.4347;
    private static final double PARAM_B = 18;
    private static final double PARAM_C = 1.81;
    private static final boolean IS_TRACK_EVENT = true;

    public HundredMeters() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return Double.parseDouble(result);
    }

    @Override
    public String toString() {
        return "HundredMetersRun";
    }
}