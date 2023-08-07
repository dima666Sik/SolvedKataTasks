package kyu8;

import java.util.Arrays;
import java.util.List;

public class Level8 {

    public static int sum(int[] numbers) //Sum without highest and lowest number
    {
        if (numbers == null) return 0;
        int sum = 0;
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length - 1; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static int points(String[] s) { //Total amount of points
        return Arrays.stream(s).map((e) ->
                        e.charAt(0) - '0' > e.charAt(2) - '0' ?
                                3 : e.charAt(0) - '0' == e.charAt(2) - '0' ?
                                1 : 0)
                .reduce((a, e) -> a + e).get();
    }

    public static int grow(int[] x) { //Beginner - Reduce but Grow
        return Arrays.stream(x).reduce((a, e) -> a * e).getAsInt();
    }

    public static String correct(String s) { //Correct the mistakes of the character recognition software
        return s.replace("0", "O").replace("1", "I").replace("5", "S");
    }

    public static String doubleChar(String s) { //Double Char
        String[] ss = s.split("");
        return Arrays.stream(ss).reduce((a, e) ->
                ss[0].equals(a) ? a + ss[0] + e + e : a + e + e).get();
    }

    public static double sum(double[] numbers) { //Sum Arrays
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static String fakeBin(String numberString) { //Fake Binary
        String strTemp = "";
        if (numberString.length() != 0) {
            for (int i = 0; i < numberString.length(); i++) {
                strTemp += (Integer.parseInt(String.valueOf(numberString.charAt(i))) >= 5) ? "1" : "0";
            }
        }
        return strTemp;
    }

    public static int rentalCarCost(int d) { //Transportation on vacation
        int cost = 0;
        for (int i = 0; i < d; i++) {
            cost += 40;
        }
        return cost -= (d >= 7) ? 50 : (d >= 3) ? 20 : 0;
    }

    public static int[] digitize(long n) {
        //Convert number to reversed array of digits
        // Code here
        int[] arr = new int[1];
        String[] tempArr = (n + "").split("");
        for (int i = 0; i < tempArr.length; i++) {
            int[] temp = new int[arr.length + 1];

            arr[i] = Integer.parseInt(String.valueOf(tempArr[i].charAt(0)));

            for (int j = 0; j < arr.length; j++) {
                temp[j] = arr[j];
            }
            arr = temp;
        }
        //reverse
        int[] newTempArr = new int[tempArr.length];
        for (int i = tempArr.length - 1, j = 0; i > -1; i--, j++) {
            newTempArr[j] = arr[i];
        }
        return newTempArr;
    }

    public static int squareSum(int[] n) //Square(n) Sum
    {
        int result = 0;
        for (int i = 0; i < n.length; i++) {
            result += Math.pow(n[i], 2);
        }
        return result;
    }

    public static String genCod(int lab, String name, int ball, String nameGrope) { //Generate Code id
        if (name.length() < 2 || nameGrope.length() < 5)
            return "0";
        String s = lab + name.substring(0, 2) + ball;
        return String.format("%X", s.hashCode() % 65535);
    }

    public static String noSpace(final String x) {
        return x.replaceAll(" ", "");
    }

    public static String numberToString(int num) {
        return String.valueOf(num);
    }

    /*
        Numerical Score	Letter Grade
        90 <= score <= 100	'A'
        80 <= score < 90	'B'
        70 <= score < 80	'C'
        60 <= score < 70	'D'
        0 <= score < 60	    'F'
    */

    public static char getGrade(int s1, int s2, int s3) {
        double average = Math.ceil(getAverage(s1, s2, s3));
        if (average > 100 || average < 60) return 'F';

        if (average >= 90) return 'A';
        else if (average >= 80) return 'B';
        else if (average >= 70) return 'C';
        else return 'D';

    }

    private static double getAverage(int s1, int s2, int s3) {
        return (s1 + s2 + s3) / 3d;
    }

    public int min(int[] list) {
        int min = list[0];
        for (int j : list) {
            if (j < min) min = j;
        }
        return min;
    }

    public int max(int[] list) {
        int max = list[0];
        for (int j : list) {
            if (j > max) max = j;
        }
        return max;
    }

    public static int ConvertBinaryArrayToInt(List<Integer> binary) {
        int numberSystem = 2;

        int result = 0;

        for (int i = 0, k = binary.size() - 1; i < binary.size(); i++, k--) {
            result += (int) (binary.get(i) * Math.pow(numberSystem, k));
        }

        return result;
    }
}
