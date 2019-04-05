package main.zad1;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        zad1();
    }



    private static void zad1() {
        final int rows = 4;
        final int columns = 4;

        Number[][] matrix;
        Number[][] matrix2;
        Random generator = new Random();

        for (int i = 0; i < 2; i++) {

            if (i == 0) {
                matrix = new Integer[rows][columns];
                matrix2 = new Integer[rows][columns];
            } else {
                matrix = new Double[rows][columns];
                matrix2 = new Double[rows][columns];
            }

            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    if (i == 0) {
                        matrix[j][k] = generator.nextInt(20);
                        matrix2[j][k] = generator.nextInt(20);
                    } else {
                        matrix[j][k] = generator.nextDouble();
                        matrix2[j][k] = generator.nextDouble();
                    }
                }
            }
            Matrix<Number> m1 = new Matrix<>(matrix);
            Matrix<Number> m2 = new Matrix<>(matrix2);

            m1.print();
            System.out.println("\t   +\t");
            m2.print();

            System.out.println("\nSUM:");
            Matrix<Number> k = new Matrix<>(m1.add(m2));
            k.print();

            System.out.println("\n\n");
        }
    }
}
