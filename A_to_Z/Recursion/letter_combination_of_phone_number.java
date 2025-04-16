package Recursion;
import java.util.*;

/* LeetCode :- 17 https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */ 

/* Optimal Approach :-  --> It's similar to  subsets_string problem 
 *                      --> Where we will add that at first and perform DFS , then the result will be added to the list 
 *                      --> Then we will be removing that and repeat the process !
 *                      --> It's look like [ we two option either you add or remove ].
*/

public class letter_combination_of_phone_number {

    public static void fun(StringBuilder str , int index , String digits , Map<Character,String> map,List<String> ans)
    {
        if(index==digits.length())
        {
            ans.add(str.toString());
            return;
        }
        String alph = map.get(digits.charAt(index));
        for(char c : alph.toCharArray())
        {
            str.append(c);
            fun(str,index+1,digits,map,ans);
            str.deleteCharAt(str.length()-1);

        }


    }
    public static List<String> letterCombinations(String digits) {

        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        Map<Character,String> map = Map.of('2', "abc", '3', "def", '4', "ghi", '5', "jkl",
        '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz");
        if(digits.length()==0)
        {
            return ans;
        }
        fun(str,0,digits,map,ans);
        return ans;
    }
    
    public static void main(String[] args) {
        String digits = "23";
        List<String> combinations = letterCombinations(digits);
        System.out.println("Letter combinations for " + digits + ": " + combinations);
        
        digits = "234";
        combinations = letterCombinations(digits);
        System.out.println("Letter combinations for " + digits + ": " + combinations);
        
        digits = "";
        combinations = letterCombinations(digits);
        System.out.println("Letter combinations for empty string: " + combinations);
    }
}
