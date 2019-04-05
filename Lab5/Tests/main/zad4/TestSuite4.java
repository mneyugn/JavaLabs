package main.zad4;

import main.zad2.ArraySizeOutOfRangeException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestSuite4 {
    private Zad4 zad4;

    @Before
    public void setUp()  {
        zad4 = new Zad4();
    }


    @Test
    public void Should_ThrowException_When_IsNoSolution() {
        float[] arr = {-1, 2, 3, 4, 5, 5};
        float target = 20;

        try {
            zad4.solution(arr, target);
            fail();
        } catch (NoSolutionException e) {
            System.out.println("pass");
        }
    }


    @Test
    public void Should_Pass_When_NumbersAreNegative() {
        float[] arr = {-1, 2, 3, 4, 5, 5};
        float target = 4;

        int[] exp = {0, 4};

        try {
            int[] actual = zad4.solution(arr, target);
            assertArrayEquals(exp, actual);
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }


    @Test
    public void Should_Pass_When_ThereAreTwoSameElements() {
        float[] arr = {2, 3, 4, 5, 5};
        float target = 10;

        int[] exp = {3, 4};

        try {
            int[] actual = zad4.solution(arr, target);
            assertArrayEquals(exp, actual);
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }


    @Test
    public void Should_Pass_When_NumbersAreAccidental() {
        float[] arr = {2, 3, 10, 4, 5, 100, 6, 8};
        float target = 7;

        int[] exp = {0, 4};

        try {
            int[] actual = zad4.solution(arr, target);
            assertArrayEquals(exp, actual);
        } catch (Exception e) {
            fail("Unexpected exception");
        }
    }


    @Test
    public void testFindIndex() {
        float[] arr = {1, 2, 4, 10, 120};
        int exp = 3;
        int actual = zad4.findIndex(arr,10,false);
        assertEquals(exp,actual);
    }
}