package Graph.Striver;

import java.util.*;


/* Required format for the dijikstra to be applied [ [[node1,weight1],[node2,weight2]] --> 0 , [[node3,weight3],[node4,weight4]]--> 1 ] 
*  0---> the node and it's weight attached to the node 0 
*  1---> the node and it's weight attached to the node 1
*/

class iPair {
    int first, second;

    iPair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class dijktras {

    ArrayList<Integer> dijkstra_using_priority_queue(ArrayList<ArrayList<iPair>> adj, int src) {
        
        int n = adj.size();
        PriorityQueue<iPair> q = new PriorityQueue<>((a,b)->a.second-b.second);
        boolean []visited = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ;i++)
        {
            ans.add(-1);
        }
        
        // adding the source to the queue
        q.add(new iPair(src,0));
        // seting the weight of visiting the soruce as 0
        ans.set(src,0);
        
        
        while(!q.isEmpty())
        {
            iPair temp = q.poll();
            int cur = temp.first;
            int cur_we = temp.second;
            visited[cur]=true;
            for(iPair neigh :  adj.get(cur))
            {
                int ne = neigh.first;
                int ne_we = neigh.second;
                if(!visited[ne])
                {
                    int total = cur_we+ne_we;
                    if(ans.get(ne)==-1 || total < ans.get(ne))
                    {
                        ans.set(ne,total);
                        q.add(new iPair(ne,total));
                    }
                }
            }
        }
        
        return ans;
        
    }
    
    ArrayList<Integer> dijkstra_without_visited(ArrayList<ArrayList<iPair>> adj, int src) {
        
        int n = adj.size();
        Queue<iPair> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < n ;i++)
        {
            ans.add(-1);
        }
        
        // adding the source to the queue
        q.add(new iPair(src,0));
        // seting the weight of visiting the soruce as 0
        ans.set(src,0);
        
        while(!q.isEmpty())
        {
            iPair temp = q.poll();
            int cur = temp.first;
            int cur_we = temp.second;
            for(iPair neigh :  adj.get(cur))
            {
                int ne = neigh.first;
                int ne_we = neigh.second;
                int total = cur_we+ne_we;
                if(ans.get(ne)==-1 || total < ans.get(ne))
                {
                    ans.set(ne,total);
                    q.add(new iPair(ne,total));
                }
            }
        }
        return ans;       
    }

    public static void main(String[] args) {
        // Create a sample graph
        ArrayList<ArrayList<iPair>> adj = new ArrayList<>();
        int V = 5; // number of vertices
        
        // Initialize adjacency list
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges to the graph (vertex, weight)
        adj.get(0).add(new iPair(1, 2));
        adj.get(0).add(new iPair(3, 6));
        adj.get(1).add(new iPair(2, 3));
        adj.get(1).add(new iPair(3, 8));
        adj.get(1).add(new iPair(4, 5));
        adj.get(2).add(new iPair(4, 7));
        adj.get(3).add(new iPair(4, 9));
        
        dijktras obj = new dijktras();
        
        // Test both implementations
        System.out.println("Using Priority Queue:");
        ArrayList<Integer> result1 = obj.dijkstra_using_priority_queue(adj, 0);
        for(int i = 0; i < V; i++) {
            System.out.println("Shortest distance from source to vertex " + i + " is " + result1.get(i));
        }
        
        System.out.println("\nWithout Visited Array:");
        ArrayList<Integer> result2 = obj.dijkstra_without_visited(adj, 0);
        for(int i = 0; i < V; i++) {
            System.out.println("Shortest distance from source to vertex " + i + " is " + result2.get(i));
        }
    }
}
