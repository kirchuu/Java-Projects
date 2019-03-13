import countTools.ScoreCalculator;
import disciplines.Discipline;
import disciplines.HundredMeters;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ScoreCalculatorTest {

    @Test
    void countScore_ZeroValue() {
        Discipline hundredMeters = new HundredMeters();
        ScoreCalculator scoreCalculator = new ScoreCalculator(hundredMeters, 0.0);
        assertEquals(0, scoreCalculator.calculateScore());
    }

    @Test
    void countScore_CustomParticipantResultWithHundredMetersDiscipline() {
        double participantResultFromCSV = 12.61;
        Discipline hundredMeters = new HundredMeters();
        ScoreCalculator scoreCalculator = new ScoreCalculator(hundredMeters, participantResultFromCSV);
        assertEquals(537, scoreCalculator.calculateScore());
    }
}