package Sliding_Window;

class max_sum_subarray_size_k
{

    public static int max_sum_subarray_size_k(int nums[],int k)
    {
        int ans = 0 , sum = 0;
        int j = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            sum+=nums[i];
            while(i-j+1 > k)
            {
                sum-=nums[j];
                j+=1;
            }
            if(sum > ans)
            {
                ans=sum;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 3;
        int maxSum = max_sum_subarray_size_k(nums, k);
        System.out.println("Maximum sum of subarray of size " + k + " is: " + maxSum);
    }
}