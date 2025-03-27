package Graph.Striver;


/* LeetCode :- 130 https://leetcode.com/problems/surrounded-regions/ */

/* It's just simple problem , change the way of approach . 
 * ---> Find the O in the edges of the matrix 
 * ---> If you found assume that as the starting point of a region and mark everything ( horizontal or vertical )  parts to that , which are zero , Mark them as visited.
 * ---> Ulla irunthu veliya pogama , veliya irunthu ulla po !
 */

public class surrounded_region {
    public static void dfs_helper(int row, int col , char[][] board,boolean [][] visited)
    {
        if(row<0 || col <0 || row>= board.length || col>= board[0].length || board[row][col]=='X' || visited[row][col])
        {
            return;
        }
        else
        {   
            visited[row][col]=true;
            int [][] dir = {{row+1,col},{row-1,col},{row,col+1},{row,col-1}};
            for(int i[]: dir)
            {
                dfs_helper(i[0],i[1],board,visited);
            }

        }
    }
    public static void surrounded_region(char[][] board) {

        int row = board.length ; 
        int col = board[0].length;

        boolean [][] visited = new boolean[row][col];

        for(int i = 0 ; i < col ; i++)
        {
            // Top of the matrix
            if(board[0][i]=='O' && !visited[0][i])
            {
                dfs_helper(0,i,board,visited);
            }

            // Bottom of the matrix 
            if(board[row-1][i]=='O' && !visited[row-1][i])
            {
                dfs_helper(row-1,i,board,visited);
            }
        }

        for(int i = 1 ; i < row-1 ; i++)
        {
            // Left side of the matrix
            if(board[i][0]=='O' && !visited[i][0])
            {
                dfs_helper(i,0,board,visited);
            }

            // Right side of the matrix
            if(board[i][col-1]=='O' && !visited[i][col-1])
            {
                dfs_helper(i,col-1,board,visited);
            }
        }



        for(int i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < col ; j++)
            {
                if(board[i][j]=='O' && !visited[i][j])
                {
                    board[i][j]='X';
                }
            }
        }
        
    }
    
    public static void main(String[] args) {
        char[][] board = {
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        };
        
        System.out.println("Original Board:");
        printBoard(board);
        
        surrounded_region(board);
        
        System.out.println("\nBoard after solving:");
        printBoard(board);
    }
    
    private static void printBoard(char[][] board) {
        for(char[] row : board) {
            for(char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
