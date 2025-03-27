package Back_Tracking;

import java.util.*;

/* LeetCode :- 51 https://leetcode.com/problems/n-queens/ */

/* First see the DSA notes then have a try , about the coding 
 * For better understanding solution https://leetcode.com/problems/n-queens/solutions/5988136/beats-100-list-of-common-backtracking-problems/
 */

/* Need to create a board first  and fill that with doubts ( as intially there will be no queens present in the board */
/* Create dfs , with the base condition and the next checking iteration */
/* Base condition , once we reach the end the board should be converted to the format of res , so that it can be saved in to the res */
/* Create a function to check whether the particular position is valid or not */
public class n_queen {

    public static List < List < String >> solveNQueens(int n) 
    {
        char board[][] = new char[n][n];
        for(char i[]:board)
        {
            for(int j = 0 ; j < n ; j++ )
            {
                i[j]='.';
            }
        }
        List<List<String>> res = new ArrayList<>();
        dfs(0,board,res);
        return res;
    }

    public static void dfs(int col,char[][] board,List<List<String>> res)
    {
        if(col==board.length)
        {
            res.add(construct(board));
            return;
        }
        for(int row = 0 ; row < board.length ; row++)
        {
            if(isValid(row,col,board))
            {
                board[row][col]='Q';
                dfs(col+1,board,res);
                board[row][col]='.';
            }
        }
        return;
    }

    public static boolean isValid(int row , int col , char[][] board)
    {
        /* Refer DSA notes */
        int dum_row = row;
        int dum_col = col;

        /* Upper left */
        while(row>=0 && col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row--;
            col--;
        }

        row = dum_row;
        col = dum_col;

        /* Striaght Left */

        while(col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }

            col--;
        }

        /* Lower right */

        row = dum_row;
        col = dum_col;

        /* row starts from 0 and to run untill board.length */
        while(row < board.length && col>=0)
        {
            if(board[row][col]=='Q')
            {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }


    public static List<String> construct(char[][] board)
    {
        //List<String> temp = new ArrayList<>(board);
        // The line List<String> temp = new ArrayList<>(board) is wrong because you cannot directly create an ArrayList from a char[][] array. 
        //The constructor ArrayList<>(Collection) expects a Collection type parameter, but board is a 2D char array. */

        List<String> temp = new ArrayList<>();

        /* the board contains ['.', 'q' , '.' , '.'] , ['.', '.' , '.' , 'q'] , ['q', '.' , '.' , '.'] , ['.', '.' , 'q' , '.'] */
        /* We need to convert that into [".q.."] */
        for(int i = 0 ; i < board.length ; i++)
        {
            String str = new String(board[i]);
            temp.add(str);
        }

        return temp;
    }

    public static void main(String args[]) {
        int N = 4;
        List < List < String >> queen = solveNQueens(N);
        int i = 1;
        for (List < String > it: queen) {
            System.out.println("Arrangement " + i);
            for (String s: it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }
    }
    
}