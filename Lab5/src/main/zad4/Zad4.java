package main.zad4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.lang.Float.MAX_VALUE;

class Zad4 {

    int[] solution(float[] arr, float target) throws NoSolutionException {
        int[] indexTab = new int[2];
        float index1 = MAX_VALUE, index2 = MAX_VALUE;
        boolean isRepeat = false;    //w przypadku gdy znaleziono te same wartości - funkcja szuka kolejnego indeksu

        Set<Float> arr2 = new HashSet<>();
        for (float v : arr) {
            arr2.add(v);
        }

        for (float val : arr) {
            float tmp = target - val;

            if (arr2.contains(tmp)) {          // metoda contains ma stałą złożoność obliczeniową O(1)  - HashSet
                index1 = tmp;
                index2 = val;
                break;
            }
        }
        if (index1 == MAX_VALUE) throw new NoSolutionException("Zadanie nie ma rozwiązania.");
        if (index1 == index2) isRepeat = true;

        indexTab[0] = findIndex(arr, index1, false);
        indexTab[1] = findIndex(arr, index2, isRepeat);
        if (indexTab[0] == -1 || indexTab[1] == -1) throw new NoSolutionException("Zadanie nie ma rozwiązania.");
        Arrays.sort(indexTab);

        return indexTab;
    }

    public int findIndex(float[] arr, float key, boolean isRepeat) {
        int index = 0;
        for (float n : arr) {
            if (key == n) {
                if (!isRepeat) return index;
                isRepeat = false;
            }
            index++;
        }
        return -1;
    }
}

