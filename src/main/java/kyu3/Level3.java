package kyu3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level3 {
    static class BinomialExpansion {
        private static final List<Long> seriesList = new ArrayList<>();
        private static Character susSymbol;

        public static String expand(String expr) {
            String[] expressionAndPow = expr.split("\\^");
            String getValidExpression = expressionAndPow[0].substring(1, expressionAndPow[0].length() - 1);

            int getValidPow = Integer.parseInt(expressionAndPow[1]);

            if (getValidPow == 0) return "1";

            int[] validValuesFromExpression = getValidExpression(getValidExpression);

            series(validValuesFromExpression[0], validValuesFromExpression[1], getValidPow);

            StringBuilder result = new StringBuilder();

            for (int i = 0; i <= getValidPow; i++) {

                if (seriesList.get(i) == 0) continue;

                if (i > 0 && seriesList.get(i) > 0) {
                    result.append("+");
                }


                if (i < getValidPow) {
                    if (seriesList.get(i) == 1) result.append(susSymbol);
                    else if (seriesList.get(i) == -1) result.append("-").append(susSymbol);
                    else result.append(seriesList.get(i)).append(susSymbol);
                } else {
                    result.append(seriesList.get(i));
                }

                if (i < getValidPow - 1) {
                    result.append("^").append(getValidPow - i);
                }

            }

            seriesList.clear();
            susSymbol = null;

            return result.toString();
        }

        private static int[] getValidExpression(String getValidExpression) {
            String copyGetValidExp = getValidExpression;
            Pattern pattern = Pattern.compile("(?<!\\d)([a-z]).*");
            Matcher matcher = pattern.matcher(getValidExpression);
            if (matcher.find()) {
                susSymbol = matcher.group(1).charAt(0);
                copyGetValidExp = copyGetValidExp.replaceAll("[a-z]", "1".concat(matcher.group(1)));
            }

            if (susSymbol == null) {
                Pattern patternSus = Pattern.compile(".*([a-z]).*");
                Matcher matcherSus = patternSus.matcher(getValidExpression);
                if (matcherSus.find()) {
                    susSymbol = matcherSus.group(1).charAt(0);
                }
            }

            String[] resultSplitStr = copyGetValidExp.split("[a-z]");

            int[] resultArray = new int[resultSplitStr.length];
            for (int i = 0; i < resultSplitStr.length; i++) {
                resultArray[i] = Integer.parseInt(resultSplitStr[i]);
            }
            return resultArray;
        }

        static void series(int A, int X, int n) {

            // Calculating and printing first
            // term
            long term = (long) Math.pow(A, n);
            seriesList.add(term);
            // Computing and printing
            // remaining terms
            for (int i = 1; i <= n; i++) {

                term = term * X * (n - i + 1)
                        / ((long) i * A);
                seriesList.add(term);
            }
        }
    }
}
