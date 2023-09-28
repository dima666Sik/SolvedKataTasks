package kyu5;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Enclosed.class)
public class Level5Test {
    public static class PigLatinTest {
        @Test
        public void FixedTests() {
            assertEquals("igPay atinlay siay oolcay", Level5.PigLatin.pigIt("Pig latin is cool"));
            assertEquals("hisTay siay ymay tringsay", Level5.PigLatin.pigIt("This is my string"));
            assertEquals("elloHay orldway !", Level5.PigLatin.pigIt("Hello world !"));
            assertEquals("elloHay orldway ?", Level5.PigLatin.pigIt("Hello world ?"));
        }
    }
    public static class StringIncrementerTest{
        private static void doTest(String str, String expected) {
            assertEquals(expected, Level5.StringIncrementer.incrementString(str));
        }

        @Test
        public void exampleTests() {
            doTest("foobar000", "foobar001");
            doTest("foo", "foo1");
            doTest("foobar001", "foobar002");
            doTest("foobar99", "foobar100");
            doTest("foobar099", "foobar100");
            doTest("", "1");
            doTest("}0000014242308323814428509", "}0000014242308323814428510");
        }
    }
}