package Recursion;
import java.util.*;

/* LeetCode :- 17 https://leetcode.com/problems/letter-combinations-of-a-phone-number/ */ 

/* Optimal Approach :-  --> It's similar to  subsets_string problem 
 *                      --> Where we will add that at first and perform DFS , then the result will be added to the list 
 *                      --> Then we will be removing that and repeat the process !
 *                      --> It's look like [ we two option either you add or remove ].
 * 
 *                  T.C :- if a string with 2345 where all the numbers have 3 alphabets then the result array will have 81 which 3^4 ( where 4 is the length of the string )
 *                         if a string with 79 where all the numbers have 4 alphabets then the result array will have 16 which 4^2 ( where 2 is the length of the string )
 *                         if all the numbers belongs to 3 alphabets then it's TC is 3^n
 *                         if all the numbers belongs to 4 alphabets then it's TC is 4^n
 *                         
 *                         if the string is 73  then the result array will have 12 , if the string 737 then the result array will be 48
 *                         if the string is 7373 then the result array will have 144 , So from that we can find some pattern 
 *                         let the string 7373 can be also written in 77 33 [ applicable only for calculating the TC ] 
 *                         T.C for 77 -> 4^2 = 16
 *                         T.C for 33 -> 3^2 = 9
 *                         
 *                         At last the 16 strings will be multiplied into 9 strings .
 *                         
 *                         From this we can conclude that T.C would be O(3^n * 4^m) 
 *                         -> where n is the count of 3 valued number and m is the count of 4 valued number
 *                          
 * 
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
