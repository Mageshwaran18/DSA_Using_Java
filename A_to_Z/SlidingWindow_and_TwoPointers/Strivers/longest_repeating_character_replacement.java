package SlidingWindow_and_TwoPointers.Strivers;

import java.util.Collections;
import java.util.HashMap;

/* Before solving this Solve Longest substring without repeating character Leetcode No : 3 */

/* Leetcode No : 424 */



/*
 *  Better Approach-->This question is a combination of Hashing + Two pointer (window shrinking) + Slidingwindow 
 *                  Find the conditions for the alphabets that're need to be in the window ->
 *                  * The window cosits of two elements 1. The maximum occurence element  2. Different elements (The number of different elements should not be greater than K).
 *                  If any above condition fails then shrikage the window till the condition is statisfied.
 *                  To find condition 1 Use hashmap (maxi)
*                   To find condition 2 Use window + two pointers -> The number of different elements can be Total elements (r-l+1) in the window  - maximum occurence element
 *                  Alwas update the res with the length of the window 
 */

public class longest_repeating_character_replacement {

    public static int better_longestRepeatingCharacterReplacement(String s, int k)
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

    public static int optimal_longestRepeatingCharacterReplacement(String s, int k)
    {
        HashMap<Character,Integer> hm = new HashMap<>();
        int maxi = 0;
        int ans = Integer.MIN_VALUE;
        int left = 0;
        for(int right = 0; right < s.length() ; right++)
        {
            char c = s.charAt(right);
            hm.put(c,hm.getOrDefault(c,0)+1);
            maxi = Math.max(maxi,hm.get(c));
            if(maxi+k < right-left+1)
            {
                char temp = s.charAt(left);
                hm.put(temp,hm.get(temp)-1);
                left++;
            }
            ans=Math.max(right-left+1,ans);
        }

        return ans;
    }
    public static void main(String []args)
        String s = "AABABBA";
        int k = 1;
        int result1 = better_longestRepeatingCharacterReplacement(s, k);
        System.out.println("Longest repeating character replacement: " + result1);
        int result2 = optimal_longestRepeatingCharacterReplacement(s, k);
        System.out.println("Longest repeating character replacement: " + result2);
    }
}
