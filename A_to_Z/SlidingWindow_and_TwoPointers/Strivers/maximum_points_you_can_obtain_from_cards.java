package SlidingWindow_and_TwoPointers.Strivers;

/* LeetCode :- 1423 https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/ */

/* Brute Force Approach :- --> It's the best approach , just think what you want to do and what you need
 *                         --> [1,2,3,4,5,6,1] --> the possible subarrays can be (if k = 4)
 *                                                 [1,2,3,4] , [1,2,3,1] , [1,2,6,1] , [1,5,6,1] , [4,5,6,1]
 *                         --> So from the above possible it's easy to find the sum with maximum.
 *                         --> Hint :- Left Side + Right Side , Start from left [ full ] and right [ empty ]
 *                         --> Add one number at one end then decrease at one end 
 *                         --> Refer the DSA notes.
 *                         --> T.C :- O( 2K ) --> K for left sum + K for other sum [ add at one end and decrease at one end ]
 *                         --> S.C :- O( 1 )
 */

public class maximum_points_you_can_obtain_from_cards {


    public static int maxScore(int[] cardPoints, int k) {
        int ls = 0;
        int rs = 0;
        int n = cardPoints.length;
        int ans = 0;
        for(int i = 0 ; i < k ; i++)
        {
            ls+=cardPoints[i];
        }
        ans = ls;
        for(int i = 1 ; i <= k ; i++)
        {
            ls -= cardPoints[k-i];
            rs += cardPoints[n-i];
            ans = Math.max(ans,ls+rs);
        }
        return ans;
    }

    public static void main(String args[])
    {
        int [] cardPoints = {1,2,3,4,5,6,1};
        int k = 3;
        System.out.println("Maximum score you can obtain is " + maxScore(cardPoints,k));
    }
    
}
