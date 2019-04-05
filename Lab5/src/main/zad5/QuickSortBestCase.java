package main.zad5;

public class QuickSortBestCase
{
    public static void generate(int[] arr, int begin, int end)
    {
        int count = end - begin;
        if(count < 3)
            return;

        int middle = begin + (count - 1) / 2;
        generate(arr, begin, middle);
        swap(arr, begin, middle);
        generate(arr, ++middle, end);
    }

    private static void swap(int[] arr, int i, int j)
    {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

   static void fillArray(int[] arr)
    {
        for(int i = 1; i < arr.length; i++)
            arr[i] = i;
    }

    private static void printArray(int[] arr)
    {
        for(int item : arr)
            System.out.print(item + " ");
    }

    public static void main(String[] args)
    {
        int[] arr = new int[7];
        fillArray(arr);
        generate(arr, 0, arr.length);

        printArray(arr);
    }
}