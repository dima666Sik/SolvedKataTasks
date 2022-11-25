package kyu8;

import java.util.Arrays;

public class Level8 {
    public static int sum(int[] numbers) //Sum without highest and lowest number
    {
        if(numbers==null) return 0;
        int sum = 0;
        Arrays.sort(numbers);
        for (int i = 1; i < numbers.length - 1; i++) {
            sum+=numbers[i];
        }
        return sum;
    }

    public static int points(String[] s) { //Total amount of points
        return Arrays.stream(s).map((e)->
                        e.charAt(0)-'0'>e.charAt(2)-'0'?
                                3:e.charAt(0)-'0'==e.charAt(2)-'0'?
                                1:0)
                .reduce((a,e)->a+e).get();
    }

    public static int grow(int[] x){ //Beginner - Reduce but Grow
        return Arrays.stream(x).reduce((a,e)->a*e).getAsInt();
    }

    public static String correct(String s) { //Correct the mistakes of the character recognition software
        return s.replace("0","O").replace("1","I").replace("5","S");
    }

    public static String doubleChar(String s){ //Double Char
        String[] ss = s.split("");
        return Arrays.stream(ss).reduce((a, e) ->
                ss[0].equals(a) ? a + ss[0] + e + e : a + e + e).get();
    }

    public static double sum(double[] numbers) { //Sum Arrays
        double sum = 0;
        for(int i = 0; i<numbers.length; i++){
            sum+=numbers[i];
        }
        return sum;
    }

    public static String fakeBin(String numberString) { //Fake Binary
        String strTemp = "";
        if (numberString.length() != 0) {
            for (int i = 0; i < numberString.length(); i++) {
                strTemp+=(Integer.parseInt(String.valueOf(numberString.charAt(i))) >= 5) ? "1" : "0";
            }
        }
        return strTemp;
    }

    public static int rentalCarCost(int d) { //Transportation on vacation
        int cost = 0;
        for(int i = 0; i < d; i++){
            cost+=40;
        }
        return cost-=(d>=7)?50:(d>=3)?20:0;
    }

    public static int[] digitize(long n) { //Convert number to reversed array of digits
        // Code here
        int[] arr = new int[1];
        String[] tempArr = (n+"").split("");
        for (int i = 0; i < tempArr.length; i++) {
            int[] temp = new int[arr.length+1];

            arr[i] = Integer.parseInt(String.valueOf(tempArr[i].charAt(0)));

            for (int j = 0; j < arr.length; j++){
                temp[j] = arr[j];
            }
            arr = temp;
        }
        //reverse
        int []newTempArr = new int[tempArr.length];
        for (int i = tempArr.length-1, j = 0; i > -1; i--, j++) {
            newTempArr[j] = arr[i];
        }
        return newTempArr;
    }

    public static int squareSum(int[] n) //Square(n) Sum
    {
        int result = 0;
        for(int i = 0; i<n.length;i++)
        {
            result+=Math.pow(n[i],2);
        }
        return result;
    }
}
