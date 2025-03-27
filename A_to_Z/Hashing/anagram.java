package Hashing;
import java.util.*;

/* Leetcode No: 242 */

/*
 * Check whether the two strings have the same length. If not, they're not anagrams.
 * 
 * Brute force approach (Space complexity increases):
 * Create a HashMap for each string and compare both the keys and values of both HashMaps.
 * 
 * Optimal approach (Space complexity decreases):
 * Create a single HashMap. Traverse through the first string and add the characters as keys,
 * incrementing their count as values. Then traverse through the second string:
 * - If a character is not found in the HashMap, return false.
 * - If found, decrease its count.
 * Finally, check if all values in the HashMap are zero.
 */
public class anagram {

    public static void anagram(String s1 , int l1 , String s2 , int l2)
    {
        HashMap <Character,Integer>  hm1 = new HashMap<>();
        if(l1!=l2)
        {
            System.out.println("The length of the two strings are not same. So the strings are not anagram");
        }
        for(int i = 0 ; i < l1 ; i++)
        {
            if(hm1.get(s1.charAt(i))==null)
            {
                hm1.put(s1.charAt(i),1);
            }
            else
            {
                hm1.put(s1.charAt(i),hm1.get(s1.charAt(i))+1);
            }
        }

        for(int i = 0 ; i < l2 ; i++)
        {
            if(hm1.get(s2.charAt(i))==null)
            {
                System.out.println("The two strings are not an Anagram");
            }
            else
            {
                hm1.put(s2.charAt(i),hm1.get(s2.charAt(i))-1);
            }
        }
        for(int i = 0 ; i < l2 ; i++)
        {
            if(hm1.get(s2.charAt(i))!=0)
            {
                System.out.println("The two strings are not an Anagram");
            } 
        }
        System.out.println("The two strings are Anagram");
    }
     
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();
        
        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();
        
        anagram(str1, str1.length(), str2, str2.length());
        
        scanner.close();
    }
    
}
