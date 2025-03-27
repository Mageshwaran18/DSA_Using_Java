package Sorting;
  /* Refer to insertion sort, then try to understand the recursive insertion sort (it will be easier to understand) */
  /* We know that insertion sort works on the concept of placing the element at the right position.
 * The first element is always assumed to be sorted so that it will be easy for comparing the first element and the previous element.
 */

public class recursive_insertion_sort {

    public static void insertion_sort(int arr[],int j)
    {
        if(j==arr.length)
        {
            return;
        }
        while(j > 0 && arr[j-1] > arr[j])
        {
            int temp = arr[j];
            arr[j] = arr[j-1];
            arr[j-1] = temp;
            j--;
        }

        insertion_sort(arr, j+1);
    }


    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);
  
        insertion_sort(arr,1);
  
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
