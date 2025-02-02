package Array.Medium;

import java.util.*;

class ant_prob {
    public int ant_prob(int n, int[] left, int[] right) {
        int lastFallTime = 0;
        
        // Determine the farthest position reached by ants moving to the left.
        for (int leftPosition : left) {
            lastFallTime = Math.max(lastFallTime, leftPosition);
        }
        
        // Determine the farthest position reached by ants moving to the right,
        // considering they start from the right end of the plank (n - position).
        for (int rightPosition : right) {
            lastFallTime = Math.max(lastFallTime, n - rightPosition);
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