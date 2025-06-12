package SlidingWindow_and_TwoPointers;
import java.util.*;


/*
 * LeetCode :- 1461 https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 */

  /* Brute force:
 * - Generate all the permutations of binary form of k 
 * - Generate all the substring of s with size k
 * - Check that all the permutations of k are in the substring generated from s
 * - If yes return true else return false
 * - T.C: O(2^K) + O(2^K * N) [for generating the permutations and checking both] 
 * - S.C: O(2^K) + O(n-k+1) [for generating the substrings]
 * 
 * Optimized Approach: [YOU]
 * - We will use sliding window technique to generate all the substrings of size k
 * - We will store all the substrings in a hashset
 * - If the size of hashset becomes equal to 2^k then we have found all the binary codes
 * - Return true else return false
 * - T.C: O(N) [for generating the substrings]
 * - S.C: O(2^k) [for storing the substrings in hashset]
 */

public class check_string_contains_all_binary_codes_of_k {
    
    
        public static boolean hasAllCodes(String s, int k) {

        if(s.length() < k)
        {
            return false;
        }
        double req = Math.pow(2,k);
        Set<String> st = new HashSet<>();
        StringBuilder str = new StringBuilder(s.substring(0,k));
        
        st.add(str.toString());
        int left = 0;
        for(int right = k ; right < s.length() ; right++)
        {
            str.deleteCharAt(left);
            str.append(s.charAt(right));
            st.add(str.toString());
            if(st.size()==req)
            {
                return true;
            }
        }

        return false;
    }

}
