package Back_Tracking;

import java.util.ArrayList;
import java.util.List;

public class permutation_of_num {

    public static List<List<Integer>> permutation_of_num(int nums[])
    {
        // res.clear();
       List<List<Integer>> res = new ArrayList<>();
       List<Integer> arr = new ArrayList<>();
        for(int i : nums)
        {
            arr.add(i);
        }
        List<Integer> perm = new ArrayList<Integer>();
        helper(arr,res,perm); 
        return res;  
    }

    

        public static void helper(List<Integer> nums ,List<List<Integer>> res, List<Integer> perm)
        {
            if(nums.size() == 0)
            {
                res.add(perm);
                return;
            }
            for(int i = 0 ; i < nums.size() ; i++)
            {
                List<Integer> new_nums = new ArrayList<>(nums);
                int temp  = new_nums.remove(i);
                List<Integer> new_perm = new ArrayList<>(perm);
                new_perm.add(temp);
                helper(new_nums,res,new_perm);
            }
        }
    public static void main(String []args)
    {
        int nums[] = {1,2,3};
        List<List<Integer>> ans = permutation_of_num(nums);
        for(List<Integer> i : ans)
        {
            System.out.print("[");
            for(int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println("]");
        }


    }
    
    
}
