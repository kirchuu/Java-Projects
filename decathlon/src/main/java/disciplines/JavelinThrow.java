package disciplines;

public class JavelinThrow extends Discipline {
    private static final double PARAM_A = 10.14;
    private static final double PARAM_B = 7;
    private static final double PARAM_C = 1.08;
    private static final boolean IS_TRACK_EVENT = false;

    public JavelinThrow() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return Double.parseDouble(result);
    }

    @Override
    public String toString() {
        return "JavelinThrow";
    }
}
