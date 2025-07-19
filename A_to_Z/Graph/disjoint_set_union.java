import java.util.*;

class disjoint_set_union{

    
    List<Integer> size ;
    List<Integer> parent;

    disjoint_set_union(int n)
    {
        this.size = new ArrayList<>();
        this.parent = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)
        {
            size.add(1);
            parent.add(i);
        }

    }

    public int find(int x)
    {
        if(x == parent.get(x))
        {
            return x;
        }

        int par  = find(parent.get(x));
        parent.set(x,par);
        return par;
    }

    public void union(int u,int v)
    {
        int ult_par_u = find(u);
        int ult_par_v = find(v);
        if(ult_par_u == ult_par_v)
        {
            return;
        }
        if(size.get(ult_par_u) > size.get(ult_par_v))
        {
            parent.set(ult_par_v,ult_par_u);
            size.set(ult_par_u,size.get(ult_par_u)+size.get(ult_par_v));
        }
        else
        {
            parent.set(ult_par_u,ult_par_v);
            size.set(ult_par_v,size.get(ult_par_v)+size.get(ult_par_u));
        }
    }

    public static void main(String[] args) {
        // Create a disjoint set with 5 elements
        disjoint_set_union dsu = new disjoint_set_union(5);

        // Perform some union operations
        dsu.union(0, 2);
        dsu.union(4, 2);
        dsu.union(3, 1);

        // Find the representatives of each element
        System.out.println("Representative of 4: " + dsu.find(4));
        System.out.println("Representative of 0: " + dsu.find(0));
        System.out.println("Representative of 3: " + dsu.find(3));

        // Check if elements are in the same set
        System.out.println("Are 0 and 4 in same set? " + (dsu.find(0) == dsu.find(4)));
        System.out.println("Are 1 and 4 in same set? " + (dsu.find(1) == dsu.find(4)));
    }

}