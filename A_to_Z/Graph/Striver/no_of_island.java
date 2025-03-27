package Graph.Striver;

/* LeetCode :- 200 https://leetcode.com/problems/number-of-islands/ */
/* It's easy algorithm --> We should go only in horizontal or vertical and not in diagonal way
 *                     --> Check if grid[i][j]==1 , if yes then this could be the starting point of an island 
 *                     --> Perform DFS on that starting point by searching whether the up , down , left , right of the value is 1 , if yes then mark grid[i][j]=0 because while backtracking or traversing front we should get into loop. Then perform dfs on up , down , left , right of the grid
 *                     --> It basically like choose a point , then mark everything as 0 which is under that island 
 * For traversal refer DSA notes 
 *                                                                                                                                                                  
 */


public class no_of_island {

    public static void dfs(int row , int col , char[][] grid)
    {
        if(row < 0 || col < 0 || row>=grid.length || col>=grid[0].length || grid[row][col]=='0')
        {
            return;
        }
        else
        {
            // https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1
            // If the diagonals 1 are also calculated then we should check in the 8 directions , so we can have a loop to that.
            // int dir[][] = {{-1,0} , {-1,1} ,{0,1} , {1,1} , {1,0} , {1,-1} , {0,-1} , {-1,-1}};
            grid[row][col]='0';
            dfs(row+1,col,grid);
            dfs(row-1,col,grid);
            dfs(row,col+1,grid);
            dfs(row,col-1,grid);

        }
    }

    public static int no_of_island(char [][]grid)
    {
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++)
        {
            for(int j = 0 ; j < grid[0].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    count++;
                    dfs(i,j,grid);
                }
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        
        int islands = no_of_island(grid);
        System.out.println("Number of islands: " + islands);
    }
}
