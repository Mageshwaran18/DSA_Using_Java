package Graph;

import java.util.*;

public class topological_sort_khan_algo {

    public static List<Integer> topological_sort_khan_algo(ArrayList<ArrayList<Integer>> adj)
    {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        int [] ined = new int[adj.size()];
        for(int i = 0 ; i < adj.size() ;i++)
        {
            for(int j : adj.get(i))
            {
                ined[j]++;
            }
        }
        for(int i = 0 ; i < adj.size() ;i++)
        {
            if(ined[i]==0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int temp = q.poll();
            res.add(temp);
            for(int j : adj.get(temp))
            {
                ined[j]--;
                if(ined[j]==0)
                {
                    q.add(j);
                }
            }
        }

        return res;
    }
    
    public static void main(String[] args) {
        // Create a sample graph represented as adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = 6;
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Add edges
        adj.get(5).add(2);
        adj.get(5).add(0);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        
        // Get topological sort
        List<Integer> result = topological_sort_khan_algo(adj);
        
        // Print the result
        System.out.println("Topological Sort Order:");
        for(int vertex : result) {
            System.out.print(vertex + " ");
        }
    }
    
}