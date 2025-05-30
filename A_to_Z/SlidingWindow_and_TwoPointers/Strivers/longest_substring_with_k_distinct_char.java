package SlidingWindow_and_TwoPointers.Strivers;
import java.util.*;

/* GFG :- https://www.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1 */

/*
 * Brute Force approach :- --> Find all the possible substring and find the longest valid substring 
 *                         --> T.C :- O ( N^2 ) + O ( log N ) [ Generating all the substrings + Using of hashmap ]
 *                         --> S.C :- O ( k )  [ at most there can be k characters in the hashmap at the same time ]
 * 
 * Better Approach :- --> Using the sliding window concept and it's template 
 *                    --> Expand the window till the window contains the K unique characters [ use hashmap.size() to determine the unique characters peresent in the window ]
 *                    --> If the window is not valid , shrink the window using the Left variable. [ If the frequency of the character is zero then remove the character from the hashmap ]
 *                    --> Move the left till the window becomes valid 
 *                    --> T.C :- O ( N ) + O ( N ) + O ( log n ) [ right variable + left variable + hashmap ]
 *                    --> T.C :- O ( 2N ) + O ( log n )
 *                    --> S.C :- O ( K ) [ at most there can be k characters in the hashmap at the same time ]
 * 
 * Optimal Approach :- --> Can we avoid moving the left one by one ? can the better approach be trimed down to O ( N ) + O ( log n )
 *                     --> Use the template used for solving the previous problems 
 *                     --> Once the larger window size is calculate avoid shrinking the window size less than the max valid window size
 *                     --> Maintain the valid window size at the same level , but update only when the window is valid 
 *                     --> Hint :- Only the expansion is available , Shrinking is not valid , Update only when the window is valid 
 *                     --> T.C :- O ( N ) + O ( log n )
 *                     --> S.C :- O ( K ) [ at most there can be k characters in the hashmap at the same time ]
 */

class longest_substing_with_k_distinct_char
{

    public static int brute_force(String s , int k)
    {
        int ans = -1;
        for(int i = 0 ; i < s.length() ;i++)
        {
            HashMap<Character,Integer> hm = new HashMap<>();
            for(int j = i ; j < s.length(); j++)
            {
                char temp = s.charAt(j);
                hm.put(temp,hm.getOrDefault(temp,0)+1);
                if(hm.size()>k)
                {
                    break;
                }
                ans = Math.max(ans,j-i+1);
            }
        }

        return ans;
    }

    public static int better_approach(String s,int k)
    {
        int left = 0 ;
        int ans = -1;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int right = 0 ; right < s.length();right++)
        {
            char c = s.charAt(right);
            hm.put(c,hm.getOrDefault(c,0)+1);
            while(hm.size()>k)
            {
                char temp = s.charAt(left);
                hm.put(temp,hm.get(temp)-1);   
                if(hm.get(temp)==0)
                {
                    hm.remove(temp);
                }
                left++;
            }
            if(hm.size()==k)
            {
                ans=Math.max(ans,right-left+1);
            }
        }
        return ans;
    }

    public static int optimal_approach(String s , int k )
    {
        int ans = -1;
        int left = 0;
        HashMap<Character ,Integer> hm = new HashMap<>();
        for(int right = 0 ; right < s.length () ; right++)
        {
            char temp = s.charAt(right);
            hm.put(temp,hm.getOrDefault(temp,0)+1);
            if(hm.size()>k)
            {
                char c = s.charAt(left);
                hm.put(c,hm.get(c)-1);
                if(hm.get(c)==0)
                {
                    hm.remove(c);
                }
                left++;
            }
            if(hm.size()==k)
            {
                ans=Math.max(ans,right-left+1);
            }
        }

        return ans;
    }



    public static void main(String args[])
    {
        String str = "aabacbebebe";
        int k = 3;
        System.out.println("The size of the longest possible substring with exactly k unique characters :- " + brute_force(str,k));
        System.out.println("The size of the longest possible substring with exactly k unique characters :- " + better_approach(str,k));
        System.out.println("The size of the longest possible substring with exactly k unique characters :- " + optimal_approach(str,k));
    }
}