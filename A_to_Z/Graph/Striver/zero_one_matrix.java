package Graph.Striver;

/* LeetCode :- 542 https://leetcode.com/problems/01-matrix/description/ */

/* Only solved using the BFS */

import java.util.*;

public class zero_one_matrix {

    public static int[][] zero_one_matrix(int[][] mat)
    {
        int row = mat.length;
        int col = mat[0].length;
        boolean [][] visited = new boolean[row][col];
        int [][] ans = new int[row][col];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new int[]{i,j});
                    visited[i][j]=true;
                    ans[i][j]=0;
                }
            }
        }

        int dir[][] = {{-1,0},{1,0},{0,-1},{0,1}};
        while(!q.isEmpty())
        {
            int n = q.size();
            for(int i = 0 ; i < n ; i++)
            {
                int [] parent = q.poll();
                int pr = parent[0];
                int pc = parent[1];
                int pv = ans[pr][pc];
                for(int j[]:dir)
                {
                    int nr = pr+j[0];
                    int nc = pc+j[1];

                    if(nr>=0 && nc>=0 && nr<row && nc<col && !visited[nr][nc])
                    {
                        ans[nr][nc]=pv+1;
                        visited[nr][nc]=true;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,1,1},
            {1,0,1},
            {1,1,1}
        };
        
        int[][] result = zero_one_matrix(matrix);
        
        // Print the result
        for(int i = 0; i < result.length; i++) {
            for(int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}