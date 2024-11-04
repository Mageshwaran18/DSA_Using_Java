package Greedy;


/* LeetCode : 135 https://leetcode.com/problems/candy/description/ */

/* Better Approach :- * Find the number of candies which statisfies the left neighbourhood 
                      * Find the number of candies which statisfies the right neighbourhood 
                      * The maximum of both left and the right neighbourhood is the required candies
                      * Time Complexity --> O(3n) , Space Complexity --> O(2n)
  
  Optimal Approach :- * Slope based approach 
                      * If it's inclining slope increase the count 
                      * If it's straight slope just add the 1
                      * If it's declining slope increase the count 
                      * Time Complexity --> O(n) , Space Complexity --> O(4) [ only the space for storing the variable is required ]

*/

public class candy {


    
  public static int candyDistribution(int[] ratings) {

      /*  
      int n = ratings.length;
      int[] leftToRight = new int[n];
      int[] rightToLeft = new int[n];
        
      // Initialize arrays with 1
      Arrays.fill(leftToRight, 1);
      Arrays.fill(rightToLeft, 1);
        
      // Left to right pass
      for(int i = 1; i < n; i++) {
          if(ratings[i] > ratings[i-1]) {
              leftToRight[i] = leftToRight[i-1] + 1;
          }
      }
        
      // Right to left pass
      for(int i = n-2; i >= 0; i--) {
          if(ratings[i] > ratings[i+1]) {
              rightToLeft[i] = rightToLeft[i+1] + 1;
          }
      }
        
      // Calculate final result
      int totalCandies = 0;
      for(int i = 0; i < n; i++) {
          totalCandies += Math.max(leftToRight[i], rightToLeft[i]);
      }
        
      */  
      int sum=1, i=1, n=ratings.length;
        while(i<n) {
            if(ratings[i]==ratings[i-1]) {
                sum+=1;
                i++;
                continue;
            }
            int peak=1;
            while(i<n && ratings[i]>ratings[i-1]) {
                peak++;
                sum+=peak;
                i++;
            }
            int down=0;
            while(i<n && ratings[i]<ratings[i-1]) {
                down++;
                sum+=down;
                i++;
            }
            down++;
            if(down>peak) sum+=(down-peak);
        }
        return sum;
  }

  public static void main(String[] args) {
      int[] ratings = {1,0,2};
      System.out.println("Minimum candies needed: " + candyDistribution(ratings));
        
      int[] ratings2 = {1,2,2};
      System.out.println("Minimum candies needed: " + candyDistribution(ratings2));
  }
}