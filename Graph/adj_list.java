package Graph;
import java.util.*;
public class adj_list {

    static class Graph{

        static int vertices;
        static ArrayList<ArrayList<Integer>> edges = new ArrayList<>();

        public Graph(int vertices)
        {
            this.vertices = vertices;
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
    }

    public static void main(String args[])
    {
        Graph gud = new Graph(5);
        gud.addUnDirected(0,1);
        gud.addUnDirected(0,2);
        gud.addUnDirected(1,2);
        gud.addUnDirected(1,3);
        gud.addUnDirected(2,4);
        gud.addUnDirected(3,4);
        System.out.println("Undirected Graph");
        gud.printNodes();

        Graph gd = new Graph(5);
        gd.addUnDirected(0,1);
        gd.addUnDirected(0,2);
        gd.addUnDirected(1,2);
        gd.addUnDirected(1,3);
        gd.addUnDirected(2,4);
        gd.addUnDirected(3,4);
        System.out.println("Directed Graph");
        gud.printNodes();


    }


    
}
