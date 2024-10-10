package Sliding_Window;

import java.util.HashMap;

/* Before solving this Solve Longest substring without repeating character Leetcode No : 3 */

/* Leetcode No : 424 */



/*
 * This question is a combination of Hashing + Two pointer (window shrinking) + Slidingwindow 
 * Find the conditions for the alphabets that're need to be in the window ->
 *      * The window cosits of two elements 1. The maximum occurence element  2. Different elements (The number of different elements should not be greater than K).
 * If any above condition fails then shrikage the window till the condition is statisfied.
 * To find condition 1 Use hashmap (maxi)
 * To find condition 2 Use window + two pointers -> The number of different elements can be Total elements (r-l+1) in the window  - maximum occurence element
 * Alwas update the res with the length of the window 
 */

public class longest_repeating_character_replacement {

    public static int longestRepeatingCharacterReplacement(String s, int k)
    {
        HashMap <Character,Integer> hm = new HashMap<>();
        int l = 0;
        int max = Integer.MIN_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < s.length();i++)
        {
            if(hm.get(s.charAt(i))==null)
            {
                hm.put(s.charAt(i),1);
            }
            else
            {
                hm.put(s.charAt(i),hm.get(s.charAt(i))+1);
            }
            max = Math.max(max,hm.get(s.charAt(i)));
            while(((i-l+1)-max) > k)
            {
                hm.put(s.charAt(l),hm.get(s.charAt(l))-1);
                l+=1;
            }
            res=Math.max(res,(i-l+1));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        int result = longestRepeatingCharacterReplacement(s, k);
        System.out.println("Longest repeating character replacement: " + result);
    }
}
