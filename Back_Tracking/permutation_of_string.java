package Back_Tracking;
import java.util.*;

class permutation_of_string
{

    public static List<String> res = new ArrayList<>();
    
    public static void permutation(String str , String per)
    {
        if(str.length()==0)
        {
            res.add(per);
            return;
        }
        for(int i = 0 ; i < str.length() ; i++)
        {
            char c = str.charAt(i);
            // System.out.println(c);
            String new_per =  per + c;
            String new_str = str.substring(0,i) + str.substring(i+1);
            permutation(new_str,new_per);
        }
        return;
    }

    public static List<String> helper(String str)
    {
        permutation(str,"");
        return res;
    }

    public static void main(String args[])
    {
        String str = "abc";
        List<String> ans = helper(str);
        System.out.println("Permutation for the string :- ");
        int cnt = 0;
        for(String temp: ans )
        {   
            cnt++;
            System.out.println(temp);
        }
        System.out.println("\n" + "Number of permuation :- " +  cnt);
    }



    



}