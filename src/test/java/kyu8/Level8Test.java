package kyu8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Level8Test {
    private long startTime;
    private long endTime;

    public void printTimeWorkMethod() {
        System.out.println("Time to execute: " + (endTime - startTime) + " .ms");
    }

    @Test
    public void noSpace() {

        startTime = System.currentTimeMillis();
        Level8.noSpace("8 j 8   mBliB8g  imjB8B8  jl  B");
        endTime = System.currentTimeMillis();
        printTimeWorkMethod();

        assertEquals("8j8mBliB8gimjB8B8jlB", Level8.noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
        assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", Level8.noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        assertEquals("8aaaaaddddr", Level8.noSpace("8aaaaa dddd r     "));
        assertEquals("jfBmgklf8hg88lbe8", Level8.noSpace("jfBm  gk lf8hg  88lbe8 "));
        assertEquals("8jaam", Level8.noSpace("8j aam"));
    }

    @Test
    public void numberToString() {

    }

    @Test
    public void twoSort() {
        assertEquals("b***i***t***c***o***i***n", Level8.twoSort(new String[] {"bitcoin", "take", "over", "the", "world", "maybe", "who", "knows", "perhaps"}));
        assertEquals("a***r***e", Level8.twoSort(new String[] {"turns", "out", "random", "test", "cases", "are", "easier", "than", "writing", "out", "basic", "ones"}));
    }
}