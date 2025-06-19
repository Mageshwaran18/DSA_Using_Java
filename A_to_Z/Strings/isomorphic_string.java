package Strings;
import java.util.*;

/* NOT YOU */
/* LeetCode :- 205 https://leetcode.com/problems/isomorphic-strings/description/ */

/*
 * Better Approach [NOT YOU] :- --> If s and t need to be isomorphic , then t should also be isomorphic to s and s should also be isomorphic to t.
 *                     --> If a is mapped to b , then  a cannot be mapped to any other letter.
 *                     --> So , how can we do that ?
 *                     --> Have a linear traverse , mapped every char of s to char of t [s=foo,t=dar]
 *                     --> f -> d , o -> a , But in the index 2 o is already mapped to a , we can't map that o again to r , hence false.
 *                     --> So we do s_to_t.get(sch)!=null && s_to_t.get(sch)!=tch 
 *                     --> [ check whether the key is already present , if yes check whether the previous value maps to the current value if not return false ]
 *                     --> We use a hashmap for that. But using one hashmap will fail in certain cases.
 *                     --> s = "badc" , t = "baba"
 *              
 *                     --> b-> b , a -> a , now when it comes index 2 d is not present in the hashmap , hence it's a new pair
 *                     --> Now , d->b but it's a fault because the b is already mapped to b , this procedure is not crt.
 *                     --> So , we two use two hashmap , which stores , f->d in hm1 then d->f in hm2 , o->a then a -> o etc..
 *                     --> Now , b->b then in h2 b->b , a->a then in hm2 a->a , now d is not present in hm1 
 *                     --> Before mapping d -> b , i would check that whether in hm2 the b is mapped to anyother alphabet ? yes b is mapped to b 
 *                     --> Then it's not isomorphic return false.
 *                      
 *                     --> T.C :- O( n ) --> n is the length of the string.
 *                     --> S.C :- O( 2n ) --> 2 hashmaps were used.
 *                   
 * Optimal Approach [NOT YOU]:- --> Can we reduce the S.C from 2n to n ?
 *                     --> Why we are using the 2nd hashmap ? when the d comes , it's not already present in the hasmap but the b is already get's mapped , and we need to check that
 *                     --> We need to make sure two things :-
 *                              --> A alphabet can't match to two  alphabets [ which means a should not be mapped to c , if a is already mapped to b ]
 *                              --> if a is not already mapped , before mapping b to a , we should make sure that b is not mapped to any alphabets as a key
 *                     --> s = "badc" , t = "baba" 
 *                     --> b-> b , a -> a , d is not mapped to anything , but b is present as value in hashmap already which means b is mapped to another variable prior.
 *                     --> See the code or refer https://leetcode.com/problems/isomorphic-strings/solutions/6743940/video-keep-pairs-in-hashmap-2-solutions-bonus-idea/ [one hashmap]
 *                     --> T.C :- O( n )
 *                     --> S.C :- O( n )
 * 
 *                           
 *                  
 */

class isomorphic_string{

    public static boolean better_approach(String s,String t)
    {
        HashMap<Character,Character> sourceToTarget = new HashMap<>();
        HashMap<Character,Character> targetToSource = new HashMap<>(); 
        for(int i = 0 ; i < s.length() ; i++)
        {
            char sourceChar = s.charAt(i);
            char targetChar = t.charAt(i);
            if((sourceToTarget.get(sourceChar)!=null && sourceToTarget.get(sourceChar)!=targetChar) || (targetToSource.get(targetChar)!=null && targetToSource.get(targetChar)!=sourceChar))
            {
                return false;
            }
            else
            {
                sourceToTarget.put(sourceChar,targetChar);
                targetToSource.put(targetChar,sourceChar);
            }
        }

        return true;    
    }

    public static boolean optimal_approach(String s,String t)
    {
        HashMap<Character,Character> sourceToTarget = new HashMap<>();
        for(int i = 0 ; i  < s.length() ; i++)
        {
            char sourceChar = s.charAt(i);
            char targetChar = t.charAt(i);

            // If the key is mapped already make sure that current target is it's value.
            if(sourceToTarget.containsKey(sourceChar) && sourceToTarget.get(sourceChar)!=targetChar)
            {
                return false;
            }

            // If the key is not present , make sure that value is not paired to any key prior.
            else if(sourceToTarget.get(sourceChar)==null && sourceToTarget.containsValue(targetChar))
            {
                return false;
            }
            else
            {
                sourceToTarget.put(sourceChar,targetChar);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = "baba";
        
        String t = "baba";
            
        System.out.println("\nResults:");
        System.out.println("Better Approach: " + better_approach(s, t));
        System.out.println("Optimal Approach: " + optimal_approach(s, t));
        
        scanner.close();
    }
}