package main.zad2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zad2 {

    public int solution(List<Integer> a) throws ArrayElementsOutOfRangeException, ArraySizeOutOfRangeException {
        if (a.size() > 1E5 || a.isEmpty())
            throw new ArraySizeOutOfRangeException("Liczba elementów tablicy nie należy do przedziału [1,1E5] ");

        List<Integer> b = new ArrayList<>(a);
        Collections.sort(b);

        if (b.get(0) < -1E6 || b.get(b.size() - 1) > 1E6) throw new ArrayElementsOutOfRangeException("Wartość elementów tablicy jest poza zakresem");

        if (b.get(b.size() - 1) < 0) return 1;

        int foundValue = 1;
        int previousItem = 0;
        boolean x = false;
        for (Integer item : b) {
            if (item > 0) {
                if (item == 1 || x) {
                    if (item == previousItem) foundValue--; //na wypadek powtarzania się liczb na liście

                    if (item != foundValue) {
                        return foundValue;
                    }
                    foundValue++;
                    previousItem = item;
                    x = true;
                }
            }
        }
        return foundValue;   //gdy szukana liczba jest większa niż największy elementy listy
    }
}

