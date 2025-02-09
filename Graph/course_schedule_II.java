package Graph;


/* LeetCode :- 210 https://leetcode.com/problems/course-schedule-ii/ */
/* If you can able to do the course schedule I then you can do this also refer DSA notes */

import java.util.*;

public class course_schedule_II {

    public static int[] course_schedule_II(int n , int[][] course)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0  ; i < n ; i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int []i : course)
        {
            adj.get(i[1]).add(i[0]);
        }

        int []in = new int[n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int node: adj.get(i))
            {
                in[node]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ;i < n ; i++)
        {
            if(in[i]==0)
            {
                q.add(i);
            }
        }

        if(q.isEmpty())
        {
            return new int[0];
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty())
        {
            int temp = q.poll();
            ans.add(temp);
            for(int j : adj.get(temp))
            {
                in[j]--;
                if(in[j]==0)
                {
                    q.add(j);
                }
            }
        }

        // Collections.reverse(ans);
        int res[] = new int[ans.size()];
        for(int i = 0 ; i < ans.size() ; i++)
        {
            res[i]=ans.get(i);
        }

        if(res.length==n)
        {
            return res;
        }
        else
        {
            return new int[0];
        }
        
    }
    
    public static void main(String[] args) {
        int n = 4;
        int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[] result = course_schedule_II(n, prerequisites);
        
        System.out.print("Course Schedule Order: ");
        for(int course : result) {
            System.out.print(course + " ");
        }
    }
}
