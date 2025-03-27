package Permutation_Combination;

/* LeetCode No:- 3309 */

/*
 * Note that you can't perform changing of the binary representation ex :- [3,4] you can write as [3,4] = [11100] or [4,3] = [10011] but you can write [11100] 
 * The number of inputs in the given question is only 3 then we can go for the brutforce appraoch finding all the combination for the given number and finding the greatest among them.
 * 
 * Brute Force --> (1) Create a function which converts the given integer into the binary representation string using String BUilder 
 *             --> (2) Create an array of string where the binary representation of the numbers were stored 
 *             --> (3) Note that a number can't be repeated . So try the combination like ABC , BCA , BAC .... 
 *             --> (4) For every new combination created check the decimal value of it's with the max variable ( Create a function which converts the string into decimal )
 */

public class maximum_possible_number {

    public String int_to_binary(int i )
    {
        StringBuilder sb = new StringBuilder();
        if(i==0)
        {
            return "0";
        }
        while(i!=0)
        {
            int res = i % 2;
            sb.append(res);
            i = i / 2 ;
        }
        return sb.reverse().toString();
    }
    
    public int String_to_Decimal(String s)
    {
        int res = 0 ; 
        int base = 1;
        for(int i = s.length()-1 ; i >= 0 ; i--)
        {
            if(s.charAt(i)=='1')
            {
                res += base;
            }
            base *=2;
        }
        return res;
    }
    
    public int maxGoodNumber(int[] nums) {
        
        String[] str = new String[3];
        for(int i = 0 ; i < 3 ; i++)
        {
            str[i] = int_to_binary(nums[i]);
        }
        int max  = Integer.MIN_VALUE;
        for(int i = 0 ; i < 3 ; i++)
        {
            for(int j = 0 ; j < 3 ; j++)
            {
                if(j!=i)
                {
                    for(int k = 0 ; k < 3 ; k++)
                    {
                        if(k!=j &&  k!=i)
                        {
                            StringBuilder s = new StringBuilder();
                            s.append(str[i]);
                            s.append(str[j]);
                            s.append(str[k]);
                            if(String_to_Decimal(s.toString())> max)
                            {
                                max = String_to_Decimal(s.toString());
                            }
                        }
                    }
                }
            }
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        maximum_possible_number mpn = new maximum_possible_number();
        int[] nums = {2, 8, 16};
        int result = mpn.maxGoodNumber(nums);
        System.out.println("The maximum possible number is: " + result);
    }
}
