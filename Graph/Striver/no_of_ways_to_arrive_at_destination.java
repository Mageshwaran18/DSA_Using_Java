package Graph.Striver;
import java.util.*;

class no_of_Ways_to_arrive_at_destination
{
    static class iPair
    {
        int node ; 
        long dis ;

        iPair(int node,long dis)
        {
            this.node = node;
            this.dis = dis;
        }
    }
    static final int MOD = 1_000_000_007; 

    public int countPaths(int n, int[][] roads) {
        HashMap<Integer,ArrayList<int[]>> adj = new HashMap<>();
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b) -> Long.compare(a.dis,b.dis));
        long []dis = new long[n];
        int []ways = new int[n];
        boolean []visited = new boolean[n];
        int count = 0;
        for(int i[] : roads)
        {
            adj.computeIfAbsent(i[0],k-> new ArrayList<>());
            adj.computeIfAbsent(i[1],k-> new ArrayList<>());
            adj.get(i[0]).add(new int[]{i[1],i[2]});
            adj.get(i[1]).add(new int[]{i[0],i[2]});
        }
        pq.add(new iPair(0,0));
        Arrays.fill(dis,-1L);
        Arrays.fill(ways,0);
        ways[0]=1;
        dis[0]=0;
        while(!pq.isEmpty())
        {
            iPair poll = pq.poll();
            int pn = poll.node;
            long pdis = poll.dis;
            if(!visited[pn])
            {
                visited[pn]=true;
                for(int neigh[] : adj.getOrDefault(pn,new ArrayList<>())) 
                {
                        int nn = neigh[0];
                        long ndis = (long)(neigh[1] + pdis); 
                        if(dis[nn] == -1 || ndis < dis[nn]) {
                            dis[nn] = ndis;
                            pq.add(new iPair(nn, ndis));
                            ways[nn] = ways[pn] % MOD; 
                        } else if(ndis == dis[nn]) {
                            ways[nn] = (ways[nn] + ways[pn]) % MOD; 
                        }
                }
            }
        }
        System.out.println(Arrays.toString(dis));
        System.out.println(Arrays.toString(ways));
        return (ways[n-1]%MOD);
    }

    public static void main(String[] args) {
        no_of_Ways_to_arrive_at_destination solution = new no_of_Ways_to_arrive_at_destination();
        
        // Example test case
        int n = 7;
        int[][] roads = {
            {0,6,7},
            {0,1,2},
            {1,2,3},
            {1,3,3},
            {6,3,3},
            {3,5,1},
            {6,5,1},
            {2,5,1},
            {0,4,5},
            {4,6,2}
        };

        int result = solution.countPaths(n, roads);
        System.out.println("Number of ways to reach destination: " + result);
    }
}