package kyu4;

import org.junit.Test;

import static org.junit.Assert.*;

public class Level4Test {

    @Test
    public void stripComments() {
        assertEquals(
                "apples, pears",
                Level4.stripComments("apples, pears # and bananas", new String[]{"#", "!"})
        );


        assertEquals(
                "a\nc\nd",
                Level4.stripComments("a #b\nc\nd $e f g", new String[]{"#", "$"})
        );


        assertEquals(
                "a\n b\nc",
                Level4.stripComments("a \n b \nc ", new String[]{"#", "$"})
        );

        assertEquals(
                "a\n a",
                Level4.stripComments("a  \n a    ", new String[]{"#", "$"})
        );

        assertEquals(
                "a\n\n\n\n\n",
                Level4.stripComments("a\n\n\n\n\n", new String[]{"#", "$"})
        );
    }

    @Test
    public void convertToIP() {
        assertEquals("128.114.17.104", Level4.convertToIP(2154959208L));
        assertEquals("0.0.0.0", Level4.convertToIP(0));
        assertEquals("128.32.10.1", Level4.convertToIP(2149583361L));
    }

    @Test
    public void sumStrings() {
        assertEquals("579", Level4.sumStrings("123", "456"));
    }

}