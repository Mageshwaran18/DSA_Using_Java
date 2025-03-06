package Graph.Striver;
import java.util.*;


/* 
 * 
 * Remove --> Poping of the elements from the queue
 * 
 * Work --> if it's not visited:-
 *              Making that true and perfoming actions in them 
 *          if visited :- 
 *              Don't perform operations
 * 
 * Add --> Add it's neighbours to the queue
 * 
 * 
 */


class bfs{

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

        public void bfs(int start)
        {
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[this.edges.size()];
            q.add(start);
            while(!q.isEmpty())
            {
                int node = q.poll();
                if(visited[node])
                {
                    continue;
                }
                else
                {
                    visited[node]=true;
                    System.out.print(node + " ");
                    for(Integer i: edges.get(node))
                    {
                        if(!visited[i]) // explicit unboxing 
                        {
                            q.add(i); 
                        }
                    }
                }
            }
        }
    }


    public static void main(String args[])
    {
        Graph gud = new Graph(5);
        gud.addUnDirected(0,1);        // 0 --- 1
        gud.addUnDirected(0,2);        //  \   /
        gud.addUnDirected(1,2);        //   \ / 
                                                //    2  
        gud.addUnDirected(2,4);        //    |  
        gud.addUnDirected(3,4);        //    4--3
        System.out.println("Undirected Graph Breadth First Search : ");
        gud.bfs(0);
    }

}