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
        
        int arr [] = {38, 27, 43, 3, 9, 82, 10, 56, 19, 71};
        bubble_sort(arr);
        for(int i = 0 ; i < arr.length ; i++)
        {
            System.out.print(arr[i] + " ");
        }
    }
    
}
