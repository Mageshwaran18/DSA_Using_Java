package Array.Medium;
import java.util.*;

public class count_of_subarray_equals_k {

    public int count_of_subarray_equals_k(int []arr,int k)
    {
        int count = 0 ; 
        int sum = 0 ; 
        int n = arr.length;
        int rem = 0 ; 
        Map <Integer , Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i = 0 ; i < n ; i++)
        {
            sum +=arr[i];
            rem = sum - k;

            if(hm.containsKey(rem))
            {
                count+=hm.get(rem);
            }

            if(!hm.containsKey(sum))
            {
                hm.put(sum,1);
            }
            else
            {
                hm.put(sum,hm.get(sum)+1);   
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        count_of_subarray_equals_k solution = new count_of_subarray_equals_k();
        int[] arr = {1, 1, 1};
        int k = 2;
        int result = solution.count_of_subarray_equals_k(arr, k);
        System.out.println("Number of subarrays with sum " + k + ": " + result);
    }
}
