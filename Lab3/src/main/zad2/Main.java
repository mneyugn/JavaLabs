package main.zad2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        zad2();
    }





    private static void zad2() {
        List<Integer> list;
        int currentSolution;

        Integer[][] exampleList = {{-5,-4,-3,-2,-2,-1},
                                   {-3,-2,-2,-1,1,3,5},
                                   {3,-2,-2,1,1,2,3},
                                   {1,2,3,4,5,6,7},
                                   {},
                                   {10000000}};

        Zad2 ob = new Zad2();
//        Random generator = new Random();

        for (int i = 0; i < 5; i++) {

            list = new ArrayList<>(Arrays.asList(exampleList[i]));

            try {
                currentSolution = ob.solution(list);
                Collections.sort(list);
                System.out.println(list + "\n Solution: " + currentSolution + "\n");

            } catch (ArrayElementsOutOfRangeException | ArraySizeOutOfRangeException e) {
                System.out.println(e.getMessage());

            }
        }
    }
}






//            for (int j = 0; j < 10; j++) {
//                list.add(generator.nextInt(15) - 6);
//            }