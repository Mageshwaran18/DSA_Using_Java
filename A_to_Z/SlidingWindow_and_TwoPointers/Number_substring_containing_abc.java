package SlidingWindow_and_TwoPointers;

public class Number_substring_containing_abc {
    

/*Leetcode no :- 1358 */

/*
 * Brute Force with Sliding window & Hashing --> If a substring contains all the abc atleast once then the following subsets of the substring will also contains the abc , then we don't explictly check them 
 *                                           --> In window if abc is found then in the string abcabc , the following substrings of the abc will also have the abc , ex: abc , abca , abcab , abcabc 
 *                                           --> This can be found using the 1 ( current substring ) + [s.length()(end index) - i (the start index) -1] ( The number of remaining elements in the string)
 *                                           --> Use hashtable t define whether the window contains atleast single a , b , c 
 *                                           --> Refer the code it's very easy to understand
 */

    public static void main(String[] args) {

        String str = "abcabc";
        int a = 0;
        int b = 0;
        int c = 0;
        int count = 0;
        int left =0;
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(i)=='a')
            {
                a+=1;
            }
            else if (str.charAt(i)=='b')
            {
                b+=1;
            }
            else if (str.charAt(i)=='c')
            {
                c+=1;
            }
            while (a>=1 && b>=1 && c>=1)
            {
                count+=1+(str.length()-i-1);
                if(str.charAt(left)=='a')
                {
                    a-=1;
                }
                else if (str.charAt(left)=='b')
                {
                    b-=1;
                }
                else if (str.charAt(left)=='c')
                {
                    c-=1;
                }
                left++;
            }
        }
        System.out.println(count);
        

    }

}
