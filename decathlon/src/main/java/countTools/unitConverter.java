package countTools;

public class unitConverter {
    public static double metersToCentimeters(String value) {
        double result = 0.0;

        if (value.length() != 0) {
            if (value.length() == 1) {
                double meters = Double.parseDouble(value);
                result = meters * 100;
            } else {
                String[] resultArr = value.split("\\.");
                double meters = Double.parseDouble(resultArr[0]);
                double centimeters = Double.parseDouble(resultArr[1]);
                result = (meters * 100) + centimeters;
            }
        }
        return result;
    }

    public static double MinutesToSeconds(String value) {
        double result = 0.0;

        if (value.length() != 0) {
            String[] resultArr = value.split("\\.");
            double minutes = Double.parseDouble(resultArr[0]);
            double seconds = Double.parseDouble(resultArr[1]);
            double milliseconds = Double.parseDouble(resultArr[2]);
            result = (minutes * 60) + seconds + (milliseconds * 0.01);
        }
        return result;
    }
}

