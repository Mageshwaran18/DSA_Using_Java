package Hashing;

import java.util.*;

/* GeekforGeeks :- Frequencies of Limited Range Array Elements */

/* Refer the DSA notes */

/* 
 * Optimal approach --> It's difficult to naturally think this solution.
 *                  --> (1) We can replace the elements of array with frequencies and elements 
 *                  --> (2) Frequency are defined by negative numbers and elements of the array were defined with the actual positive numbers
 *                  --> (3) If arr[i] > 0 [which tells that this is an element not an frequency]  && arr[i] <= N [Constraints of the question]
 *                          --> Then if arr[arr[i]-1] is not frequency then swap the elements arr[i] and arr[arr[i]-1] , then assign the arr[arr[i]-1] = -1
 *                          --> If arr[arr[i]-1] is frequency then just decrement the value 
 *                                  --> Assign arr[i] = 0 (if i != arr[i]-1 [the index where the frequency of the element to be stored])
 *                                  --> There may be in condition where both i and arr[i] - 1 will be same for example [2,3,2,3,5] while coming to the element 5 , the index (i) is 4 and the frequency of the element 5 to be stored in the index(4)
 *                                  --> Increment the i (as we know that arr[i] will contain 0)
 *                 --> (4) If arr[i]  > N , then just assign arr[i] = 0 and increment i 
 *                 --> (5) If both of the condition is doesn't met then arr[i] will be negative (which is the frequency) or 0 (which we don't want to worry about) for these two cases we don't want to perform any action , increment i
 *
 * Time Complexity --> O(N)
*/

public class frequencies_of_limited_range_array_elements {

    public static void frequency(int arr[] , int N , int P)
    {
        for(int i = 0 ; i < arr.length ;)
        {
            if(arr[i] > 0 && arr[i] <= N)
            {
                int j = arr[i]-1;
                if(arr[j] > 0)
                {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    arr[j]=-1;
                }
                else
                {
                    arr[j]-=1;
                    if(i!=j)
                    {
                        arr[i] = 0;
                    }
                    i++;
                }
            }
            else if (arr[i] > N)
            {
                arr[i]=0;
                i++;
            }
            else
            {
                i++;
            }
        }

        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = arr[i] * -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,9};
        int N = 2;
        int P = 9;
        
        System.out.println("Original array: " + Arrays.toString(arr));
        frequency(arr, N, P);
        System.out.println("Array after frequency calculation: " + Arrays.toString(arr));
        
        for (int i = 0; i < N; i++) 
        {
            System.out.println("Frequency of " + (i + 1) + ": " + Math.abs(arr[i]));
        }
    }
   
    
}
