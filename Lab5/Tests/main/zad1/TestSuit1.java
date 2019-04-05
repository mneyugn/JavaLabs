package main.zad1;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;


public class TestSuit1 {

    @Test
    public void Should_ResultBeInteger_When_AddingIntegerMatrix() {
        Number[][] matrix = {{1, 2, 3, 4},
                             {1, 2, 3, 4},
                             {1, 2, 3, 4}};

        Number[][] matrix2 = {{1, 2, 3, 4},
                              {1, 2, 3, 4},
                              {1, 2, 3, 4}};

        Number[][] resultTab = {{2, 4, 6, 8},
                                {2, 4, 6, 8},
                                {2, 4, 6, 8}};

        Matrix<Number> m1 = new Matrix<>(matrix);
        Matrix<Number> m2 = new Matrix<>(matrix2);

        Matrix<Number> resultMatrix = new Matrix<>(resultTab);

        Matrix<Number> sumMatrix = new Matrix<>(m1.add(m2));

        for (int i = 0; i < sumMatrix.getMatrix().length; i++) {
            assertArrayEquals(sumMatrix.getMatrix()[i], resultMatrix.getMatrix()[i]);
        }
    }

    @Test
    public void Should_ResultBeDouble_When_AddingDoubleMatrix() {
        Number[][] matrix = {{1., 2., 3., 4.},
                             {1., 2., 3., 4.},
                             {1., 2., 3., 4.},
                             {1., 2., 3., 5.}};

        Number[][] matrix2 = {{2., 3., 4., 5.},
                              {2., 3., 4., 5.},
                              {2., 3., 4., 5.},
                              {2., 3., 4., 5.}};

        Number[][] matrix3 = {{3., 5., 7., 9.},
                              {3., 5., 7., 9.},
                              {3., 5., 7., 9.},
                              {3., 5., 7., 10.}};


        Matrix<Number> m1 = new Matrix<>(matrix);
        Matrix<Number> m2 = new Matrix<>(matrix2);
        Matrix<Number> resultMatrix = new Matrix<>(matrix3);

        Matrix<Number> sumMatrix = new Matrix<>(m1.add(m2));

        for (int i = 0; i < sumMatrix.getMatrix().length; i++) {
            assertArrayEquals(sumMatrix.getMatrix()[i], resultMatrix.getMatrix()[i]);
        }
    }


    @Test(expected = InvalidParameterException.class)
    public void testExpectedInvalidParameterException() {
        Number[][] matrix = {{1, 2, 3, 4},
                             {1, 2, 3, 4},
                             {1, 2, 3, 4}};

        Number[][] matrix2 = {{1, 2, 3},
                              {1, 2, 3}};

        Matrix<Number> m1 = new Matrix<>(matrix);
        Matrix<Number> m2 = new Matrix<>(matrix2);

        new Matrix<>(m1.add(m2));
    }


    @Test
    public void Should_ResultBeInteger_When_AddingInteger() {
        Integer exp = 5;
        assertEquals(exp,Matrix.addNumbers(4,1));
    }


    @Test
    public void Should_ResultBeDouble_When_AddingDouble() {
        Double exp = 10.;
        assertEquals(exp,Matrix.addNumbers(4.,6.));
    }


    @Test
    public void Should_False_When_UseHasNextOnEmptyMatrix() {
        Number[][] numberMatrix = {{}};
        Matrix<Number> matrix = new Matrix<>(numberMatrix);
        assertFalse(matrix.hasNext());
    }


    @Test(expected = NoSuchElementException.class)
    public void Should_ThrowNoSuchElementException_When_UseNextOnEmptyMatrix() {
        Number[][] numberMatrix = {{}};
        Matrix<Number> matrix = new Matrix<>(numberMatrix);
        matrix.next();
    }


    @Test
    public void printTest() {
        Number[][] matrix = {{1, 2},
                             {1, 2}};
        Matrix<Number> matrix1 = new Matrix<>(matrix);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        matrix1.print();

        String expectedOutput  = "1 2 \n1 2 \n\n";

        assertEquals(expectedOutput, outContent.toString());
    }
}