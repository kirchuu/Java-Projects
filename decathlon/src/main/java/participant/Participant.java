package participant;

import java.util.ArrayList;
import java.util.List;

public class Participant implements Comparable<Participant>{
    private String name;
    private List<String> results;
    private String totalScore;

    public Participant() {
        results = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getResults() { return results; }

    public void addResult(String value) {
        results.add(value);
    }

    public String getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(String totalScore) {
        this.totalScore = totalScore;
    }

    @Override
    public int compareTo(Participant participant) {
        return getTotalScore().compareTo(participant.getTotalScore());
    }
}
