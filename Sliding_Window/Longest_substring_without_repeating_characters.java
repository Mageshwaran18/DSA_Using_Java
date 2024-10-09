package Sliding_Window;

import java.util.HashMap;

/* LeetCode No :- 3 */

/* It's Straight forward approach and easy 
 * Hashing + Slidingwindow --> (1) Create a window were the window should contain without repeating value 
 *                         --> (2) To crack the repeating values use hashmap
 *                         --> (3) If the window contains duplicate letters than shrinkage the window untill it statisfy (1)
 *                         --> (4) The result of the window for every iteration is the required output
 */

public class Longest_substring_without_repeating_characters {

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int res = 0;
        
        if (s.length() < 1) {
            return 0;
        }
        
        int left = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            if (hm.get(c) != null) {
                hm.put(c, hm.get(c) + 1);
            } else {
                hm.put(c, 1);
            }
            
            while (hm.get(c) > 1) {
                char temp = s.charAt(left);
                hm.put(temp, hm.get(temp) - 1);
                left++;
            }
            
            res = Math.max(res, r - left + 1);
        }

        return res;
    }
    
    public static void main(String[] args) {
        Longest_substring_without_repeating_characters solution = new Longest_substring_without_repeating_characters();
        
        // Test cases
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "", "dvdf"};
        
        for (String testCase : testCases) {
            int result = solution.lengthOfLongestSubstring(testCase);
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
