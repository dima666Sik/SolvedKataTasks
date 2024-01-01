package kyu4;

import java.util.HashMap;
import java.util.Map;

public class TimeFormatter {
    private static int[] resultDate = new int[5]; // y-d-h-m-s

    private static void clearResult() {
        resultDate = new int[5];
    }

    public static String formatDuration(int seconds) {
        if (seconds < 0) throw new RuntimeException("Time cant be negative...");
        if (seconds == 0) return CollectionPhrase.NOW;
        //0 - minute
        //1 - hour
        //2 - day
        //3 - year
        int[] commonDate = new int[]{60, 60 * 60, 60 * 60 * 24, 60 * 60 * 24 * 365};

        int remains;
        int index = 0;
        remains = getRemains(seconds, commonDate[3], index++);
        if (remains != 0) remains = getRemains(remains, commonDate[2], index++);
        if (remains != 0) remains = getRemains(remains, commonDate[1], index++);
        if (remains != 0) remains = getRemains(remains, commonDate[0], index++);
        if (remains != 0) resultDate[index] = remains;

        return getResultCreationPhrase();
    }

    private static int checkCountNotZeroElements() {
        int counter = 0;
        for (int j : resultDate) {
            if (j != 0) counter++;
        }
        return counter;
    }

    private static String getResultCreationPhrase() {
        StringBuilder stringBuilder = new StringBuilder();
        int countNotZeroElements = checkCountNotZeroElements();
        int counterRealValues = 0;
        for (int i = 0; i < resultDate.length; i++) {

            if (resultDate[i] != 0) {
                stringBuilder.append(resultDate[i])
                        .append(" ")
                        .append(CollectionPhrase.timeMap.get(i));
                if (resultDate[i] > 1) stringBuilder.append(CollectionPhrase.S);

                if (countNotZeroElements > 2 && counterRealValues != countNotZeroElements - 1 && counterRealValues != countNotZeroElements - 2) {
                    stringBuilder.append(", ");
                } else if (countNotZeroElements > 1 && counterRealValues < countNotZeroElements - 1 && counterRealValues >= countNotZeroElements - 2) {
                    stringBuilder.append(" " + CollectionPhrase.AND + " ");
                }
                counterRealValues++;
            }
        }
        clearResult();
        return stringBuilder.toString();
    }

    private static int getRemains(int seconds, int commonDate, int index) {
        if (seconds >= commonDate) {
            int remains = seconds - commonDate;
            int occasionYear = 1;
            while (remains >= commonDate) {
                occasionYear++;
                remains -= commonDate;
            }
            resultDate[index] = occasionYear;
            return remains;
        }
        return seconds;
    }

    private static class CollectionPhrase {
        private static final Map<Integer, String> timeMap = new HashMap<>() {{
            put(0, YEAR);
            put(1, DAY);
            put(2, HOUR);
            put(3, MINUTE);
            put(4, SECOND);
        }};
        private static final String YEAR = "year";
        private static final String DAY = "day";
        private static final String HOUR = "hour";
        private static final String MINUTE = "minute";
        private static final String SECOND = "second";
        private static final String S = "s";
        private static final String NOW = "now";
        private static final String AND = "and";
    }
}