package Array.Strivers.Medium;

public class dutch_national_flag {
    public void sortColors(int[] nums) 
    {
        int low = 0 ; 
        int high = nums.length-1;
        int mid = 0;
        while(mid<=high)
        {
            int temp = nums[mid];
            if(nums[mid]==0)
            {
                nums[mid++]=nums[low];
                nums[low++]=temp;
            }
            else if(nums[mid]==2)
            {
                nums[mid]=nums[high];
                nums[high--]=temp;
            }
            else
            {
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        dutch_national_flag solution = new dutch_national_flag();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        for(int num : nums) {
            System.out.print(num + " ");
        }
    }
}