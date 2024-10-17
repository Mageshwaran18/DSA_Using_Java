package Sorting;

/* If the i is 0 , then traverse from the i + 1 to till the end of the list and find the minium element of arr[i+1:length-1] 
 * Replace the element of arr[i] and the minimum of the following arr[i+1;length-1]
 * 
 * Time Complexity --> O(n^2)
*/

public class selection_sort {

    public static void selection_sort(int arr[])
    {
        for(int i = 0 ; i < arr.length ; i++)
        {
            int mini = i ; 
            /*  i la irunthu next entha element chinnathunu paru */
            for(int j = i + 1 ; j < arr.length ; j++)
            {
                if(arr[j] < arr[mini])
                {
                    mini = j ; /* athoda index store panniko */
                }
            }

            int temp = arr[mini]; /* i oda indexla than ippo antha chinna element irukanum , so replace the arr[i] with the chinna element using mini */
            arr[mini] = arr[i];
            arr[i] = temp;
        }
        /* for every iteration of i , the array behind the i-1 will be sorted */
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Original array:");
        printArray(arr);
  
        selection_sort(arr);
  
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
