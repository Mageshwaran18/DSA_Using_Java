package Graph;
import java.util.*;

public class dfs {

    static class Graph{

        static int vertices;
        static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        public Graph(int vertices)
        {
            Graph.vertices = vertices;
            for(int i = 0 ; i < vertices ; i++)
            {
                edges.add(new ArrayList<>());
            }
        }

        public static void addUnDirected(int src,int dest)
        {
            // 0-4 == 0->4 == 0<-4
            edges.get(src).add(dest);
            edges.get(dest).add(src);
        }

        
        public static void addDirected(int src,int dest)
        {
            edges.get(src).add(dest);   // 0->4 != 0<->4
        }

        public static void printNodes()
        {
            for(int i = 0 ; i < vertices ; i++)
            {
                System.out.print(" Node :- "+ i + " Neighbours :- ");
                ArrayList<Integer> temp = edges.get(i);
                for(Integer j : temp)
                {
                    System.out.print( j + " ");
                }
                System.out.println();
            }
        }

        public static void dfs_helper_rec(int start, boolean[] visited)
        {
            System.out.print(start + " ");
            visited[start]=true;
            for(Integer i : edges.get(start))
            {
                if(!visited[i])
                {
                    dfs_helper_rec(i,visited);
                }
            }
        }

        public static void dfs_helper_sta(int start,boolean[] visited)
        {
            Stack<Integer> st = new Stack<>();
            visited[start]=true;
            st.add(start);
            while(!st.isEmpty())
            {
                int temp = st.pop();
                System.out.print(temp + " ");
                for(Integer i: edges.get(temp))
                {
                    if(!visited[i])
                    {
                        st.add(i);
                        visited[i]=true;
                    }
                }
            }
        }



        public static void dfs(int start)
        {
            boolean visited_rec[] = new boolean[edges.size()];
            System.out.print("Using Recursion :- ");
            dfs_helper_rec(start,visited_rec);
            System.out.print("\n Using Stack :- ");
            boolean visited_sta[] = new boolean[edges.size()];
            dfs_helper_sta(start,visited_sta);
        }
    }
    public static void main(String args[])
    {
        Graph gud = new Graph(5);
        gud.addUnDirected(0,1);        // 0 --- 1
        gud.addUnDirected(0,2);        //  \   /|
        gud.addUnDirected(1,2);        //   \ / |
        gud.addUnDirected(1,3);        //    2  |
        gud.addUnDirected(2,4);        //    |  |
        gud.addUnDirected(3,4);        //    4--3
        System.out.println("Undirected Graph's Depth First Search : ");
        gud.dfs(0);
    }
}
