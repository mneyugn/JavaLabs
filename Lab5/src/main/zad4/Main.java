package main.zad4;

public class Main {
    public static void main(String[] args) {
        zad4();
    }

    private static void zad4() {
        float[] arr = {-1, 2, 3, 4, 5,5};
        Zad4 ob = new Zad4();

        try {
            int[] tab = ob.solution(arr, 10);
            System.out.println(tab[0] + ", " + tab[1]);

        } catch (NoSolutionException e) {
            System.out.println(e.getMessage());
        }
    }
}