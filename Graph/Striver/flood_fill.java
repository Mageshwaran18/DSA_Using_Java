package Graph.Striver;

/* LeetCode :-  733 https://leetcode.com/problems/flood-fill/description/ */

/* Its same as the no_of_island  but where we check only one point of the grid and perform dfs on that */
public class flood_fill {

    public static void dfs(int row , int col , int[][] image , int value , int color)
    {
        if(row< 0 || col < 0|| row >= image.length || col >= image[0].length || image[row][col]!=value)
        {
            return;
        }
        else
        {
            image[row][col]=color;
            dfs(row+1,col,image,value,color);
            dfs(row-1,col,image,value,color);
            dfs(row,col+1,image,value,color);
            dfs(row,col-1,image,value,color);

        }
    }
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
           /* Without this check, we would get into an infinite loop because:
      We change a pixel's color to the target color
      Then check its neighbors
      The neighbors would see this pixel as having the target color
      They would process it again
      This would repeat indefinitely 

      If we have:
      1 1 1
      1 1 1
      1 1 1

      And we want to fill position (1,1) with color 1 (which is already 1)
      Without the check, it would keep processing the same pixels over and over
*/        
        if(image[sr][sc]!=color){
            dfs(sr,sc,image,image[sr][sc],color);
        }

        return image;

    }
    
}
