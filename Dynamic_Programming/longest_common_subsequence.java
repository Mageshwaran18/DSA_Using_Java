package Dynamic_Programming;
import java.util.*;

/* LeetCode :- https://leetcode.com/problems/longest-common-subsequence/description/ */



public class longest_common_subsequence {
 
    public static int longestCommonSubsequence_with_extra_space(String text1, String text2) {

        int row = text1.length();
        int col = text2.length();
        int dp[][]  = new int[row+1][col+1];
        for(int i = 0 ; i < row+1 ; i++)
        {
            dp[i][0]=0;
        }
        for(int i = 0 ; i < col+1 ; i++)
        {
            dp[0][i]=0;
        }

        for(int i = 1 ; i < row+1 ; i++)
        {
            for(int j = 1 ;  j < col+1 ; j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return dp[row][col];
        
    }


    public int longestCommonSubsequence_without_extraspace_also_the_string(String text1, String text2) {

        int row = text1.length()+1;
        int col = text2.length()+1;

        int prev_dp[] = new int[col];
        int cur_dp[] = new int[col];

        String prev_str[] = new String[col];
        String cur_str[] = new String[col];

        for(int i = 0 ; i < col ; i++)
        {
            prev_str[i]="";
        }
        
        for(int i = 1 ; i < row ; i++)
        {
            for(int j = 1 ; j < col ; j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    cur_dp[j] = prev_dp[j-1] + 1;
                    cur_str[j] = prev_str[j-1] + text2.charAt(j-1);
                }
                else
                {
                    if(cur_dp[j-1] <= prev_dp[j])
                    {
                        cur_dp[j] = prev_dp[j];
                        cur_str[j] = prev_str[j];
                    }
                    else
                    {
                        cur_dp[j]=cur_dp[j-1];
                        cur_str[j]=cur_str[j-1];
                    }
                }
            }

            int temp_dp[] = prev_dp;
            prev_dp = cur_dp;
            cur_dp = temp_dp;

            String temp_str[] = prev_str;
            prev_str = cur_str;
            cur_str = temp_str;
        }

        System.out.println(prev_str[col-1]);
        return prev_dp[col-1];
    }

    public static void main(String[] args) {
        longest_common_subsequence lcs = new longest_common_subsequence();
        String text1 = "abcde";
        String text2 = "ace";
        
        System.out.println("Using extra space method:");
        System.out.println("Length of Longest Common Subsequence: " + 
                          longestCommonSubsequence_with_extra_space(text1, text2));
        
        System.out.println("\nUsing space optimized method:");
        System.out.print("Longest Common Subsequence: ");
        System.out.println("Length: " + 
                          lcs.longestCommonSubsequence_without_extraspace_also_the_string(text1, text2));
    }
}