package kyu4;

public class LargeNumber {
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