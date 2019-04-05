package main.zad2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestSuite2_ExceptionTest {
    private List<Integer> list;
    private Zad2 ob;

    @Before
    public void setUp(){
        ob = new Zad2();
        list = new ArrayList<>();
    }


    @Test
    public void Should_ThrowException_When_ListIsEmpty() {
        list = new ArrayList<>();
        try {
            ob.solution(list);
            fail("Expected an exception to be thrown");
        } catch (ArraySizeOutOfRangeException e) {
            System.out.println("passed");
        } catch (ArrayElementsOutOfRangeException e) {
            fail("Unexpected ArrayElementsOutOfRangeException");
        }
    }

    @Test
    public void Should_ThrowException_When_ListHasTooManyElements(){
        for (int i = 0; i < 100001; i++) {
            list.add(-1);
        }

        try {
            ob.solution(list);
            fail("Expected an exception to be thrown");
        } catch (ArraySizeOutOfRangeException e) {
            System.out.println("passed");
        } catch (ArrayElementsOutOfRangeException e) {
            fail("Unexpected ArrayElementsOutOfRangeException");
        }
    }


    @Test
    public void
    Should_ThrowException_When_ListElementIsTooBig() {
        list.add(1000001);

        Zad2 ob = new Zad2();
        try {
            ob.solution(list);
            fail("Expected an ArrayElementsOutOfRangeException to be thrown");
        } catch (ArrayElementsOutOfRangeException e) {
            System.out.println("testExpectedArrayElementsOutOfRangeException passed");
        } catch (ArraySizeOutOfRangeException e) {
            fail("Unexpected ArraySizeOutOfRangeException");
        }
    }
}