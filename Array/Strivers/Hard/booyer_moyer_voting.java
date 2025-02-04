package Array.Strivers.Hard;

import java.util.*;

/* LeetCode :- 229 https://leetcode.com/problems/majority-element-ii/description/ */
/* Refer the DSA notes  */

public class booyer_moyer_voting {

    public static List<Integer> booyer_moyer_voting_using_sort(int []nums)
    {
        List<Integer> ans = new ArrayList<>();
        int fre = nums.length/3;
        Arrays.sort(nums);
        int key = nums[0];
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(nums[i] == key)
            {
                count++;
            }
            else
            {
                if(count>fre)
                {
                    ans.add(key);
                }
                key = nums[i];
                count = 1;
            }
        }

        if(count>fre)
        {
            ans.add(nums[nums.length-1]);
        }

        return ans;
    }

    public static List<Integer> booyer_moyer_voting_using_brute_force(int []nums)
    {
        List<Integer> ans = new ArrayList<>();
        List<Integer> visited = new ArrayList<>();
        int fre_need = (nums.length/3 )+1;
        for(int i = 0 ; i < nums.length;i++)
        {
            int count = 0 ;
            if(!visited.contains(nums[i]))
            {
                visited.add(nums[i]);
                for(int j = 0 ; j < nums.length ;j++)
                {
                    if(nums[i]==nums[j])
                    {
                        count++;
                    }
                }
            }
            if(count >= fre_need)
            {
                ans.add(nums[i]);
            }
            if(ans.size()==2)
            {
                break;
            }
        }
        return ans;
    }
    
    public static List<Integer> booyer_moyer_voting_optimized_moyer_algo(int []nums)
    {
        List<Integer> ans = new ArrayList<>();
        int fre = nums.length/3;
        int c1 = 0 , c2 = 0 , k1 = 0 , k2 = 0 ;
        for(int i = 0 ; i < nums.length ; i++)
        {
            if(k1==nums[i])
            {
                c1++;
            }
            else if(k2==nums[i])
            {
                c2++;
            }
            else if(c1==0 && k2!=nums[i])
            {
                k1=nums[i];
                c1=1;
            }
            else if(c2==0 && k1!=nums[i])
            {
                k2=nums[i];
                c2=1;
            }
            else
            {
                c1--;
                c2--;
            }
        }

        // to check both are valid as there is probability where only one element is valid 
        c1=0;
        c2=0;
        for(int i = 0 ; i < nums.length ;i++)
        {
            if(nums[i]==k1)
            {
                c1++;
            }
            else if(nums[i]==k2)
            {
                c2++;
            }
        }

        if(c1>fre)
        {
            ans.add(k1);
        }
        if(c2>fre)
        {
            ans.add(k2);
        }

        return ans;
    }
}
