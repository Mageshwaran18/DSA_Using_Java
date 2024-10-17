package Sorting;

import java.util.*;

/*
 * Quick Sort is a divide-and-conquer algorithm like Merge Sort.
 * Unlike Merge sort, this algorithm does not use any extra array for sorting
 * (though it uses auxiliary stack space). From that perspective, Quick sort
 * is slightly better than Merge sort.
 *
 * This algorithm is basically a repetition of two simple steps:
 * 1. Pick a pivot and place it in its correct place in the sorted array.
 * 2. Shift smaller elements (i.e. smaller than the pivot) to the left of the pivot
 *    and larger ones to the right.
 *
 * In the partition step:
 * - i moves from low until it finds an element greater than the pivot (not exceeding high)
 * - j moves from high until it finds an element smaller than the pivot (not going below low)
 * - If i crosses j, then j is the position where the pivot needs to be placed.
 *
 * Reference: https://youtu.be/WIrA4YexLRQ?si=snPQ1mMv7b8J4y3M
 * 
 */
public class quick_sort {

    public static void swap(List<Integer>arr , int i , int j)
    {
        int temp = arr.get(i);
        arr.set(i,arr.get(j));
        arr.set(j,temp);

    }


    public static int partition(List<Integer> arr, int low , int high)
    {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while(i < j)
        {
            while(i < high && arr.get(i)<=pivot) // Move i till the element is not greater than the pivot
            {
                i++;
            }
            while( j > low && arr.get(j) > pivot) // Move j till the element is not smaller than the pivot
            {
                j--;
            }

            if(i < j) // Make sure that i didn't cross the j , if does j is the correct position that pivot need to be placed
            {
                swap(arr,i,j);
            }
        }

        swap(arr, low, j); // j is the correct position that pivot need to be placed
        return j ; 
    }

    public static void quick_sort(List<Integer> arr,int low , int high)
    {
        if(low < high)
        {
            int partion_pos = partition(arr,low,high);
            quick_sort(arr, low, partion_pos-1);
            quick_sort(arr, partion_pos + 1, high);
        }
    }


    public static void main(String[] args) {
        
        List<Integer> arr = new ArrayList<>();
        arr = Arrays.asList(new Integer[] {18,333,17,7,3,10});
        System.out.print("Before Sorting :- ");
        for(int i = 0 ; i < arr.size() ; i++)
        {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        quick_sort(arr,0,arr.size()-1);
        System.out.print("After Sorting :- ");
        for(int i = 0 ; i < arr.size() ; i++)
        {
            System.out.print(arr.get(i) + " ");
        }

    }

    
}
