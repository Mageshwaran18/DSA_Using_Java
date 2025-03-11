package Graph.Striver;

import java.util.PriorityQueue;

/* LeetCode :- 1631 https://leetcode.com/problems/path-with-minimum-effort/ */

class iPair
    {
        int row;
        int col;
        int dis;
        int effort;

        iPair(int row,int col,int effort)
        {
            this.row=row;
            this.col=col;
            this.effort=effort;
        }
    }


public class path_with_minimum_effort {

    public static int minimumEffortPath(int[][] heights) {

        int n = heights.length;
        int m = heights[0].length;
        if(n==1 && m==1)
        {
            return 0;
        }
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b)->a.effort-b.effort);
        boolean [][] visited = new boolean[n][m];
        int dis[][] = {{-1,0},{0,1},{1,0},{0,-1}};
        pq.add(new iPair(0,0,0));
        int ans = heights[n-1][m-1];
        while(!pq.isEmpty())
        {
            iPair poll = pq.poll();
            int pr = poll.row;
            int pc = poll.col;
            int pef = poll.effort;
            if(pr==n-1 && pc==m-1)
            {
                ans = pef;
                break;
            }
            else if(!visited[pr][pc])
            {
                visited[pr][pc]=true;
                for(int j[]: dis)
                {
                    int nr = j[0] + pr;
                    int nc = j[1] + pc;
                    if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc])
                    {
                        int new_effort = Math.abs(heights[nr][nc]-heights[pr][pc]);
                        int maxi = Math.max(new_effort,pef);
                        pq.add(new iPair(nr,nc,maxi));
                    }
                }
            }

        }
        return ans;        
    }
    
    public static void main(String[] args) {
        int[][] heights = {
            {1,2,2},
            {3,8,2},
            {5,3,5}
        };
        
        int result = minimumEffortPath(heights);
        System.out.println("Minimum effort path: " + result);
    }
}
