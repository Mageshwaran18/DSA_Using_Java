package Array.Strivers.Medium;

/* LeetCode :- 1503 https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/description/
 * 
 * For solution description https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/solutions/4246597/100-easy-iterative-approach-explained-intuition/
 * 
 * Hint :- Even the ants collide that will not going to affect the time taken 
*/

import java.util.*;

class ant_prob {
    public int ant_prob(int n, int[] left, int[] right) {
        int lastFallTime = 0;
        
        // left holds the larger values , the end values.So greater the number the more further it's.
        for (int leftPosition : left) {
            lastFallTime = Math.max(lastFallTime, leftPosition);
        }
        

        // right holds the smaller values , the start values. So smaller the number the more further it's.
        // Determine the farthest position reached by ants moving to the right,
        // considering they start from the right end of the plank (n - position).
        for (int rightPosition : right) {
            lastFallTime = Math.max(lastFallTime, n - rightPosition);
            // if right is 0 , then the time taken is n - 0 , where n is the total length in the plank
        }
        
        return lastFallTime;
    }

    public static void main(String[] args) {
        ant_prob solution = new ant_prob();
        
        // Example test case
        int n = 4;  // length of plank
        int[] left = {4, 3};  // ants moving left
        int[] right = {0, 1};  // ants moving right
        
        int result = solution.ant_prob(n, left, right);
        System.out.println("Last ant falls at time: " + result);
    }
}