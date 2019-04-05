package main.zad2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestSuite2 {
    private Zad2 ob;
    private int exp;

    @Before
    public void setUp(){
        ob = new Zad2();
    }


    @Test
    public void Should_Pass_When_ThereAreTwoSameElements() {
        List<Integer> testList = new ArrayList<>(
                List.of(-5, -4, -3, -2, -2, -1 ,0));
        exp = 1;
        try {
            int actual = ob.solution(testList);
            assertEquals(exp, actual);
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }

    @Test
    public void Should_Pass_When_GapIsInTheMiddleOfTheList() {
        List<Integer> testList = new ArrayList<>(
                List.of(-3, -2, -2, -1, 1, 3, 5));

        exp = 2;
        try {
            int actual = ob.solution(testList);
            assertEquals(exp, actual);
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }

    @Test
    public void
    Should_Pass_When_ExpectValueOutsideTheList() {
        List<Integer> testList = new ArrayList<>(
                List.of(3, -2, -2, 1, 1, 2, 3));

        exp = 4;
        try {
            int actual = ob.solution(testList);
            assertEquals(exp, actual);
        } catch (Exception e) {
            fail("Unexpected exception" + e.getMessage());
        }
    }
}