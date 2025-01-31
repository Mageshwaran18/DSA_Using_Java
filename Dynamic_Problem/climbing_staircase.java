package Dynamic_Problem;


/* LeetCode :- 70 https://leetcode.com/problems/climbing-stairs/description/ */

/* It's similar to the fabonoci series if n = 1 ans = 2 , n = 2 ans = 2 ,
                         n = 3 ans = 3, n = 4 ans = 5, n = 5 ans = 8  
    If we went for tabulation method then ar[0] = 1 ar[1] = 1 , so that if arr[2] = arr[2-1] + arr[2-2] = 2                         
*/
public class climbing_staircase {

    public static int helper(int n,int []arr)
    {
        if(n<=1)
        {
            return 1;
        }
        arr[0]=1;
        arr[1]=1;
        for(int i = 2 ; i <= n ; i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    public static int climbStairs(int n) {
        
        int arr[] = new int[n+1];
        return helper(n,arr);
    }
    
    public static void main(String[] args) {
        int n = 5; // Example input
        int result = climbStairs(n);
        System.out.println("Number of ways to climb " + n + " stairs: " + result);
    }
}
