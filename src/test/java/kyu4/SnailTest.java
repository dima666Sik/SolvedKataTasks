package kyu4;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class SnailTest {

    @Test
    public void SnailTest1() {
        int[][] array
                = {{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        int[] r = {1, 2, 3, 6, 9, 8, 7, 4, 5};
        test(array, r);
    }

    @Test
    public void SnailTest2() {
        int[][] array
                = {{1, 2, 3, 1},
                {4, 5, 6, 4},
                {7, 8, 9, 7},
                {7, 8, 9, 7}};
        int[] r = {1, 2, 3, 1, 4, 7, 7, 9, 8, 7, 7, 4, 5, 6, 9, 8};
        test(array, r);
    }

    @Test
    public void SnailTest3() {
        int[][] array = {
                {704, 920, 319, 196, 229, 669, 946, 587, 155, 135},
                {407, 735, 279, 995, 529, 263, 240, 792, 136, 12},
                {629, 885, 239, 257, 671, 315, 317, 79, 213, 141},
                {110, 189, 897, 788, 718, 89, 261, 307, 89, 963},
                {608, 548, 546, 289, 191, 775, 441, 646, 619, 447},
                {882, 67, 999, 275, 680, 909, 367, 235, 770, 980},
                {173, 270, 500, 731, 488, 79, 368, 271, 587, 868},
                {352, 802, 289, 256, 756, 161, 692, 650, 980, 731},
                {663, 338, 415, 652, 512, 349, 279, 395, 555, 431},
                {374, 533, 598, 59, 769, 942, 237, 992, 923, 390}
        };

        int[] r = {704, 920, 319, 196, 229, 669, 946, 587, 155, 135, 12,
                141, 963, 447, 980, 868, 731, 431, 390, 923, 992, 237, 942,
                769, 59, 598, 533, 374, 663, 352, 173, 882, 608, 110, 629,
                407, 735, 279, 995, 529, 263, 240, 792, 136, 213, 89, 619,
                770, 587, 980, 555, 395, 279, 349, 512, 652, 415, 338, 802,
                270, 67, 548, 189, 885, 239, 257, 671, 315, 317, 79, 307, 646,
                235, 271, 650, 692, 161, 756, 256, 289, 500, 999, 546, 897, 788,
                718, 89, 261, 441, 367, 368, 79, 488, 731, 275, 289, 191, 775, 909, 680};
        test(array, r);
    }

    @Test
    public void SnailTest4() {
        int[][] array
                = {{}};
        int[] r = {};
        test(array, r);
    }
    public String int2dToString(int[][] a) {
        return Arrays.stream(a).map(Arrays::toString).collect(joining("\n"));
    }

    public void test(int[][] array, int[] result) {
        String text = int2dToString(array) + " should be sorted to " + Arrays.toString(result);
        System.out.println(text);
        Assert.assertArrayEquals(result, Snail.snail(array));
    }


}
