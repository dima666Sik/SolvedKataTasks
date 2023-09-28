package kyu5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Level5 {
    static class PigLatin {
        //todo: Pig latin is cool -> igPay atinlay siay oolcay
        public static String pigIt(String str) {
            String staticRegex = "ay";
            String[] subStrArr = str.split(" ");
            StringBuilder result = new StringBuilder();

            for (String string : subStrArr) {
                Pattern pattern = Pattern.compile("[!?]");
                Matcher matcher = pattern.matcher(string);
                if (matcher.find()) {
                    result.append(matcher.group());
                    continue;
                }

                ArrayList<Character> otherLettersSubStr = new ArrayList<>();
                Character firstLetter = null;

                for (int j = 0; j < string.length(); j++) {
                    firstLetter = string.charAt(0);
                    if (j > 0) {
                        otherLettersSubStr.add(string.charAt(j));
                    }
                }

                for (Character character : otherLettersSubStr) {
                    result.append(character);
                }
                result.append(firstLetter).append(staticRegex).append(" ");
            }
            return result.toString().trim();
        }
    }

    static class StringIncrementer {
        public static String incrementString(String str) {
            Pattern patternDigit = Pattern.compile("\\d+$");
            Matcher matcherDigit = patternDigit.matcher(str);

            if (matcherDigit.find()) {
                String searchDigitalResult = matcherDigit.group();

                BigInteger parseInStrLong = new BigInteger(searchDigitalResult);
                String counter = parseInStrLong.add(new BigInteger("1")).toString();
                int countZeroInRegex = searchDigitalResult.length() - counter.length();

                return str.substring(0, str.length() - searchDigitalResult.length()) + "0".repeat(Math.max(0, countZeroInRegex)) + counter;
            }

            return str.concat("1");
        }
    }
}
