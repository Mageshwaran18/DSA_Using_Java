package SlidingWindow_and_TwoPointers.Strivers;
import java.util.*;

/* LeetCode :- 904 https://leetcode.com/problems/fruit-into-baskets/ */

/*
 * My Approach --> We need to find the window condition, and the window condition is 
 *                 "Each window can have at most two different characters". To keep track of that I will be using the set.
 *                 We need hashmap because consider this test case where 3, 3, 3, 2, 1 
 *                 if my right pointer is at 1 and left pointer is at 3(0th index) then I need to move my left pointer till all the occurrences of 3 becomes 0.
 *                 Once the occurrence of the 3 becomes 0 then I can remove that from the set. So for that we need the hashmap.
 *
 *            --> T.C: O( 2n )
 *                     The time complexity of the code is O(2n) [moving of right pointer and the left pointer, at worst case the left pointer will also move till the end] + 
 *                     we are not considering the insertion of elements into the set and the hashmap, as at max we are going to store only two or three elements in the set and hashmap.
 *            --> S.C: O( 1 )
 *                     Space complexity is O(1) as we are using constant space for set and hashmap (storing maximum of 3 elements).
 */
public class fruits_into_basket {

    public static int total_fruit(int[] fruits)
    {
        Set<Integer> st = new HashSet<>();
        HashMap<Integer,Integer> hm = new HashMap<>();
        int left = 0;
        int ans = 0;
        for(int right = 0; right < fruits.length ; right++)
        {
            st.add(fruits[right]);
            hm.put(fruits[right],hm.getOrDefault(fruits[right],0)+1);
            while(st.size()>2)
            {
                int temp = fruits[left++];
                hm.put(temp,hm.get(temp)-1);
                if(hm.get(temp)==0)
                {
                    st.remove(temp);
                }
            }

            ans = Math.max(ans,right-left+1);
        }

        return ans;

    }
    
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 3, 2, 2};
        System.out.println("Maximum fruits that can be collected: " + total_fruit(fruits));
        
        int[] fruits2 = {0, 1, 2, 2};
        System.out.println("Maximum fruits that can be collected: " + total_fruit(fruits2));
        
        int[] fruits3 = {1, 2, 3, 2, 2};
        System.out.println("Maximum fruits that can be collected: " + total_fruit(fruits3));
    }
}
