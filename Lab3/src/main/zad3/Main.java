package main.zad3;


public class Main {
    public static void main(String[] args) {
        zad3();
    }


    private static void zad3() {
        String[] a = {"abcd", "acccccccca", "a"};
        String[] b = {"cdabcdab", "cccaaccc", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"};
        Zad3 ob = new Zad3();

        for (int i = 0; i < 3; i++) {
            System.out.println("Example " + (i + 1));
            System.out.println("a: " + a[i] + "\t b: " + b[i]);
            System.out.println(ob.substring(a[i], b[i]) + "\n");
        }
    }
}