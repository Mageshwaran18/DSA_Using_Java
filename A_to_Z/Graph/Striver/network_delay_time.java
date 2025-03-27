package Graph.Striver;

/* LeetCode :- 743 https://leetcode.com/problems/network-delay-time/description/ */
/* 
 * It's easy just understand the question several times and you will get to know what to be stored in the place of dis
 * Once after storing the element into the dis understand what to return and when to return 
 * 
 * 
 * Time Complexity :- O (N Log N)
 * 
 */

import java.util.*;

public class network_delay_time {
    
    static class iPair{

        int node;
        int dis;

        iPair(int node , int dis)
        {
            this.node = node;
            this.dis = dis;
        }
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b)-> a.dis-b.dis);
        HashMap<Integer,ArrayList<int[]>>  adj = new HashMap<>();
        boolean visited[] = new boolean[n];
        int dis[] = new int[n];
        for(int i[] : times)
        {
            int temp[] = new int[2];
            temp[0] = i[1]-1;
            temp[1] = i[2];
            adj.computeIfAbsent(i[0]-1,j-> new ArrayList<>());
            adj.get(i[0]-1).add(temp);
        }
        pq.add(new iPair(k-1,0));
        Arrays.fill(dis,-1);
        dis[k-1]=0;
        while(!pq.isEmpty())
        {
            iPair pop = pq.poll();
            int pn = pop.node;
            int pdis = pop.dis;
            if(!visited[pn])
            {
                visited[pn]=true;
                if(adj.get(pn)!=null)
                {
                    for(int neigh[] : adj.get(pn))
                    {
                        int nn = neigh[0];
                        int ndis = neigh[1]+pdis;
                        if(!visited[nn])
                        {
                            if(dis[nn]==-1 || ndis < dis[nn])
                            {
                                dis[nn]=ndis;
                                pq.add(new iPair(nn,ndis));
                            }
                        }
                    }
                }
            }
        }
        int maxi = -1;
        for(int i : dis)
        {
            if(i==-1)
            {
                return -1;
            }
            else if(maxi<i)
            {
                maxi=i;
            }
        }

        return maxi;
    }


    public static void main(String[] args) {
        // Example usage
        int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
        int n = 4;
        int k = 2;
        
        int result = networkDelayTime(times, n, k);
        System.out.println("Minimum time for all nodes to receive signal: " + result);
        
        // Additional test case
        int[][] times2 = {{1,2,1},{2,3,2},{1,3,4}};
        n = 3;
        k = 1;
        
        result = networkDelayTime(times2, n, k);
        System.out.println("Minimum time for all nodes to receive signal: " + result);
    }


}
