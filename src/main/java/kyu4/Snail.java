package kyu4;

import java.util.ArrayList;
import java.util.Arrays;

public class Snail {
    private static ArrayList<Point> storePointResultArray;
    private static int[] resultArray;

    public static int[] snail(int[][] array) {
        if (!isValidMatrix(array)) {
            return new int[]{};
        }
        int rowLength = array[0].length;
        int allCountElemsMatrix = array.length * rowLength;

        resultArray = new int[allCountElemsMatrix];
        storePointResultArray = new ArrayList<>();
        NavigationFlags navigationFlags = new NavigationFlags();

        int y = 0, x = 0; // indexes for array

        int counterIndex = 0;

        resultArray[counterIndex++] = array[y][x]; //start elem
        storePointResultArray.add(new Point(y, x));
        navigationFlags.setRightFlag(true);
        while (counterIndex < allCountElemsMatrix) {
            // add compare with elems into array result
            if (x + 1 < rowLength
                    && navigationFlags.isRightFlag()
                    && isPointNotExist(y, x + 1)) {
                resultArray[counterIndex++] = array[y][++x];
                storePointResultArray.add(new Point(y, x));
                continue;
            } else navigationFlags.setDownFlag(true);

            if (y + 1 < rowLength
                    && navigationFlags.isDownFlag()
                    && isPointNotExist(y + 1, x)) {
                resultArray[counterIndex++] = array[++y][x];
                storePointResultArray.add(new Point(y, x));
                continue;
            } else navigationFlags.setLeftFlag(true);

            if (x - 1 < rowLength && x - 1 >= 0
                    && navigationFlags.isLeftFlag()
                    && isPointNotExist(y, x - 1)) {
                resultArray[counterIndex++] = array[y][--x];
                storePointResultArray.add(new Point(y, x));
                navigationFlags.setRightFlag(false);
                continue;
            } else {navigationFlags.setUpFlag(true);}

            if (y - 1 < rowLength && y - 1 >= 0
                    && navigationFlags.isUpFlag()
                    && isPointNotExist(y - 1, x)) {
                resultArray[counterIndex++] = array[--y][x];
                storePointResultArray.add(new Point(y, x));
                navigationFlags.setLeftFlag(false);
            } else navigationFlags.setRightFlag(true);
        }
        return resultArray;
    }

    private static boolean isPointNotExist(int y, int x) {
        if (storePointResultArray.isEmpty()) return true;

        for (Point point : storePointResultArray) {
            if (point.getY() == y && point.getX() == x) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValidMatrix(int[][] array) {
        if (array[0].length == 0) return false;
        for (int i = 1; i < array.length; i++) {
            if (array[0].length != array[i].length) {
                return false;
            }
        }
        return true;
    }

    private static class Point {
        private final int y;
        private final int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public int getX() {
            return x;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "y=" + y +
                    ", x=" + x +
                    '}';
        }
    }

    private static class NavigationFlags {
        private boolean upFlag = false;
        private boolean downFlag = false;
        private boolean leftFlag = false;
        private boolean rightFlag = false;

        public boolean isUpFlag() {
            return upFlag;
        }

        public void setUpFlag(boolean upFlag) {
            this.upFlag = upFlag;
        }

        public boolean isDownFlag() {
            return downFlag;
        }

        public void setDownFlag(boolean downFlag) {
            this.downFlag = downFlag;
        }

        public boolean isLeftFlag() {
            return leftFlag;
        }

        public void setLeftFlag(boolean leftFlag) {
            this.leftFlag = leftFlag;
        }

        public boolean isRightFlag() {
            return rightFlag;
        }

        public void setRightFlag(boolean rightFlag) {
            this.rightFlag = rightFlag;
        }
    }
}
