
package main.zad1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixTest {


    @Test
    void addIntMatrix() {
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
    void addDoubleMatrix() {
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


    @Test
    void testExpectedInvalidParameterException() {
        Number[][] matrix = {{1, 2, 3, 4},
                            {1, 2, 3, 4},
                            {1, 2, 3, 4}};

        Number[][] matrix2 = {{1, 2, 3},
                              {1, 2, 3}};

        Number[][] resultTab = {{2, 4, 6, 8},
                                {2, 4, 6, 8},
                                {2, 4, 6, 8}};

        Matrix<Number> m1 = new Matrix<>(matrix);
        Matrix<Number> m2 = new Matrix<>(matrix2);
        Matrix<Number> resultMatrix = new Matrix<>(resultTab);

        Assertions.assertThrows(InvalidParameterException.class, () -> {
            Matrix<Number> sumMatrix = new Matrix<>(m1.add(m2));
        });
    }
}