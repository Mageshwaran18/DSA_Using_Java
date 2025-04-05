/* LeetCode :- 11 https://leetcode.com/problems/container-with-most-water/*/

/* Brute force :- * find all the possible rectangel and find the maximum area 
 *                * TC :- O(n^2)
 * 
 * Two pointers :- * Consider that i need to maximuze the area of the rectangle .
 *                 * So i kept left and right at the 0 and arr.length -1;
 *                 * Calculalte the area of the rectangel , compare with the previouse one 
 *                 * The move the pointer ( left / right ) who's height is low. 
 *                 * Repeat the process till left and right crosses each other 
*/

public class container_with_most_water {

    public static int maxArea_brute(int[] height) {
        int res = 0;
        
        for(int l = 0 ; l < height.length ; l++)
        {   
            for(int r = l + 1 ; r < height.length ; r++)
            {
                int area = (r-l) * Math.min(height[r],height[l]);
                res = Math.max(area,res);
            }
        }
        return res;
        
    }

    public static int maxArea_optimal(int []height)
    {
        int res = 0;
        int left = 0;
        int right = height.length-1;
        while(left<right)
        {
            int area = (right-left)*Math.min(height[left],height[right]);
            res = Math.max(res,area);
            if(height[left]>=height[right])
            {
                right--;
            }
            else
            {
                left++;
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        
        // Test brute force approach
        System.out.println("Maximum area (brute force): " + maxArea_brute(height));
        
        // Test optimal approach
        System.out.println("Maximum area (optimal): " + maxArea_optimal(height));
    }
}
