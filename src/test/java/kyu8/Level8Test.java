package kyu8;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals("8j8mBliB8gimjB8B8jlB", Level8.noSpace("8 j 8   mBliB8g  imjB8B8  jl  B"));
        Assert.assertEquals("88Bifk8hB8BB8BBBB888chl8BhBfd", Level8.noSpace("8 8 Bi fk8h B 8 BB8B B B  B888 c hl8 BhB fd"));
        Assert.assertEquals("8aaaaaddddr", Level8.noSpace("8aaaaa dddd r     "));
        Assert.assertEquals("jfBmgklf8hg88lbe8", Level8.noSpace("jfBm  gk lf8hg  88lbe8 "));
        Assert.assertEquals("8jaam", Level8.noSpace("8j aam"));
    }

    @Test
    public void numberToString() {

    }
}