package disciplines;

public abstract class Discipline {
    private double paramA;
    private double paramB;
    private double paramC;
    private boolean isTrackEvent;

    public Discipline(double paramA, double paramB, double paramC, boolean isTrackEvent) {
        this.paramA = paramA;
        this.paramB = paramB;
        this.paramC = paramC;
        this.isTrackEvent = isTrackEvent;
    }

    public double getParamA() {
        return paramA;
    }

    public double getParamB() {
        return paramB;
    }

    public double getParamC() {
        return paramC;
    }

    public boolean getIsTrackEvent() {
        return isTrackEvent;
    }

    public abstract double convertResultToSpecificDiscipline(String result);

    @Override
    public abstract String toString();
}
