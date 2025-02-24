package Graph.Striver;
import java.util.*;


/* LeetCode :- 802 https://leetcode.com/problems/find-eventual-safe-states/ */

/* 
 * My Approach --> Traverse in all the path possible from a node , 
 *                 if any of the path doesn't reach the terminal node or forms a cycle, then that node can't be a safe node 
 * 
 * Better and Optimal Approach --> Topological Sort ( out degree version ) . Refer the DSA notes.
 *                      
 *          
 */


public class safe_state {
    /* 
    public static boolean dfs_helper(int key, int[][] graph, boolean[] visited, Set<Integer> ter_no) {
        if (ter_no.contains(key)) {
            return true;
        } else if (visited[key]) {
            return false;
        } else {
            visited[key] = true;
            for (int i : graph[key]) {
                if (!dfs_helper(i, graph, visited, ter_no)) {
                    return false;
                }
                visited[i] = false;
            }
        }
        return true;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        Set<Integer> ter_no = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0) {
                ter_no.add(i);
            }
        }
        for (int i = 0; i < graph.length; i++) {
            boolean[] visited = new boolean[graph.length];
            if (graph[i].length == 0) {
                ans.add(i);
            } else {
                if (dfs_helper(i, graph, visited, ter_no)) {
                    ans.add(i);
                }
            }
        }
        return ans;
    }
        */


        public static List<Integer> eventualSafeNodes(int[][] graph) {

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            List<Integer> ans = new ArrayList<>();
            boolean [] visited = new boolean[graph.length];
            int [] in = new int[graph.length];
            for(int i = 0 ; i < graph.length ; i++)
            {
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0 ; i < graph.length ; i++)
            {
                in[i]=graph[i].length;
                for(int j : graph[i])
                {
                    adj.get(j).add(i);
                }
            }
            for(int i = 0 ; i < graph.length ; i++)
            {
                if(in[i]==0)
                {
                    q.add(i);
                }
            }
            if(q.isEmpty())
            {
                return ans;
            }
            while(!q.isEmpty())
            {
                int cur = q.poll();
                ans.add(cur);
                for(int neigh : adj.get(cur))
                {
                    in[neigh]--;
                    if(in[neigh]==0)
                    {
                        q.add(neigh);
                    }
                }
            }
            Collections.sort(ans);
            return ans;
        }


    public static void main(String[] args) {
        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        List<Integer> safeNodes = eventualSafeNodes(graph);
        System.out.println("Safe nodes: " + safeNodes);
    }
}
