package Sorting;

public class bubble_sort {

    public static void bubble_sort(int arr[], int n )
    {
        int temp ;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n - i - 1 ; j++)
            {
                if(arr[j] > arr[j+1])
                {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j]=temp;
                }
            }
        }
    }
    

    public static void main(String[] args) {
        int arr[] = {13,46,24,52,20,9};
        int n = arr.length;

        bubble_sort(arr, n);

        System.out.print("After the sorting : ");

        for(int i = 0 ; i< n ;i++)
        {
            System.out.print(arr[i]+ " ");
        }
        
    }
}
