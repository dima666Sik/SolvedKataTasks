package kyu7;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Level7 {
    public static int[] minMax(int[] arr) { //The highest profit wins!
        return new int[]{Arrays.stream(arr).min().getAsInt(), Arrays.stream(arr).max().getAsInt()};
    }

    public static String seriesSum(int n) { //Sum of the first nth term of Series
        ArrayList<Integer> arrayList = new ArrayList<>(n);
        for (int i = n; i > 0; i--) {
            arrayList.add(i);
        }

        return String.format("%.2f", arrayList.stream().mapToDouble(iD -> iD == 1 ? 1.0 : (1d / (3 * iD - 2))).peek(System.out::println).sum());
    }

    public static String highAndLow(String numbers) { //Highest and Lowest
        List<Integer> iList = new ArrayList<>(numbers.length());
        for (String s : numbers.split(" ")) {
            iList.add(Integer.parseInt(String.valueOf(s)));
        }
        Collections.sort(iList);
        return iList.get(iList.size() - 1) + " " + iList.get(0);
    }

    public static long findNextSquare(long sq) { //Find the next perfect square!
        double foundNum = Math.sqrt(sq);
        return (foundNum - (int) (foundNum) == 0) ? (long) Math.pow((foundNum + 1), 2) : -1;
    }

    public static String disemvowel(String str) { //Disemvowel Trolls
        String nStr = "";
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) != 'a' && str.charAt(i) != 'e' &&
                    str.charAt(i) != 'i' && str.charAt(i) != 'o' &&
                    str.charAt(i) != 'u') &&
                    (str.charAt(i) != 'A' && str.charAt(i) != 'E' &&
                            str.charAt(i) != 'I' && str.charAt(i) != 'O' &&
                            str.charAt(i) != 'U')) nStr += str.charAt(i);
            else continue;
        }
        return nStr;
    }

    public int squareDigits(int n) { //Square Every Digit
        int expression = (n / 10 % 10) * (n / 10 % 10);

        if (n == 0) return 0;
        else if (n >= 1 && n <= 9) {
            return n * n;
        } else if (n >= 10 && n <= 99) {
            return Integer.parseInt((n / 10) * (n / 10) + "" + (n % 10) * (n % 10));
        } else if (n >= 100 && n <= 999) {

            return Integer.parseInt((n / 100) * (n / 100) + "" + expression + "" + (n % 10) * (n % 10));
        }
        if (n >= 1000) {
            return Integer.parseInt((n / 1000) * (n / 1000) + "" + (n / 100 % 10) * (n / 100 % 10) + ""
                    + expression + "" + (n % 10) * (n % 10));
        } else return 0;
    }

    public static String reverseWords(final String original) { //Reverse words
        int start = 0, end = 0;
        String result = "";
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == ' ') {
                result += reverseSE(start, end, original) + ' ';
                start = i + 1;
                end = start;
                continue;
            } else if (original.charAt(i) != ' ') {
                end++;
            }
            if (end == original.length()) {
                result += reverseSE(start, end, original);
            }
        }
        return result;
    }

    private static String reverseSE(int start, int end, String original) {
        char[] dst = new char[end - start];
        String tempStr = "";
        original.getChars(start, end, dst, 0);
        for (int i = dst.length - 1; i >= 0; i--) {
            tempStr += dst[i];
        }
        return tempStr;
    }

    public static String accum(String s) { //Mumbling
        char[] sArray = s.toUpperCase().toCharArray();
        String newStr = "";
        for (int i = 0; i < sArray.length; i++) {
            if (i == 0) newStr += sArray[i];
            else newStr += sArray[i] + addLetters(s, i);
            if (i < sArray.length - 1) newStr += "-";
        }

        return newStr;
    }

    private static String addLetters(String s, int count) {
        String str = "";
        for (int i = 0; i < count; i++) {
            str += s.toLowerCase().charAt(count) + "";
        }
        return str;
    }

    public static int countPassengers(ArrayList<int[]> stops) { //Number of People in the Bus
        int count = stops.get(0)[0];
        for (int i = 0, j = 0; i < Stream.of(stops).mapToInt(m -> m.toArray().length).sum(); i++) {
            if (i > 0) {
                count += stops.get(i)[j];
            }
            count -= stops.get(i)[j + 1];
        }
        return count;
    }

    public static class TwoToOne {

        public static String longest(String s1, String s2) {
            Set<String> stringSet = new TreeSet<>(List.of(s1.split("")));
            stringSet.addAll(List.of(s2.split("")));
            return String.join("", stringSet);
        }
    }

    public static class Solution {
        public static String repeatStr(final int repeat, final String string) {
            return string.repeat(repeat);
        }
    }

    public static class Arge {

        public static int nbYear(int p0, double percent, int aug, int p) {
            System.out.println(p0 + " " + percent + " " + aug + " " + p);
            int result = p0;
            int yearCount = 0;
            while (result < p) {
                result = (int)(result + result * percent / 100 + aug);
                yearCount++;
            }
            return yearCount;
        }
    }

    public static class Printer {
        public static String printerError(String s) {
            return Arrays.stream(s.split("")).filter(el-> el.matches("[^a-m]")).count() + "/" + s.length();
        }
    }

}
