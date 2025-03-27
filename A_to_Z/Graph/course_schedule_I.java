package Graph;

import java.util.*;

/* LeetCode :- 207 https://leetcode.com/problems/course-schedule/description/ */

/* It's the implementation of the Topological sort , Refer the DSA notes  */

public class course_schedule_I {

    public static boolean  course_schedule_I(int n, int[][] prerequisites)
    {
        /*  To create an adjacency list */
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int [] i : prerequisites)
        {
            adj.get(i[1]).add(i[0]);
        }

        /* Indegree calculation */

        int in[] = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int node : adj.get(i))
            {
                in[node]++;
            }
        }

        /* Inserting the nodes with o as indegree */
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++)
        {
            if(in[i]==0)
            {
                q.add(i);
            }
        }

        // if no nodes have the indegree as 0 , then there is cycle 
        if(q.isEmpty())
        {
            return false;
        }

        int count = 0;

        while(!q.isEmpty())
        {
            count++;
            int temp = q.poll();
            for(int j: adj.get(temp))
            {
                in[j]--;
                if(in[j]==0)
                {
                    q.add(j);
                }
            }

        }
        if(count==n)
        {
            return true;
        }

        return false;

    }


    public static void main(String[] args) {
        int[][] prerequisites = {{1,0}};
        int n = 2;
        System.out.println(course_schedule_I(n, prerequisites));
    }
    
}
