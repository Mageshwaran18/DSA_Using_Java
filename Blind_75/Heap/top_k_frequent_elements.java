 import java.util.*;


/* LeetCode :- 347 https://leetcode.com/problems/top-k-frequent-elements/ */

/* 
 * Approach 1 :- Using hashmap + priority queue ( heap ) 
 *               TC :- --> O( n ( hashmap ) + n ( inserting into q ) + k ( poping ) log n (internal sorting after poping) )
 *                     --> O( n + n + k log n ) ~ O( n log n) ( sometimes k can be n)
 * 
 *               SC :- --> O( n ( hashmap ) + n ( q ) ) ~ O(n)
 *                     
 * Approach 2 :- Using hashmap + extra array 
 *               TC :- --> O( n ( hashmap ) + n ( creating lists ) + O ( adding the elements to the array ) + O ( retriving from back ))
 *                     --> O( n + n + n + k ( sometimes n )) ~ O ( n )
 *               
 *               SC :- --> O( n ( hashmap ) + n+1 ( for array )) ~ O( n )
 * 
 * 
*/


public class top_k_frequent_elements {

    public int[] approach_2(int[] nums, int k) {
        HashMap<Integer,Integer> tm = new HashMap<>();
        int res[] = new int[k];
        int ind=0;
        for(int i : nums)
        {
            tm.put(i,tm.getOrDefault(i,0)+1);
        }
        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0 ; i <= nums.length ; i++)
        {
            arr.add(new ArrayList<>());
        }
        for(Map.Entry<Integer,Integer> entry : tm.entrySet())
        {
            arr.get(entry.getValue()).add(entry.getKey());
        }

        for(int i = nums.length ; i>=0 ; i--)
        {
            for(int j : arr.get(i))
            {
                res[ind++]=j;
                if(ind==k)
                {
                    return res;
                }
            }
        }

        return new int[0];
    }

    public int[] approach_1(int[] nums, int k) {

        HashMap<Integer,Integer> hm = new HashMap<>();
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->(b.getValue()-a.getValue()));
        int ans[] = new int[k];
        for(int i : nums)
        {
            hm.put(i,hm.getOrDefault(i,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry : hm.entrySet())
        {
            pq.add(entry);
        }
        for(int i = 0 ; i < k ; i++)
        {
            Map.Entry<Integer,Integer> pop = pq.poll();
            System.out.println(pop.getKey() + " : " + pop.getValue());
            ans[i]=pop.getKey();
        }
        return ans;
    }

    public static void main(String[] args) {
        top_k_frequent_elements solution = new top_k_frequent_elements();
        
        // Test case 1
        int[] nums1 = {1,1,1,2,2,3};
        int k1 = 2;
        System.out.println("Test Case 1:");
        System.out.println("Approach 1 result:");
        int[] result1 = solution.approach_1(nums1, k1);
        for(int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println("\nApproach 2 result:");
        result1 = solution.approach_2(nums1, k1);
        for(int num : result1) {
            System.out.print(num + " ");
        }
        // Test case 2
        int[] nums2 = {1};
        int k2 = 1;
        System.out.println("\n\nTest Case 2:");
        System.out.println("Approach 1 result:");
        int[] result2 = solution.approach_1(nums2, k2);
        for(int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println("\nApproach 2 result:");
        result2 = solution.approach_2(nums2, k2);
        for(int num : result2) {
            System.out.print(num + " ");
        }
    }
}
