package disciplines;


public class DiscusThrow extends Discipline {
    private static final double PARAM_A = 12.91;
    private static final double PARAM_B = 4;
    private static final double PARAM_C = 1.1;
    private static final boolean isTrackEvent = false;

    public DiscusThrow() {
        super(PARAM_A, PARAM_B, PARAM_C, isTrackEvent);
    }

    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return Double.parseDouble(result);
    }

    @Override
    public String toString() {
        return "DiscusThrow";
    }
}
