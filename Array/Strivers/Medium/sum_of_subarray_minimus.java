package Array.Strivers.Medium;

public class sum_of_subarray_minimus {

    public static int nge(int st , int[] nums)
    {
        int count = 1;
        for(int i=st+1 ; i < nums.length ; i++)
        {
            if(nums[st]<nums[i])
            {
                count++;
            }
            else
            {
                break;
            }
        }
        return count;
    }

    public static int pge(int st,int[] nums)
    {
        int count = 1;
        for(int i = st-1 ; i >= 0 ; i--)
        {
            if(nums[st]<nums[i])
            {
                count++;
            }
            else
            {
                break;
            }
        }

        return count;
    }

    public static int sum_of_subarray_minimus(int []nums)
    {
        int ans = 0 ; 
        for(int i = 0 ; i < nums.length ; i++)
        {
            int left = nge(i,nums);
            int right = pge(i,nums);
            int tot = left * right * nums[i];
            ans+=tot;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {11,81,94,43,3};
        int result = sum_of_subarray_minimus(nums);
        System.out.println("Sum of subarray minimums: " + result);
    }
 
    
}