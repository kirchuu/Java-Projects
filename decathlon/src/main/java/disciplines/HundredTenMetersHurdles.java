package disciplines;

public class HundredTenMetersHurdles extends Discipline {
    private static final double PARAM_A = 5.74352;
    private static final double PARAM_B = 28.5;
    private static final double PARAM_C = 1.92;
    private static final boolean IS_TRACK_EVENT = false;

    public HundredTenMetersHurdles() {
        super(PARAM_A, PARAM_B, PARAM_C, IS_TRACK_EVENT);
    }


    @Override
    public double convertResultToSpecificDiscipline(String result) {
        return Double.parseDouble(result);
    }

    @Override
    public String toString() {
        return "HundredTenMetersHurdles";
    }
}
