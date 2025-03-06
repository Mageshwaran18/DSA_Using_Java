package Graph.Striver;
import java.util.*;

/* LeetCode :- 1091 https://leetcode.com/problems/shortest-path-in-binary-matrix/ */

/* 
 * It's just the implementation of dijikstra algorithm , 
 * where you just need to add some conditions while adding to the queue
 * See the Code and you can understand that easily 
 * 
 */

public class shortest_path_in_binary_matrix {

    static class iPair{
        int r;
        int c;
        int we;

        iPair(int r, int c, int we)
        {
            this.r=r;
            this.c=c;
            this.we=we;
        }
    }
    public static int shortestPathBinaryMatrix(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0]!=0 || grid[n-1][m-1]!=0)
        {
            return -1;
        }
        boolean visited[][]  = new boolean [n][m];
        Queue<iPair> pq = new LinkedList<>();
        int req_pos[] = {n-1,m-1};
        int ans = -1;
        pq.add(new iPair(0,0,1)); 
        int dir[][] = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
        while(!pq.isEmpty())
        {
            iPair polled = pq.poll();
            int cur_r = polled.r;
            int cur_c = polled.c;
            int cur_we = polled.we;
            if(visited[cur_r][cur_c])
            {
                continue;
            }
            else
            {
                visited[cur_r][cur_c]=true;
                if(cur_r==req_pos[0] && cur_c==req_pos[1])
                {
                    ans=cur_we;
                    break;
                }
                for(int j[] : dir)
                {
                    int nr = cur_r+j[0];
                    int nc = cur_c+j[1];
                    if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc] && grid[nr][nc]!=1)
                    {
                        int tot = cur_we + 1;
                        pq.add(new iPair(nr,nc,tot));
                    }
                }
            }
        }
        return ans;
    }
    
}
