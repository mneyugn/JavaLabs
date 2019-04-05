package main.zad4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Zad4Test {


    @Test
    void testExpectedNoSolutionException() {
        float[] arr = {-1, 2, 3, 4, 5, 5};
        Zad4 ob = new Zad4();
        float target = 20;

        Assertions.assertThrows(NoSolutionException.class, () -> {
            ob.solution(arr, target);
        });
    }

    @Test
    void testSolution1() {
        float[] arr = {-1, 2, 3, 4, 5, 5};
        float target = 4;
        Zad4 ob = new Zad4();

        int[] exp = {0, 4};

        try {
            int[] actual = ob.solution(arr, target);
            Assertions.assertArrayEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void testSolution2() {
        float[] arr = {2, 3, 4, 5, 5};
        float target = 10;
        Zad4 ob = new Zad4();

        int[] exp = {3, 4};

        try {
            int[] actual = ob.solution(arr, target);
            Assertions.assertArrayEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void testSolution3() {
        float[] arr = {2, 3, 4, 5, 5};
        float target = 7;
        Zad4 ob = new Zad4();

        int[] exp = {0, 3};

        try {
            int[] actual = ob.solution(arr, target);
            Assertions.assertArrayEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }
}