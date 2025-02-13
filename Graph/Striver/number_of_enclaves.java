package Graph.Striver;

/* LeetCode :- 1020 https://leetcode.com/problems/number-of-enclaves/description/ */

/* It looks same like the Surrounded region , in that question you need to mark that as X 
 * In this question you need to return the number of O converted to X.
 */

 /* My Approach :- If you found the 1 in the corners , spread from there and mark every adjacent 1 as zero 
  *                Count the remaining 1 left in the matrix.
  */
public class number_of_enclaves {

    /* My Approach */
    
    /* public int numEnclaves(int[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        for(int i=0;i<c;i++) {
            if(grid[0][i]==1)
                dfs(grid,0,i);
        }

        for(int i=0;i<r;i++) {
            if(grid[i][0]==1)
                dfs(grid,i,0);
        }

        for(int i=0;i<c;i++) {
            if(grid[r-1][i]==1)
                dfs(grid,r-1,i);
        }

        for(int i=0;i<r;i++) {
            if(grid[i][c-1]==1)
                dfs(grid,i,c-1);
        }
        int ans=0;
        for(int[] a:grid){
            for(int b:a){
                ans+=b;
            }
        }
        return ans;
    }
    public static void dfs(int[][] grid,int r,int c){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]!=1){
            return;
        }

        grid[r][c] =0;
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c-1);
        dfs(grid,r,c+1);
    } */

    public  static int cnt = 0;

    public static void dfs_helper(int r , int c , int[][] grid , boolean [][] visited)
    {
        if(r< 0 || c < 0 || r>= grid.length || c>=grid[0].length || grid[r][c]==0 || visited[r][c])
        {
            return;
        }
        else
        {
            visited[r][c]=true;
            cnt++;
            int dir[][] = {{r+1,c},{r-1,c},{r,c+1},{r,c-1}};
            for(int temp[] : dir)
            {
                dfs_helper(temp[0],temp[1],grid,visited);
            }
        }
    }

    public static int number_of_enclaves(int[][] grid) {

        cnt=0;
        int row = grid.length ; 
        int col = grid[0].length;

        boolean visited[][] = new boolean[row][col];

        for(int i = 0 ; i < col ; i++)
        {
            if(grid[0][i]==1 && !visited[0][i])
            {
                dfs_helper(0,i,grid,visited);
            }

            if(grid[row-1][i]==1 && !visited[row-1][i])
            {
                dfs_helper(row-1,i,grid,visited);
            }
        }

        for(int i = 1 ; i < row-1 ;i++)
        {
            if(grid[i][0]==1 && !visited[i][0])
            {
                dfs_helper(i,0,grid,visited);
            }

            if(grid[i][col-1]==1 && !visited[i][col-1])
            {
                dfs_helper(i,col-1,grid,visited);
            }
        }

        int tt = 0;
        for(int i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                if(grid[i][j]==1)
                {
                    tt++;
                }
            }
        }

        return tt-cnt;
        
    }

    public static void main(String[] args) {
        int[][] grid = {
            {0,0,0,0},
            {1,0,1,0},
            {0,1,1,0},
            {0,0,0,0}
        };
        
        int result = number_of_enclaves(grid);
        System.out.println("Number of enclaves: " + result);
    }
    
}
