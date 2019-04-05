package main.zad3;

import org.junit.Before;
import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class TestSuite3 {

    private Zad3 zad3;

    @Before
    public void setUp() throws Exception {
        zad3 = new Zad3();
    }


    @Test(expected = InvalidParameterException.class)
    public void Should_ThrowException_When_StringIsNull() {
        String a = "abcd";
        String b = null;
        zad3.substring(a, b);
    }



    @Test
    public void Should_Pass_When_StringsAreEqual() {
        String a = "cccaaccc";
        String b = "cccaaccc";
        int exp = 1;

        try {
            int actual = zad3.substring(a, b);
            assertEquals(exp, actual);

        } catch (Exception e) {
            fail();
        }
    }

    @Test
        public void Should_Pass_When_StringAIsLonger() {
            String a = "acccccccca";
            String b = "cccaaccc";
            int exp = 2;

            try {
                int actual = zad3.substring(a, b);
                assertEquals(exp, actual);

            } catch (Exception e) {
                fail();
            }
    }

    @Test
    public void Should_Pass_When_StringBIsLonger() {
        String a = "abcd";
        String b = "cdabcdab";
        int exp = 3;

        try {
            int actual = zad3.substring(a, b);
            assertEquals(exp, actual);

        } catch (Exception e) {
            fail();
        }
    }


    @Test
    public void Should_Pass_When_StringBIsMuchLonger() {
        String a = "a";
        String b = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int exp = 42;

        try {
            int actual = zad3.substring(a, b);
            assertEquals(exp, actual);

        } catch (Exception e) {
            fail();
        }
    }


    @Test
    public void Should_ReturnMinusOne_When_SubstringIsImpossible() {
        String a = "aas";
        String b = "dddd";
        int exp = -1;

        try {
            int actual = zad3.substring(a, b);
            assertEquals(exp, actual);

        } catch (Exception e) {
            fail();
        }
    }
}