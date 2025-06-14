package Binary_Search;
/* LeetCode :- 35 https://leetcode.com/problems/search-insert-position/description/ */

/*
 * Refer Lower Bound . Find the smallest index such that the element in that index is greater than or equal to the target.
 * T.C :- O( log n )
 */

public class search_insert_position {

        public static  int searchInsert(int[] nums, int target) {

        int n = nums.length;
        int low = 0;
        int ans = n;
        int high = n-1;
        while(low<=high)
        {
            int mid = low + ( high - low )/2;
            if(nums[mid] >= target)
            {
                ans = mid;
                high = mid-1;
            }
            else
            {
                low = mid +1;
            }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        int result = searchInsert(nums, target);
        System.out.println("Insert position: " + result);
    }
}
