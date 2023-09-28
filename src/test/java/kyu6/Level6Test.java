package kyu6;

import org.junit.Test;

import static org.junit.Assert.*;

public class Level6Test {
    @Test
    public void duplicateCount() {
        assertEquals(0, Level6.duplicateCount("abcde"));
        assertEquals(1, Level6.duplicateCount("abcdea"));
        assertEquals(1, Level6.duplicateCount("indivisibility"));

        String testThousandA = new String(new char[1000]).replace('\0', 'a');
        String testHundredB = new String(new char[100]).replace('\0', 'b');
        String testTenC = new String(new char[10]).replace('\0', 'c');
        String test1CapitalA = new String(new char[1]).replace('\0', 'A');
        String test1d = new String(new char[1]).replace('\0', 'd');
        String test = test1d + test1CapitalA + testTenC +
                testHundredB + testThousandA;
        assertEquals(3, Level6.duplicateCount(test));
    }

    @Test
    public void high() {
        assertEquals("taxi", Level6.High.high("man i need a taxi up to ubud"));
        assertEquals("volcano", Level6.High.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", Level6.High.high("take me to semynak"));

        assertEquals("aa", Level6.High.high("aa b"));
        assertEquals("b", Level6.High.high("b aa"));
        assertEquals("bb", Level6.High.high("bb d"));
        assertEquals("d", Level6.High.high("d bb"));
        assertEquals("aaa", Level6.High.high("aaa b"));
    }

    @Test
    public void deleteNth(){
        assertArrayEquals(
                new int[] { 20, 37, 21 },
                Level6.deleteNth( new int[] { 20, 37, 20, 21 }, 1 )
        );
        assertArrayEquals(
                new int[] { 1, 1, 3, 3, 7, 2, 2, 2 },
                Level6.deleteNth( new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 )

        );
        assertArrayEquals(
                new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 },
                Level6.deleteNth( new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 )
        );
        assertArrayEquals(
                new int[] { 1, 1, 1, 1, 1 },
                Level6.deleteNth( new int[] { 1, 1, 1, 1, 1 }, 5 )
        );
        assertArrayEquals(
                new int[] { },
                Level6.deleteNth( new int[] { }, 5 )
        );
    }
}