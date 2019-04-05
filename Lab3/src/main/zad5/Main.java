package main.zad5;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        zad5();
    }


    private static void zad5() {

        final int n = 10000;
        int[] bestCase = new int[n];
        int[] averageCase = new int[n];
        int[] worstCase = new int[n];

        Random generator = new Random();
        for (int i = 0; i < n; i++) {
            bestCase[i] = i;
            averageCase[i] = generator.nextInt(n);
            worstCase[i] = n - i;
        }

        InsertionSort insertion = new InsertionSort();
        SelectionSort selection = new SelectionSort();
        QuickSort quick = new QuickSort();
        MergeSort merge = new MergeSort();
        BubbleSort bubble = new BubbleSort();

        String[] sortName = {"MergeSort", "InsertionSort", "QuickSort", "BubbleSort", "SelectionSort"};
        String[] caseName = {"Best case: ", "Average case: ", "Worst case: "};
        int[][] cases = {bestCase, averageCase, worstCase};
        int[][] cases2 = {averageCase.clone(), worstCase.clone()};


        long tStart, tEnd, tDelta;
        double elapsedSeconds;

        for (int i = 0; i < 5; i++) {
            System.out.println(sortName[i]);

            for (int j = 0; j < 3; j++) {
                System.out.print(caseName[j]);
                if (j != 0) cases[j] = cases2[j-1].clone();
                tStart = System.currentTimeMillis();
                switch (i) {
                    case 0:
                        merge.sort(cases[j], 0, n - 1);
                        break;
                    case 1:
                        insertion.sort(cases[j]);
                        break;
                    case 2:
                        quick.sort(cases[j], 0, n - 1);
                        break;
                    case 3:
                        bubble.bubbleSort(cases[j]);
                        break;
                    case 4:
                        selection.sort(cases[j]);
                }

                tEnd = System.currentTimeMillis();
                tDelta = tEnd - tStart;
                elapsedSeconds = tDelta / 1000.0;
                System.out.println(elapsedSeconds + " s");
            }
            System.out.println();
        }

//        for (int i : worstCase) {
//            System.out.println(i);
//        }
//        System.out.println(averageCase);
    }
}