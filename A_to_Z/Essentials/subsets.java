package Essentials;

import java.util.*;

class subsets
{

    static List<Integer> sub = new ArrayList<>(); // defining as static helps to be accessed by the static methods 
    static List<List<Integer>> res = new ArrayList<>(); // defining as static no need to create objects for accessing these variables


    public static void fun(int []nums, int i)
    {
        if(i == nums.length)
        {
            res.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]); // add that index 
        fun(nums,i+1);
        sub.remove(sub.size()-1); // remove that index ( indirectly tells to ignore that index )
        fun(nums,i+1);
        return;
    }

    public static List<List<Integer>> subsets(int []nums)
    {
        sub.clear();  // removes all elements from the subset list
        res.clear();  // removes all elements from the result list
        fun(nums,0);
        return res;
    }

    public static void main(String []args)
    {
        int nums[] = {1,2,3};
        List<List<Integer>>ans = subsets(nums);
        for(List<Integer> i: ans)
        {
            System.out.print("{ ");
            for(int j : i)
            {
                System.out.print(j + " ");
            }
            System.out.println( " }");
        }
    }

}