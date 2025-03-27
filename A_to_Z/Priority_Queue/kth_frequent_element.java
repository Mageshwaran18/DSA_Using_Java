package Priority_Queue;
import java.util.*;

/* LeetCode :- 347 https://leetcode.com/problems/top-k-frequent-elements/description/ */

/* Just see the code it will be easy to understand  
 * Hint :- (1) Gather the frequency of the element using hashmap with key value pairs
 *         (2) Insert those key value pairs in priority queue ,  with descending order based on the values using the comparator 
 *         (3) Pop the k times and store those in a array 
*/
public class kth_frequent_element {

    public static void kth_frequent_element(int nums[],int k )
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i : nums)
        {
            if(hm.get(i)==null)
            {
                hm.put(i,0);
            }
            else
            {
                hm.put(i,hm.get(i)+1);
            }
        }

        PriorityQueue <Map.Entry<Integer,Integer>>pq = new PriorityQueue<>((a,b) -> b.getValue()-a.getValue());
        for(Map.Entry<Integer,Integer> entry: hm.entrySet())
        {
            pq.add(entry);
        }
        int ans[] = new int[k];
        for(int i = 0 ; i < k; i++)
        {
            Map.Entry<Integer,Integer> temp = pq.poll();
            ans[i]=temp.getKey();
        }

        for(int i : ans)
        {
            System.out.print(i+" ");
        }


    }

    public static void main(String[] args) {
        int[] nums = {5,5,6,6,7,7,7,8};
        int k = 3;
        kth_frequent_element(nums, k);
    }
    
}