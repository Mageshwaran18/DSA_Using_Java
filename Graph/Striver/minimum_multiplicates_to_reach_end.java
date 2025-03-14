package Graph.Striver;

import java.util.*;

public class minimum_multiplicates_to_reach_end {

    static class iPair
    {
        int node;
        int st;
        
        iPair(int node,int st)
        {
            this.node = node;
            this.st = st;
        }
    }
    
    public static int minimumMultiplications(int[] in, int start, int end) {
        
        HashMap<Integer,Integer> steps = new HashMap<>();
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b) -> Integer.compare(a.st,b.st));
        if(start==end)
        {
            return 0;
        }
        pq.add(new iPair(start,0));
        while(!pq.isEmpty())
        {
            iPair pop = pq.poll();
            int pn = pop.node;
            int pst = pop.st;
            for(int neigh : in)
            {
                int nn = (pn*neigh)%100000;
                int nst = pst + 1;
                if(steps.get(nn)==null || steps.get(nn)>nst)
                {
                        pq.add(new iPair(nn,nst));
                        steps.put(nn,nst);
                }
            }
        }
        
        if(steps.get(end)!=null)
        {
            return steps.get(end);
        }
        else
        {
            return -1;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;
        int result = minimumMultiplications(arr, start, end);
        System.out.println("Minimum number of multiplications to reach " + end + " from " + start + ": " + result);
    }
}
