package main.zad2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Zad2Test {

    @Test
    void testExpectedArraySizeOutOfRangeException() {
        List<Integer> list = new ArrayList<>();
        Zad2 ob = new Zad2();

        Assertions.assertThrows(ArraySizeOutOfRangeException.class, () -> {
            ob.solution(list);
        });
    }

    @Test
    void testExpectedArrayElementsOutOfRangeException() {
        List<Integer> list = new ArrayList<>();
        list.add(1000001);
        Zad2 ob = new Zad2();
        Assertions.assertThrows(ArrayElementsOutOfRangeException.class, () -> {
            ob.solution(list);
        });
    }

    @Test
    void solutionProperResult1() {
        List<Integer> testList = new ArrayList<>(
                List.of(-5, -4, -3, -2, -2, -1));
        Zad2 ob = new Zad2();

        int exp = 1;
        try {
            int actual = ob.solution(testList);
            Assertions.assertEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void solutionProperResult2() {
        List<Integer> testList = new ArrayList<>(
                List.of(-3, -2, -2, -1, 1, 3, 5));
        Zad2 ob = new Zad2();

        int exp = 2;
        try {
            int actual = ob.solution(testList);
            Assertions.assertEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }

    @Test
    void solutionProperResult3() {
        List<Integer> testList = new ArrayList<>(
                List.of(3, -2, -2, 1, 1, 2, 3));
        Zad2 ob = new Zad2();

        int exp = 4;
        try {
            int actual = ob.solution(testList);
            Assertions.assertEquals(exp, actual);
        } catch (Exception e) {
            Assertions.fail();
        }
    }


}
