package Array.Strivers.Hard;

import java.util.*;
import java.util.stream.IntStream;

/* LeetCode :- 15 https://leetcode.com/problems/3sum/ */

/* For your own approach revise the two sum problem , then you get your own solution 
 * For optimal refer DSA notes ( Strivers )
 */

public class ThreeSum {
    
    public static List<List<Integer>> ThreeSum_My_Approach(int []nums)
    {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        int n = nums.length;
        for(int i : nums )
        {
            arr.add(i);
        }
        for(int i = 0 ; i < n ; i++)
        {
            int found = arr.get(i);
            arr.remove(i);
            int req = 0 - found;
            int low = 0 , high = n - 2;
            while(low<high)
            {
                int res = arr.get(low)+arr.get(high);
                if(res==req)
                {
                    List<Integer> temp = new ArrayList<>(Arrays.asList(arr.get(low),arr.get(high),found));
                    Collections.sort(temp);
                    if(!set.contains(temp))
                    {
                        set.add(temp);
                        ans.add(temp);
                    }
                    // for the same found we can also get multiple two sum.
                    // So we kept on moving low and high till we ensure there is no possible two sum can be found.
                    low++;
                    high--;
                }
                else if(res<req)
                {
                    low++;
                }
                else
                {
                    high--;
                }
            }
            arr.add(i, found);   
        }

        return ans;
    }

    public static List<List<Integer>> strivers_approach(int []nums)
    {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length ; i++)
        {

            // if(first element will always going to be unique && find the next unique element)
            if(i!=0 && nums[i]==nums[i-1])
            {
                continue;
            }
            else
            {
                int j = i+1;
                int k = nums.length-1;
                int found = nums[i];
                int req = 0 - found;
                while(j<k)
                {
                    int temp = nums[j]+nums[k];
                    if(temp<req)
                    {
                        j++;
                    }
                    else if(temp>req)
                    {
                        k--;
                    }
                    else
                    {
                        ans.add(Arrays.asList(found,nums[j],nums[k]));

                        // As we found the required move the low and high 
                        j++;
                        k--;

                        // find the next unique element
                        while(j < k && nums[j]==nums[j-1])j++;
                        while(j < k && nums[k]==nums[k-1])k--;
                      
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println("Results from my approach:");
        List<List<Integer>> result1 = ThreeSum_My_Approach(nums);
        for(List<Integer> triplet : result1) {
            System.out.println(triplet);
        }
        
        System.out.println("\nResults from Striver's approach:");
        List<List<Integer>> result2 = strivers_approach(nums);
        for(List<Integer> triplet : result2) {
            System.out.println(triplet);
        }
    }
}