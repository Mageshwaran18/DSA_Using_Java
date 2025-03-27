package Know_Basic_Recursion;
import java.util.*;

/* Basic reverse the function needs an array , a left pointer (0) , a right pointer (arr.length - 1)  , swap them 
 * For every recursive call decrement r and increment the l and swap it 
 * Base condition for the recursive call is l > r 
*/

public class reverse_an_array {

    public static void reverse(int arr[]  , int r , int l)
    {
        if(l>r)
        {
            return ; 
        }
        int temp = arr[l];
        arr[l++] = arr[r];
        arr[r--] = temp;

        reverse(arr, r, l);
    }

    public static void main(String[] args) {
        
        int arr [] = {1,2,3,4,5,6,7};
        int n = arr.length;
        System.out.print("Before reversing:- ");
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print(arr[i]+" ");
        }
        reverse(arr, n-1, 0);
        System.out.print("\n After reversing:-");
        for(int i = 0 ; i < n ; i++)
        {
            System.out.print(arr[i]+" ");
        }


    }
    
}
