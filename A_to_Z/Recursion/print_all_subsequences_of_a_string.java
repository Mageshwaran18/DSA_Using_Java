package Recursion;
import java.util.*;

class print_all_subsequences_of_a_string
{

    static StringBuilder sub = new StringBuilder();
    static List<String> res = new ArrayList<>();


    public static void fun(String s,int i)
    {
        if(i==s.length())
        {
            if(sub.length()!=0)
            {
                res.add(new String(sub.toString()));
            }
            return;
        }
        sub.append(s.charAt(i));
        fun(s,i+1);
        sub.setLength(sub.length()-1);

        /*
         * setLength() is a StringBuilder method that adjusts the length of the character sequence. 
         * When we call setLength(sub.length() - 1),it effectively removes the last character from the StringBuilder by truncating its length by 1.
         */

        fun(s,i+1);
    }

    public static List<String> print_all_subsequences_of_a_string(String s)
    {
        res.clear();
        sub.setLength(0);
        fun(s, 0);
        return res;
    }

    public static void main(String[] args) {
        String s = "abc";
        List<String> subsequences = print_all_subsequences_of_a_string(s);
        System.out.println("All subsequences of " + s + ":");
        for (String subsequence : subsequences) {
            System.out.print(subsequence + " ");
        }
    }
}