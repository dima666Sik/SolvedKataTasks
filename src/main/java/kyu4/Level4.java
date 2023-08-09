package kyu4;

public class Level4 {
    public static String stripComments(String text, String[] commentSymbols) {
        StringBuilder resultBuilder = new StringBuilder();
        boolean isInComment = false;

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (!isInComment) {
                boolean isCommentStart = false;

                for (String commentSymbol : commentSymbols) {
                    if (text.startsWith(commentSymbol, i)) {
                        isCommentStart = true;
                        break;
                    }
                }

                if (isCommentStart) {
                    isInComment = true;
                }
            }

            if (currentChar == '\n') {
                isInComment = false;
            }

            if (!isInComment) {
                resultBuilder.append(currentChar);
            }
        }

        StringBuilder[] lines = customSplitWithChooseSymbol(resultBuilder, '\n');

        resultBuilder.setLength(0);

        for (StringBuilder line : lines) {
            resultBuilder.append(customDeleteAll(line, ' '));
        }

        System.out.println(resultBuilder);
        return resultBuilder.toString();
    }

    public static int getCountSymbol(StringBuilder text, char targetChar) {
        int count = 0;

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == targetChar) {
                count++;
            }
        }

        return count;
    }

    public static StringBuilder[] customSplitWithChooseSymbol(StringBuilder text, char targetChar) {
        int countSymbol = getCountSymbol(text, targetChar) + 1;

        StringBuilder[] arrayString = new StringBuilder[countSymbol];

        if (countSymbol == 1) {
            arrayString[0] = new StringBuilder();
            arrayString[0].append(text);
            return arrayString;
        }

        arrayString = copyStringBuilderAndAddSizeArray(arrayString, 1);

        for (int i = 0, k = 0; i < text.length(); i++) {
            if (text.charAt(i) == '\n') {
                k++;
            }
            arrayString[k].append(text.charAt(i));
        }
        return arrayString;
    }

    public static StringBuilder[] copyStringBuilderAndAddSizeArray(StringBuilder[] arrayString, int size) {
        StringBuilder[] newArrayStrBld = new StringBuilder[arrayString.length + size];
        for (int i = 0; i < newArrayStrBld.length; i++) {
            newArrayStrBld[i] = new StringBuilder();
        }
        return newArrayStrBld;
    }

    public static StringBuilder customDeleteAll(StringBuilder text, char targetChar) {
        StringBuilder result = new StringBuilder(text);

        for (int i = result.length() - 1; i >= 0; ) {
            if (result.charAt(i) != targetChar) {
                break;
            }

            result.delete(i, i + 1);
            i--;
        }

        return result;
    }

    public static String convertToIP(long number) {
        long firstByte = (number >> 24) & 0xFF;
        long secondByte = (number >> 16) & 0xFF;
        long thirdByte = (number >> 8) & 0xFF;
        long fourthByte = number & 0xFF;

        return new String(new StringBuilder()
                .append(firstByte).append(".")
                .append(secondByte).append(".")
                .append(thirdByte).append(".")
                .append(fourthByte));
    }

    public static String sumStrings(String a, String b) {
        if (!isNumber(a) || !isNumber(b)) return "Incorrect Number!";
        LargeNumber largeNumberA = new LargeNumber(a);
        LargeNumber largeNumberB = new LargeNumber(b);

        return largeNumberA.add(largeNumberB).toString();
    }

    public static boolean isNumber(String number) {
        if (number.isEmpty()) return true;
        return number.matches("\\d+");
    }

    private static class LargeNumber {
        private int[] digits;

        public LargeNumber(String number) {
            digits = new int[number.length()];
            if (digits.length == 0) {
                digits = new int[1];
            }
            for (int i = 0; i < number.length(); i++) {
                digits[i] = Character.getNumericValue(number.charAt(i));
            }
        }

        public LargeNumber add(LargeNumber other) {
            int maxLength = Math.max(digits.length, other.digits.length);
            int[] result = new int[maxLength + 1];
            int carry = 0;

            for (int i = 0; i < maxLength; i++) {
                int sum = carry;

                if (i < digits.length) {
                    sum += digits[digits.length - 1 - i];
                }
                if (i < other.digits.length) {
                    sum += other.digits[other.digits.length - 1 - i];
                }

                carry = sum / 10;
                result[maxLength - i] = sum % 10;
            }

            result[0] = carry;

            LargeNumber sumNumber = new LargeNumber("");

            sumNumber.digits = result;

            return deleteZeroFromStartArray(sumNumber);
        }

        private LargeNumber deleteZeroFromStartArray(LargeNumber largeNumber) {
            int index = 0;

            while (index < largeNumber.digits.length) {
                if (largeNumber.digits[index] != 0) {
                    break;
                }
                index++;
            }

            return copyArray(largeNumber, index);
        }

        private LargeNumber copyArray(LargeNumber largeNumber, int start) {
            LargeNumber copyArray = new LargeNumber("");
            copyArray.digits = new int[largeNumber.digits.length - start];
            for (int i = 0, k = start; i < copyArray.digits.length; i++, k++) {
                copyArray.digits[i] = largeNumber.digits[k];
            }
            return copyArray;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int digit : digits) {
                sb.append(digit);
            }
            return sb.toString();
        }
    }
}