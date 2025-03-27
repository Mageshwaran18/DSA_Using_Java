package Array;

import java.util.*;

public class create_all_subarray {

    public static List<List<Integer>> all_subarray(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        
        for(int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = i; j < n; j++) {
                temp.add(nums[j]);
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }
    
    
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        List<List<Integer>> result = all_subarray(nums);
        System.out.println("All subarrays:");
        for(List<Integer> subarray : result) {
            System.out.println(subarray);
        }
    }
}
