package Graph;

/* LeetCode :- 994 https://leetcode.com/problems/rotting-oranges/ */
/* It's basically levelorder traversal and with certain conditions , Refer DSA notes  */

import java.util.*;

public class rotten_oranges {

    
    public static int rotten_oranges(int [][]grid)
    {
        Queue<int []> q = new LinkedList<>();
        int fresh = 0;
        int gr = grid.length;
        int gc = grid[0].length;
        for(int i = 0 ; i < gr ; i++)
        {
            for(int j = 0 ; j < gc ; j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
            }
        }

        if(fresh==0)    // no rotten oranges found
        {
            return 0;
        }

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int level = 0;
        while(!q.isEmpty())
        {
            level++;
            int no_of_adj= q.size();

            for(int j = 0 ; j < no_of_adj ;j++ ) // want to deque all the adjacents of the previous layer
            {
                int cur[]=q.poll();
                int row = cur[0];
                int col = cur[1];
                for(int [] d : dir) // To check in all direction of the current adjacents
                {
                    int nr = row + d[0];
                    int nc = col + d[1];

                    if(nr < gr && nc < gc && nr >=0 && nc >= 0 && grid[nr][nc]==1)
                    {
                        grid[nr][nc]=2;
                        fresh--;
                        q.add(new int[]{nr,nc});
                    }

                }
            }
        }

        if(fresh==0) // ensure all the oranges are rotten 
        {
            return level-1;
        }
        else
        {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        
        int result = rotten_oranges(grid);
        if (result == -1) {
            System.out.println("All oranges cannot be rotten");
        } else {
            System.out.println("Time required to rot all oranges: " + result);
        }
    }
}
