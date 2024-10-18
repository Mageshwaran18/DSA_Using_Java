package Sorting;

public class recursive_bubble_sort {

    /* Bubble sort the last element is need not to be compared because in the first iteration while comparing  the arr[j] with arr[j+1] it will cross index out of bound error  */

    public static void recursive_bubble_sort(int arr[] , int n)
    {
        
        if(n==0)
        {
            return;// if the length of the arr is 0 then it shows that we don't have any element in the array to be compared
            // n==0 tells that all the elements in the array is sorted no more comparing is required
        }

        for(int j = 0 ; j < n-1 ; j++)
        {
            if(arr[j] > arr[j+1])
            {
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }

        recursive_bubble_sort(arr, n-1);

        

    }


    public static void main(String args[]) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Before Using Bubble Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        recursive_bubble_sort(arr, n);
        System.out.println("After bubble sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
}
