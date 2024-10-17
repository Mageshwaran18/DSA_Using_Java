package Sorting;

/*
 * It's the opposite of the selection sort.
 * Where as the selection sort involves moving the smallest element to the front , in selection sort for every iteration the i-1 of the array will be sorted
 * Where as the bubble sort involves moving the greatest element to the last , in bubble sort for every iteration ,the element after i (i+1,i+2...) of the array will be sorted
 *          --> Traverse from the last (i)
 *          --> In the inner loop Traverse from the 0 till the i
 *                      --> If the greater element is found , moved that to the end of the list Or till the i
 */

public class bubble_sort {

    public static void bubble_sort(int arr[])
    {
        int n = arr.length;
        for(int i = n-1 ; i >= 0 ; i--)
        {
            for(int j = 0 ; j < i  ; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);
        
        bubble_sort(arr);
        
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
