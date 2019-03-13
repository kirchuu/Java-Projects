package disciplines;

public class ShotPut extends Discipline {
    private static final double PARAM_A = 51.39;
    private static final double PARAM_B = 1.5;
    private static final double PARAM_C = 1.05;
    private static final boolean IS_TRACK_EVENT = true;

    public ShotPut() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return Double.parseDouble(result);
    }

    @Override
    public String toString() {
        return "ShotPut";
    }
}
