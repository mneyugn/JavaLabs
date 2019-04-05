package main.zad3;

import java.security.InvalidParameterException;

public class Zad3 {

    int substring(String a, String b) {
        if (a == null || b == null) throw new InvalidParameterException("Empty string");
        StringBuilder sb = new StringBuilder(a);

        int repetitionLimit = (b.length() > a.length()) ? (b.length() / a.length() + 1) : 2;  // maksymalna liczba powtórzeń pętli for
                                                                                                // potrzebna do znalezienia liczby
        for (int i = 1; i <=repetitionLimit; i++) {
            if (sb.indexOf(b) != -1) {
                return i;
            }
            sb.append(a);
        }
        return -1;
    }
}
