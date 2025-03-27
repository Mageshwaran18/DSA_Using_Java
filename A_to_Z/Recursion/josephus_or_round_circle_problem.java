package Recursion;
import java.util.*;


/*
 * LeetCode :- 1823 https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/
 * 
 * Hint :- -->Consider a arrow is pointing (rigid) and circle table is being rotated and once the table stops , the arrow pointed person in being removed
 *         -->O(n*k)
 * 
 *         --> Refer DSA notes
 */
public class josephus_or_round_circle_problem {

    public static int josephus_or_round_circle_problem(int n , int k)
    {

        Deque <Integer> ans = new ArrayDeque<>();
        for(int i = 1 ; i <= n; i++)
        {
            ans.addLast(i);
        }

        while(ans.size()>1)
        {
            for(int i = 0 ; i < k-1  ; i++)
            {
                int temp = ans.removeFirst();
                ans.addLast(temp);
            }

            ans.removeFirst();
        }

        return ans.removeFirst();
    }

    public static void main(String[] args) {
        int n = 6; // number of people
        int k = 5; // count to eliminate
        int winner = josephus_or_round_circle_problem(n, k);
        System.out.println("The winner is person number: " + winner);
    }


    
}
