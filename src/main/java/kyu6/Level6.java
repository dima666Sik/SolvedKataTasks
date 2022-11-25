package kyu6;

import java.util.ArrayList;
import java.util.Arrays;

public class Level6 {
    public static long findNb(long m) { //Build a pile of Cubes
        long sum = 0;
        for (long iterator = 0; iterator < m; iterator++){
            sum += (long)Math.pow(iterator, 3);
            if(sum == m) return iterator;
            else if (sum > m) return -1;
        }
        return -1;
    }

    public boolean check(String s){ //Detect Pangram
        return s.toLowerCase().chars().distinct().filter(i->i>='a'&&i<='z').count()==26;
    }

    public static String order(String words) { //Your order, please
        if (words.length() == 0) return "";
        String[] newWordsArray = words.split(" ");
        int num1 = 0;
        String newStr = "";

        for (int i = 0; i < newWordsArray.length; i++) {//go on words
            for (int j = 0; j < newWordsArray[i].length(); j++) {//go on symbols in a word

                num1 = tempNum(newWordsArray, i, j);// 57(9)-48(0) get number from string[]

                if (num1 > 0 && num1 < 10) {
                    newWordsArray = sortBubble(newWordsArray, i, j);
                    break;
                }
            }
        }
        for (int i = 0; i < newWordsArray.length; i++) {
            if (i == newWordsArray.length - 1) newStr += newWordsArray[i];
            else newStr += newWordsArray[i] + " ";
        }

        return newStr;
    }

    private static int indexJNext(int j, String[] newWordsArray) {
        int num2 = 0, index = 0;
        for (int i = 0; i < newWordsArray[j].length(); i++) {//go on symbols in a word
            num2 = tempNum(newWordsArray, j, i);// 57(9)-48(0)

            if (num2 > 0 && num2 < 10) {
                index = i;
                break;
            } else continue;
        }
        return index;
    }

    private static int tempNum(String[] newWordsArray, int i, int j) {
        return newWordsArray[i].charAt(j) - '0';
    }

    public static String[] sortBubble(String[] newWordsArray, int indexI, int indexJ) {
        for (int j = indexI + 1; j < newWordsArray.length; j++) {

            if (newWordsArray[indexI].charAt(indexJ) > newWordsArray[j].charAt(indexJNext(j, newWordsArray))) {
                String temp = newWordsArray[indexI];
                newWordsArray[indexI] = newWordsArray[j];
                newWordsArray[j] = temp;
                indexJ = indexJNext(indexI, newWordsArray);
            } else continue;
        }
        return newWordsArray;
    }

    static String toCamelCase(String str) { //Convert string to camel case
        String newStr = "";
        boolean flag = false;
        if (str.length()==0) return "";
        String[] words = str.split("[_|-]");
        for (int i = 0; i < words.length; i++) {
            int end = words[i].length(), start = 1;

            char[] dst = new char[end - start];
            words[i].getChars(start, end, dst, 0);
            if (words[0].equals(words[0].toLowerCase()) && !flag) {
                newStr += words[0];
                flag = true;
                continue;
            } ;
            newStr += words[i].toUpperCase().charAt(0) + new String(dst);
        }
        return newStr;
    }

    public static int persistence(long n) { //Persistent Bugger.
        //39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
        int count = 0;
        if (n < 10) return 0;
        while(n>=10){
            n = mul(n);
            count++;
        }
        return count;
    }

    private static int mul(long n){
        int mul = 1;
        while (n > 0) {
            mul *= (n % 10);
            n /= 10;
        }
        return mul;
    }

    public static int[] arrayDiff(int[] list1, int[] list2) { //Array.diff
        ArrayList<Integer> temp = new ArrayList<Integer>();
        if (list2.length == 0) return list1;
        else if (list1.length == 0) return list1;
        Arrays.sort(list2);
        boolean flag = false;

        for (int i = 0; i < list1.length; i++) {
            for (int j = 0; j < list2.length; j++) {
                if (list1[i] == list2[j]) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                }
            }
            if (!flag) {
                temp.add(list1[i]);
            }
        }

        int[] arr = new int[temp.size()];
        int i = 0;
        for (int elem : temp) {
            arr[i++] = elem;
        }
        return arr;
    }
}
