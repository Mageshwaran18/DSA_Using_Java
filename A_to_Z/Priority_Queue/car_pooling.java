package Priority_Queue;
import java.util.*;

/* LeetCode :- 1094 https://leetcode.com/problems/car-pooling/description/ */

/* Refer DSA notes for the explanation
 * 
 * My Approach --> For mapping the values use hasmap and for arranging them in the time line and calculating the current_passanger use priority queue
 * 
 * Better Approach --> Using the priority queue for storing the key value pairs instead of hashmap 
 * 
 * Optimal Approach --> Using tree map 
 */

public class car_pooling {

    public boolean carPooling(int[][] trips, int capacity) 
    {

        /* My Approach */

        // HashMap<Integer,Integer> hm = new HashMap<>();
        // for(int i[] : trips)
        // {
        //     if(hm.get(i[1])!=null)
        //     {
        //         hm.put(i[1],hm.get(i[1])+i[0]);
        //     }
        //     else
        //     {
        //         hm.put(i[1],i[0]);
        //     }

        //     if(hm.get(i[2])!=null)
        //     {
        //         hm.put(i[2],hm.get(i[2])+i[0] * -1);
        //     }
        //     else
        //     {
        //         hm.put(i[2],i[0] * -1);
        //     }
        // }
        // PriorityQueue <Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> a.getKey()-b.getKey());
        // for(Map.Entry<Integer,Integer> entry: hm.entrySet())
        // {
        //     pq.add(entry);
        // }
        // int sum = 0;
        // while(pq.size()!=0)
        // {
        //     Map.Entry<Integer,Integer> entry = pq.poll();
        //     sum+=entry.getValue();
        //     if(sum>capacity)
        //     {
        //         return false;
        //     }
            
        //     System.out.println(entry.getKey() + " : " + entry.getValue() + " : " + sum);
        // }
        // return true;

        /* Better Approach */


        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        //     if (a[0] == b[0])
        //         return a[1] - b[1];
        //     return a[0] - b[0];
        // });

        // for(int i[]:trips)
        // {
        //     int from = i[1];
        //     int to = i[2];
        //     int no_passengers = i[0];

        //     pq.add(new int []{from,no_passengers});
        //     pq.add(new int []{to,-no_passengers});
        // }

        // int current_capacity = 0;
        // while(!pq.isEmpty())
        // {
        //     int temp[]=pq.poll();
        //     current_capacity+=temp[1];
        //     if(current_capacity > capacity)
        //     {
        //         return false;
        //     }
        // }
        // return true;


        /* Optimal Approach */

        
        TreeMap<Integer, Integer> timeline = new TreeMap<>();

        for(int[] trip : trips) {
            timeline.put(trip[1], timeline.getOrDefault(trip[1], 0) + trip[0]);
            timeline.put(trip[2], timeline.getOrDefault(trip[2], 0) - trip[0]);
        }

        int currentPassengers = 0;
        for(int passengers : timeline.values()) {
            currentPassengers += passengers;
            if(currentPassengers > capacity) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        car_pooling solution = new car_pooling();
        int[][] trips = {{2,2,6}, {2,4,7}, {3,3,9}};
        int capacity = 5;
        
        boolean result = solution.carPooling(trips, capacity);
        System.out.println("\nCan complete all trips: " + result);
    }    
}



