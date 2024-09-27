package Sliding_Window;

import java.util.HashMap;

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
