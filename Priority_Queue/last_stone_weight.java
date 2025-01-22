package Priority_Queue;
import java.util.*;

/* LeetCode :- 1046 https://leetcode.com/problems/last-stone-weight/description/ */

/* It's too easy , just you need to understand the Priority Queue and you should approach the problem in that way */

public class last_stone_weight {
    
    public int lastStoneWeight(int[] stones) {
    
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        for(int i : stones)
        {
            pq.add(i);
        }
        while(pq.size()>1)
        {
            int first = pq.poll();
            int second = pq.poll();
            if(first!=second)
            {
                pq.add(first-second);
            }


        }
        if (!pq.isEmpty()) return pq.poll(); return 0;    
    }

    public static void main(String[] args) {
        last_stone_weight solution = new last_stone_weight();
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println("Last stone weight: " + solution.lastStoneWeight(stones));
    }
}
