package Array.Strivers.Medium;

import java.util.*;

/* LeetCode :- 169 https://leetcode.com/problems/majority-element/description/ */

public class moores_voting {

    public static int moores_voting_using_hashing(int []nums)
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        for(int i = 0 ; i < nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],1)+1);
        }
        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            pq.add(entry);
        }

        Map.Entry<Integer,Integer> temp = pq.poll();
        return temp.getKey();
    }

    public static int moores_voting_algo(int []nums)
    {
        int key = nums[0];
        int count = 0;
        for(int i = 0  ; i < nums.length ; i++)
        {
            if(nums[i]==key)
            {
                count++;
            }
            else if(count==0)
            {
                key=nums[i];
            }
            else
            {
                count--;
            }
        }

        return key;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        
        System.out.println("Result using hashing: " + moores_voting_using_hashing(nums));
        System.out.println("Result using Moore's voting algorithm: " + moores_voting_algo(nums));
    }
}
