package countTools;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class unitConverterTest {

    @Test
    void metersToCentimeters() {
       assertEquals(500.0, unitConverter.metersToCentimeters("5.0"));
       assertEquals(0.0, unitConverter.metersToCentimeters(""));
    }

    @Test
    void minutesToSeconds() {
        assertEquals(325.72, unitConverter.MinutesToSeconds("5.25.72"));
        assertEquals(0.0, unitConverter.MinutesToSeconds(""));
    }
}