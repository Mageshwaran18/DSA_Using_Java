package Bit_Manupulation;
import java.util.*;

/* Refer the DSA notes */
public class power_sets_print_all_subsequences {

    public static List<String> power_sets_print_all_subsequences(String str)
    {
        List<String> ans = new ArrayList<>();
        int n = str.length();
        for(int i = 0 ; i < 2*n-1 ;i++)
        {

            String temp = " ";
            for(int j = 0 ; j < n-1 ;j++)
            {
                if((i & (1 << j))!=0)
                {
                    temp = temp + str.charAt(j);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<String> ans = power_sets_print_all_subsequences(str);
        for(String temp : ans)
        {
            System.out.println(temp);
        }
    }
}
