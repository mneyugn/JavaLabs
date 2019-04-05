package main.zad3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

class Zad3Test {

    @Test
    void testExpectedInvalidParameterException() {
        String a = "abcd";
        String b = null;
        Zad3 ob = new Zad3();
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            ob.substring(a, b);
        });
    }

    @Test
    void testSubstring1() {
        String a = "abcd";
        String b = "cdabcdab";
        Zad3 ob = new Zad3();
        int exp = 3;

        try {
            int actual = ob.substring(a, b);
            Assertions.assertEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void testSubstring2() {
        String a = "acccccccca";
        String b = "cccaaccc";
        Zad3 ob = new Zad3();
        int exp = 2;

        try {
            int actual = ob.substring(a, b);
            Assertions.assertEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void testSubstring3() {
        String a = "a";
        String b = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        Zad3 ob = new Zad3();
        int exp = 32;

        try {
            int actual = ob.substring(a, b);
            Assertions.assertEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void testSubstring4() {
        String a = "aas";
        String b = "dddd";
        Zad3 ob = new Zad3();
        int exp = -1;

        try {
            int actual = ob.substring(a, b);
            Assertions.assertEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}
