public class candy {
    
    public static int candyDistribution(int[] ratings) {
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
        
        return totalCandies;
    }

    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println("Minimum candies needed: " + candyDistribution(ratings));
        
        int[] ratings2 = {1,2,2};
        System.out.println("Minimum candies needed: " + candyDistribution(ratings2));
    }
}
