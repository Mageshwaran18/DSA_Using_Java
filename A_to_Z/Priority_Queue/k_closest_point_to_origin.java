package Priority_Queue;
import java.util.*;

/* LeetCode :- 973 https://leetcode.com/problems/k-closest-points-to-origin/description/ */
/* 
 * It's easy , I am implementing the hashmap using the priority queue , where the key is the distance and value is the index of the points in the main array.
 * Read the below commented lines for the code implementation and debugging.
 */
public class k_closest_point_to_origin {

    public int[][] kClosest(int[][] points, int k) {

        /* When comparing doubles, you need to use Double.compare() instead of subtraction. */
        PriorityQueue <double []> pq = new PriorityQueue<>((a,b) -> Double.compare(a[0],b[0]));
        int index = 0;
        for(int i[] : points)
        {
            int x = i[0];
            int y = i[1];
            /* The error is that Math.sqrt() returns a double */
            double distance = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            /* Store distance and index in priority queue */
            pq.add(new double[]{distance,index++});        }

        int ans[][] = new int[k][2];
        for(int i = 0 ;i< k ; i++)
        {
            double temp[] = pq.poll();  // Get the next closest point from priority queue by polling
            ans[i] = points[(int)temp[1]];  // temp[1] contains the original index, use it to get point from points array
        }
        return ans;
        
    }

    public static void main(String[] args) {
        k_closest_point_to_origin solution = new k_closest_point_to_origin();
        int[][] points = {{1,3},{-2,2},{5,-1}};
        int k = 2;
        int[][] result = solution.kClosest(points, k);
        System.out.println("K closest points to origin are:");
        for(int[] point : result) {
            System.out.println("(" + point[0] + "," + point[1] + ")");
        }
    }
    
}
