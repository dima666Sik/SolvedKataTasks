package kyu7;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class Level7Test {
    public static class TwoToOneTest {

        @Test
        public void test() {
            System.out.println("longest Fixed Tests");
            assertEquals("aehrsty", Level7.TwoToOne.longest("aretheyhere", "yestheyarehere"));
            assertEquals("abcdefghilnoprstu", Level7.TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
            assertEquals("acefghilmnoprstuy", Level7.TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
        }
    }

    public static class SolutionTest {
        @Test
        public void test4a() {
            assertEquals("aaaa", Level7.Solution.repeatStr(4, "a"));
        }

        @Test
        public void test3Hello() {
            assertEquals("HelloHelloHello", Level7.Solution.repeatStr(3, "Hello"));
        }

        @Test
        public void test5empty() {
            assertEquals("", Level7.Solution.repeatStr(5, ""));
        }

        @Test
        public void test0kata() {
            assertEquals("", Level7.Solution.repeatStr(0, "kata"));
        }
    }

    public static class ArgeTest {

        private static void testing(int actual, int expected) {
            assertEquals(expected, actual);
        }

        @Test
        public void test1() {
            System.out.println("Fixed Tests: nbYear");
            testing(Level7.Arge.nbYear(1500, 5, 100, 5000), 15);
            testing(Level7.Arge.nbYear(1500000, 2.5, 10000, 2000000), 10);
            testing(Level7.Arge.nbYear(1500000, 0.25, 1000, 2000000), 94);
        }
    }

    public static class PrinterTest {
        @Test
        public void printerError() {
            System.out.println("printerError Fixed Tests");
            String s="aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz";
            assertEquals("3/56", Level7.Printer.printerError(s));
        }
    }
}