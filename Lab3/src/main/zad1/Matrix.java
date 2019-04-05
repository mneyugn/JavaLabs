package main.zad1;

import java.security.InvalidParameterException;
import java.util.*;


class Matrix<T extends Number> implements Iterator<Number>{
    private int rows;
    private int columns;
    private T[][] matrix;
    private int i, j;


    Matrix(T[][] matrix) {
        this.matrix = matrix;
        rows = matrix.length;
        columns = matrix[0].length;
    }

    T[][] getMatrix() {
        return matrix;
    }

    Number[][] add(Matrix<T> b) {
        if ((this.rows != b.rows) || (this.columns != b.columns))
            throw new InvalidParameterException("Unequal rows or columns.");

        Number[][] sum = new Number[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                sum[i][j] = addNumbers(this.matrix[i][j], b.matrix[i][j]);
            }
        }
        return sum;
    }

    private Number addNumbers(Number a, Number b) {
        if (a instanceof Double || b instanceof Double) {
            return a.doubleValue() + b.doubleValue();
        } else if (a instanceof Integer || b instanceof Integer) {
            return a.intValue() + b.intValue();
        } else if (a instanceof Long || b instanceof Long) {
            return a.longValue() + b.longValue();
        } else if (a instanceof Float || b instanceof Float) {
            return a.floatValue() + b.floatValue();
        } else if (a instanceof Short|| b instanceof Short) {
            return a.shortValue() + b.shortValue();
        } else throw new InvalidParameterException("Unknown type of parameters.");
    }


    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T element = matrix[i][j];
        j++;
        while (i < rows && j >= columns) {
            j = 0;
            i++;
        }
        return element;
    }

    @Override
    public boolean hasNext() {
        return (i < rows && j < columns);
    }

    void print(){
        for(int i=1; hasNext(); i++){
            System.out.print(next()+"\t");
            if(i%rows==0){
                System.out.println();
            }
        }
        System.out.println();
    }

    //    void print2() {
//        for (T[] rows : matrix) {
//            System.out.println(Arrays.toString(rows));
//        }
//    }
}