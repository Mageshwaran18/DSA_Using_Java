package Graph.Striver;
import java.util.*;
public class graph_creation {

    public static void graph_creation(int [][]graphs,int v , int e)
    {
        // @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[v];
        for(int i = 0 ; i < v ; i++)
        {
            adj[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < e ; i++ )
        {
            adj[graphs[i][0]].add(graphs[i][1]);
            adj[graphs[i][1]].add(graphs[i][0]);
        }

        for(int i = 0 ; i < v ; i++)
        {
            System.out.print("Neighbours of " + i + " are ");
            for(int j : adj[i])
            {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int v = 5; // number of vertices
        int e = 6; // number of edges
        int[][] graphs = {
            {0, 1},
            {0, 2},
            {2, 3},
            {1, 3},
            {1, 4},
            {3, 4}
        };
        graph_creation(graphs, v, e);
    }
    
}