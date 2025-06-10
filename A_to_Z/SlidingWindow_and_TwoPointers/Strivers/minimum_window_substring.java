package SlidingWindow_and_TwoPointers.Strivers;

import java.util.HashMap;
import java.util.Map;

/* LeetCode :- 76 https://leetcode.com/problems/minimum-window-substring/description/ */

/*
 * Brute Force :-  --> Generate all the substrings possible and find the smallest substring which validates the condition. 
 *                 --> To check whether the two strings are equal use hashmap along with the character and it's frquencies 
 *                 --> T.C :- O( N^2 ) [ For generating the substring ]
 * 
 * Better Approach ( My Approach ):- --> Typical Sliding Window , Expand the window till you get the valid window. Once the window is valid shrink the window as much as possible 
 *                                   --> Use Two hashmap to check whether the window is valid or not valid [ One for the target string and Another hashmap for the window ]
 *                                   --> T.C :- O ( 2N ) for the window and ( 2N * S) [ S size of the target string ]
 *                                   --> T.C :- O( 2N + 2N*S )
 *                                   --> S.C :- O ( 2*S ) As i am using two hashmap 
 * 
 * Optimal Approach :- --> Can we reduce the the time complexity from O ( 2N + 2N * S) to O( 2N ) removing the extra work of checking the hashmap for all substrings ?
 *                     --> Can we use single hashmap to determine that the current substring is equal to the target string ?
 *                     --> Yes , that's the better way can reduce both the time and space complexity of the problem
 *                     --> Use Count variable which counts the number of letters matching in the target comparing to the current substring
 *                     --> Look the Count operation carefully 
 *                     --> T.C :- O ( 2N )
 *                     --> S.C :- O ( S ) [ S size of the target string ]
 */

public class minimum_window_substring {

    public static boolean valid(HashMap<Character,Integer> thm,HashMap<Character,Integer> shm)
    {
        for(Map.Entry<Character,Integer> entry : thm.entrySet())
        {
            char c = entry.getKey();
            if(shm.getOrDefault(c,0) < entry.getValue())
            {
                return false;
            }
        }
        return true;
    }

    public static String  better_approach(String s, String t) {

        int left = 0;
        boolean no_found = true;
        int index[] = {0,s.length()-1};
        HashMap<Character,Integer> thm = new HashMap<>();
        HashMap<Character,Integer> shm = new HashMap<>();
        for(char c : t.toCharArray())
        {
            thm.put(c,thm.getOrDefault(c,0)+1);
        }
        while(left<s.length())
        {
            char c = s.charAt(left);
            if(thm.get(c)!=null)
            {
                break;
            }
            left++;
        }
        for(int right = left ; right < s.length() ; right++)
        {
            char c = s.charAt(right);
            if(thm.get(c)!=null)
            {
                shm.put(c,shm.getOrDefault(c,0)+1);
            }
            while(valid(thm,shm))
            {
                no_found = false;
                if(index[1]-index[0]+1 > right-left+1)
                {
                    index[0] = left;
                    index[1] = right;
                }
                char temp = s.charAt(left);
                if(thm.get(temp)!=null)
                {
                    shm.put(temp,shm.get(temp)-1);
                }
                left++;
            }
        }

        if(no_found)
        {
            return "";
        }
        else
        {
            return s.substring(index[0],index[1]+1);
        }

    }

    public static String optimal_approach(String s, String t)
    {
        int left = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        int index[] = {0,s.length()-1};
        boolean is_found = false;
        int cnt = 0;

        for(char c : t.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        for(int right = 0 ; right < s.length() ; right++)
        {
            char c = s.charAt(right);
            if(hm.get(c)!=null)
            {
                if(hm.get(c)>0)
                {
                    cnt++;
                }
                hm.put(c,hm.get(c)-1);
               
            }   

            while(cnt==t.length())
            {
                is_found = true;
                if(index[1]-index[0]+1 > right - left + 1)
                {
                    index[0] = left;
                    index[1] = right;
                }

                char temp = s.charAt(left);

                if(hm.get(temp)!=null)
                {
                    hm.put(temp,hm.get(temp)+1);
                    if(hm.get(temp)>0)
                    {
                        cnt--;
                    }
                }
                left++;
            }
        }

        if(!is_found)
        {
            return "";
        }
        else
        {
            return s.substring(index[0],index[1]+1);
        }
    }

    public static void main(String args[])
    {
      String  s = "ENGINEERING";
      String  t = "EERI";
      System.out.println(better_approach(s,t));
      System.out.println(optimal_approach(s,t));
    }


    
}
