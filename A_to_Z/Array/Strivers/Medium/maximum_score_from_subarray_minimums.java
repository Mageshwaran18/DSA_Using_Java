package Array.Strivers.Medium;

import java.util.*;

class maximum_score_from_subarray_minimums
{
    public static int pairWithMaxSum(int arr[]) {
    
        int ans=Integer.MIN_VALUE;
        int n =  arr.length;
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                int s = Integer.MAX_VALUE;
                int ss = Integer.MAX_VALUE;
                for(int k = i ; k < n - j ; k++)
                {
                    if(arr[k]<s)
                    {
                        int temp = s;
                        s = arr[k];
                        ss = temp;
                    }
                    else if(arr[k]<ss)
                    {
                        ss = arr[k];
                    }
                }
                if(ss!=Integer.MAX_VALUE && s+ss>ans)
                {
                    ans=s+ss;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {228, 394, 463, 227, 388, 757, 782, 238, 967};
        System.out.println(pairWithMaxSum(arr));
    }
}