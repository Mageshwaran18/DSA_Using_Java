package Array.Strivers.Easy;


/* LeetCode : 189 https://leetcode.com/problems/rotate-array/ */

/* Refer DSA Notes */

public class right_rotation {

    public static void reverse(int arr[],int low , int high)
    {
        while(low < high)
        {
            int temp = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
            high--;
            low++;
        }
    }

    public static void rotate_an_array(int arr[],int k)
    {
        /* With an extra space */
        
        /*
        int n = arr.length;
        int res [] = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            res[(i+k)%n] = arr[i];
        }
        print(res);
        */

        /* Without extra space */

        int n = arr.length;
        int pivot = k % n;
        pivot = n - pivot;

        reverse(arr, 0, pivot-1); // don't include pivot
        reverse(arr,  pivot , n-1); // include pivot
        reverse(arr, 0, n-1);

    }
    public static void print(int arr[])
    {
        int n = arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print(arr[i]+" ");
        }
    }

        public static void main(String[] args) {
            int arr[] = {1,2,3,4,5,6,7};
            int k = 2;
        
            System.out.println("Array before rotation:");
            print(arr);
        
            System.out.println("\n\nRotating the array by " + k + " positions to the right.\n");
        
            rotate_an_array(arr,k);
        
            System.out.println("Array after rotation:");
            print(arr);
        }
    
     
}
