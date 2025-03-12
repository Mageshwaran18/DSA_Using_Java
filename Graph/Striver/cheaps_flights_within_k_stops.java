package Graph.Striver;
import java.util.*;

/* LeetCode :- 787 https://leetcode.com/problems/cheapest-flights-within-k-stops/ */

/* Refer the DSA notes */

class cheaps_flights_within_k_stops
{
    static class iPair
    {
        int node;
        int dis;
        int steps;

        iPair(int node,int dis,int steps)
        {
            this.node = node;
            this.dis = dis;
            this.steps = steps;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int ans = -1;
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b)->a.steps-b.steps);
        int dis[] = new int[n];
        Arrays.fill(dis,-1);
        HashMap<Integer,ArrayList<int[]>> adj = new HashMap<>();
        for(int []i : flights)
        {
            adj.computeIfAbsent(i[0],j-> new ArrayList<>());
            int temp[] = new int[2];
            temp[0] = i[1];
            temp[1] = i[2];
            adj.get(i[0]).add(temp);
        }
        pq.add(new iPair(src,0,0));
        dis[src]=0;
        while(!pq.isEmpty())
        {
            iPair poll = pq.poll();
            int pn = poll.node;
            int pdis = poll.dis;
            int psteps = poll.steps;
            if(adj.get(pn)!=null)
            {
                for(int []j : adj.get(pn))
                {
                    int nn = j[0];
                    int ndis = pdis +  j[1];
                    int nsteps = psteps + 1;
                    if(nsteps <= k+1)
                    {
                        if(dis[nn]==-1 || dis[nn] >= ndis)
                        {
                            dis[nn]=ndis;
                            pq.add(new iPair(nn,ndis,nsteps));
                        }
                    }
                }
            }
        }
        return dis[dst];   
    }
}