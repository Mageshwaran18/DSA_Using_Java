package Array.Strivers.Easy;


import java.util.HashMap;
import java.util.Map;

public class longest_subarray_with_sum_k_pos_neg {

    public static int fun(int[] a,int k)
    {
        
        int summ = 0;
        Map<Integer,Integer> m = new HashMap<>();
        int maxi = 0;
        int n = a.length;
        for(int i = 0 ; i < n ; i++)
        {
            summ+=a[i];
            if(summ==k)
            {
                maxi = Math.max(maxi,i+1);
            }
            
            int rem = summ-k;
            
            if(m.containsKey(rem))
            {
                int len = i - m.get(rem);
                maxi = Math.max(maxi,len);
            }
            
            if(!m.containsKey(summ))
            {
                m.put(summ,i);
            }
        }
        
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {1 ,2 ,4 ,2 ,-3,2};
        int k = 4;
        int result =fun(nums, k);
        System.out.println("Length of subarray with sum " + k + ": " + result);
    }
    
}
