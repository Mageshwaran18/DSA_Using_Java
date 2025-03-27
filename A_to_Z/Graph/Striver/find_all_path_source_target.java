package Graph.Striver;

import java.util.*;

/* LeetCode :- 797 https://leetcode.com/problems/all-paths-from-source-to-target/description/ 
 * 
 * Refer the DSA notes 
*/

public class find_all_path_source_target {
    
    public static List<List<Integer>> ans = new ArrayList<>();
    public static ArrayList<Integer> temp = new ArrayList<>();

    public static void helper(int parent , boolean visited[] , int [][]adj , int n)
    {
        
        visited[parent]=true;
        temp.add(parent);
        
        if(parent==n-1)
        {
            visited[parent]=false;

            /* The error is in the helper method where we're adding temp directly to ans instead of creating a new copy of the path. 
            Since temp is modified after adding to ans, 
            all paths in ans will reference the same ArrayList which eventually becomes empty. 
            ans.add(temp);  // Wrong
            */

            // Correct - creates a new copy of temp
            
            ans.add(new ArrayList<>(temp)); 
            temp.remove(temp.size()-1);
            return;
        }
        for(int i : adj[parent])
        {
            if(!visited[i])
            {
                helper(i,visited,adj,n);
            }
        }

        visited[parent]=false;
        temp.remove(temp.size()-1);        

    }

    public static List<List<Integer>> find_all_path_source_target(int[][] adj)
    {
        int n = adj.length;
        boolean [] visited = new boolean[n];
        helper(0,visited,adj,n);
        return ans;
    }

    public static void main(String[] args) {
        int[][] adj = {{1,2}, {3}, {3}, {}};  // Example adjacency list
        List<List<Integer>> result = find_all_path_source_target(adj);
        System.out.println("All paths from source to target:");
        for(List<Integer> path : result) {
            System.out.println(path);
        }
    }
}
