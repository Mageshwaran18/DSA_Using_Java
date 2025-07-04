package SlidingWindow_and_TwoPointers;

public class Number_substring_containing_abc {
    
    /*Leetcode no :- 1358 */

    /*
     * My Approach            -->Brute Force with Sliding window & Hashing 
     *                        --> If a substring contains all the abc atleast once then the following subsets of the substring will also contains the abc , then we don't explictly check them 
     *                        --> In window if abc is found then in the string abcabc , the following substrings of the abc will also have the abc , ex: abc , abca , abcab , abcabc 
     *                        --> (1) This can be found using the 1 ( current substring ) + [s.length()(end index) - i (the start index) -1] ( The number of remaining elements in the string)
     *                        --> Use hashtable t define whether the window contains atleast single a , b , c 
     *                        --> Refer the code it's very easy to understand
     *                        --> T.C :- O ( 2N )
     *                        --> S.C :- O ( 1 )
     * 
     * Optimal Approach       --> Consider the index of the element as the last character of the valid string [ string with a,b,c]
     *                        --> For each character find the minimum length window that could be possible from the current characte [ only in the backward ]
     *                        --> Now if the minimum length is found then use ( 1 ) from my approach 
     *                        --> T.C :- O ( N )
     *                        --> S.C :- O ( 1 )
     */

    public static int my_approach(String str) {
        int a = 0;
        int b = 0;
        int c = 0;
        int count = 0;
        int left = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'a') {
                a += 1;
            }
            else if(str.charAt(i) == 'b') {
                b += 1;
            }
            else if(str.charAt(i) == 'c') {
                c += 1;
            }
            while(a >= 1 && b >= 1 && c >= 1) {
                count += 1 + (str.length() - i - 1);
                if(str.charAt(left) == 'a') {
                    a -= 1;
                }
                else if(str.charAt(left) == 'b') {
                    b -= 1;
                }
                else if(str.charAt(left) == 'c') {
                    c -= 1;
                }
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abcabc";
        int count = my_approach(str);
        System.out.println(count);
        count = optimal_approach(str);
        System.out.println(count);
    }

    public static int find_min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }

    public static int optimal_approach(String s) {
        int hash[] = {-1, -1, -1};
        int cnt = 0;
        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            hash[temp - 'a'] = i;
            if(find_min(hash) != -1) {
                int start = find_min(hash);
                cnt = cnt + 1 + start;
            }
        }
        return cnt;
    }
}