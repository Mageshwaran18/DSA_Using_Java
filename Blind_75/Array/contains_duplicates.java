package Blind_75.Array;

import java.util.HashSet;

/* LeetCode :- 217 https://leetcode.com/problems/contains-duplicate/description/ */

/* Better Approach :- Sort the array and check all the previous element 
 *                    T.C :- O ( n logn)
 *                    S.C :- O (1)
 * Optimal Approach :- Use Hash Set
 *                    T.C :-  O(n)
 *                    S.C :- O(n) -> where all the elements are unique.
 */


 /* 
 * You cannot use the XOR approach for this problem. Here's why:
 * 
 * Why XOR Doesn't Work Here?
 * The XOR trick works in problems where:
 * 
 * You need to find a single unique element (e.g., "Find the element that appears once when every other appears twice").
 * 
 * XOR cancels out identical numbers (because a⊕a=0)
 * 
 */public class contains_duplicates {

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> st = new HashSet<>();
        for(int i : nums)
        {
            st.add(i);
        }
        if(st.size()==nums.length)
        {
            return false;
        }
        else
        {
            return true;
        }
    }


    
}
