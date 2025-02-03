package Array.Strivers.Medium;

import java.util.ArrayList;
import java.util.List;

/* LeetCode :- 442 https://leetcode.com/problems/find-all-duplicates-in-an-array/ */

/*
 * Optimal approach --> Just they gave a hint to you directly in their question itself , read it carfully 
 *                  --> Hint:- An integer array nums of length n where all the integers of nums are in the range [1, n]
 *                  --> Just see the hind and see the code you can guess the solution , 
 *                  --> if i = 9 , then mark nums[i] as negative , So while travesring if you find the nums[i] as negative number , then it's already been repeated 
 *                  
 */     

public class find_all_duplicates_or_number_repeated_twice_in_a_array {

            public List<Integer> findDuplicates(int[] nums) {
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++)
        {
            int index = Math.abs(nums[i])-1;
            if(nums[index] < 0)
            {
                ans.add(Math.abs(nums[i]));
            }
            else
            {
                nums[index]*=-1;
            }
        }
        
        return ans;
    }
    

    public static void main(String[] args) {
        find_all_duplicates_or_number_repeated_twice_in_a_array solution = new find_all_duplicates_or_number_repeated_twice_in_a_array();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> result = solution.findDuplicates(nums);
        System.out.println("Numbers that appear twice: " + result);
    }
    
}