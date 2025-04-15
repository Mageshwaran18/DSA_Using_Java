package SlidingWindow_and_TwoPointers;

import java.util.HashMap;

/* LeetCode No :- 3 */

/* A string is said to be a substring if it's consecutive of the given string */

/* Brute Force --> (1) Create all the substrings of the given string 
 *             --> (2) Create an array with 255 size ( which represents the characters) which can be used as an hashmap
 *             --> (3) For each substring then traverse from the i to substring.length() 
 *             --> (4) The second loops starts from the i and if the hash[s[j]] is != 1 , then it's the first time it's occuring in the substring , so caluclate the length of the string using j-i+1 , then mark hash[s[j]]=1
 *             --> (5) If the hash[s[j]]==1 , then we don't want to create the subsequent substring as it already contains the duplicate elements
 *             --> Repeat (3) , (4) , (5) for every substring that has been created.
 *             --> Time Complexity --> O(n^2)
 *  
 * It's Straight forward approach and easy if solved the longest substring with repeating characters
 * 
 * My Optimal apprach -->Hashing + Slidingwindow as same as longest substring with repeating characters) 
 *                    --> (1) Create a window were the window should contain without repeating value 
 *                    --> (2) To crack the repeating values use hashmap
 *                    --> (3) If the window contains duplicate letters than shrinkage the window untill it statisfy (1)
 *                    --> (4) The result of the window for every iteration is the required output
 * 
 * Better Approach ( optimal ) --> In my apprach  I were moving the left till the window contains only distinct values , but in better apprach we can move the left exactly to position which makes the window valid
 *                             --> While updating the left if the element is found [ hm.put(c, hm.get(c) + 1) ] with +1 , we can directly update the with the index 
 *                             --> Instead of storing the hash value of character with the 0 , we can save it's index where it's occured.
 *                             --> So If you found the duplicate , we can move the left once step ahaead of the posisition where it lastly occured 
 *                             --> Lets say string adcabb , the left starts from o and right starts from 0 
 *                             --> I will update hashmap for every character with their index being found in the string.
 *                             --> So if l = 0 and r = 2 , the hash map will ['a' : 0 , 'd' : 1 , 'c' : 2 ] 
 *                             --> If r appraches the index 3 which is a , the window contains duplicate elements , now the left has to be moved to place such that the window contains no duplicates 
 *                             --> Then calculate the length of the substring with r - l +1 and update the maximum 
 *                             --> I will move the left to hash[s[r]] + 1 , which tell that we found a in the 0 index if the left is moved to one step then the window will be valid 
 *                             --> Let say string abcedd , when r = 4 then  left = 0 and hash = ['a' : 0 , 'b' : 1 , 'c' : 2 , 'e' : 3 , 'd' : 4]
 *                             --> If r = 5 , we found the duplicate so we move the left by hash[s[r]] + 1 which makes  to left move to  5 , now the window is perfect 
 *                             --> If the string is 'abba' , when r = 1 , l will be 0 and hm ['a' : 0 , 'b' : 1]
 *                             --> If the r increases then we found a duplicate so we will be moving l to the 2 (r==l) 
 *                             --> But when r moves to 3 we will be moving l to hm.get(s[r])+1 , which is 1 . Based on this the substring will be bba which is not correct 
 *                             --> To avoid this we use the condition while updating the l which is if(hm.get(s[r]) >= l) , which tell's that you can move l only towards the front not in the backward direction which may lead to the invalid substring.
 * 
 * 
 */


public class longest_substring_without_repeating_characters {

/* --------------------------- My approach -------------------------
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

    */


    public static int lengthOfLongestSubstring(String str) 
    {
        int res = 0 ; 
        int l = 0 ;

        HashMap <Character , Integer > hm = new HashMap<>();

        if (str.length() <= 0 )
        {
            return res;
        }

        for(int r = 0 ; r < str.length() ; r++)
        {
            char c = str.charAt(r);
            if(hm.get(c)!=null)
            {
                if(hm.get(c)>=l) // to avoid moving the left backwards
                {
                    l  = hm.get(c)+1;
                }
            }
            res = Math.max(res, r-l+1);
            hm.put(c,r);
        }


        return res;

        
    }
    
    public static void main(String[] args) {
        // Test cases
        String[] testCases = {"abcabcbb", "bbbbb", "pwwkew", "", "dvdf"};
        
        for (String testCase : testCases) {
            int result = lengthOfLongestSubstring(testCase);
            System.out.println("Input: \"" + testCase + "\"");
            System.out.println("Output: " + result);
            System.out.println();
        }
    }
}
