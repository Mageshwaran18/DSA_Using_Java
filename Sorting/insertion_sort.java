package Sorting;

/* Insert the element to it's correct position */

/*
 * In insertion sort , for the first iteration we assume that first element is sorted
 * Outer loop -> Traverse from the 0 to n 
 * Inner loop -> Pick an element , compare that with the left element , if it's left swap it 
 *            -> Repeat this untill the above condition fails
 * 
 */


public class insertion_sort {
    
    public static void insertion_sort(int arr[])
    {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            int j = i ;
            while(j > 0 && arr[j-1] > arr[j])
            {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);
  
        insertion_sort(arr);
  
        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

  
}
