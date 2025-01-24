package Back_Tracking;

import java.util.*;

/* LeetCode :- 51 https://leetcode.com/problems/n-queens/ */

/* First see the DSA notes then try coding
 * For better understanding see solution: https://leetcode.com/problems/n-queens/solutions/5988136/beats-100-list-of-common-backtracking-problems/
 */

/* Steps to solve N-Queens:
 * 1. Create a board and fill it with dots (representing empty spaces)
 * 2. Implement DFS with base condition and checking iterations
 * 3. Base condition: when reaching the end, convert board to required format and save to result
 * 4. Create function to validate queen placement positions
 */
public class n_queen {

    public static List<List<String>> solveNQueens(int boardSize) 
    {
        char chessBoard[][] = new char[boardSize][boardSize];
        for(char row[]: chessBoard)
        {
            for(int col = 0; col < boardSize; col++)
            {
                row[col] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        dfs(0, chessBoard, result);
        return result;
    }

    public static void dfs(int currentCol, char[][] chessBoard, List<List<String>> result)
    {
        if(currentCol == chessBoard.length)
        {
            result.add(constructBoard(chessBoard));
            return;
        }
        for(int currentRow = 0; currentRow < chessBoard.length; currentRow++)
        {
            if(isValidPosition(currentRow, currentCol, chessBoard))
            {
                chessBoard[currentRow][currentCol] = 'Q';
                dfs(currentCol + 1, chessBoard, result);
                chessBoard[currentRow][currentCol] = '.';
            }
        }
        return;
    }

    public static boolean isValidPosition(int row, int col, char[][] chessBoard)
    {
        /* Check three directions for queen attacks:
         * 1. Upper left diagonal
         * 2. Straight left
         * 3. Lower left diagonal
         */
        int tempRow = row;
        int tempCol = col;

        /* Check upper left diagonal */
        while(row >= 0 && col >= 0)
        {
            if(chessBoard[row][col] == 'Q')
            {
                return false;
            }
            row--;
            col--;
        }

        row = tempRow;
        col = tempCol;

        /* Check straight left */
        while(col >= 0)
        {
            if(chessBoard[row][col] == 'Q')
            {
                return false;
            }
            col--;
        }

        row = tempRow;
        col = tempCol;

        /* Check lower left diagonal */
        while(row < chessBoard.length && col >= 0)
        {
            if(chessBoard[row][col] == 'Q')
            {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }

    public static List<String> constructBoard(char[][] chessBoard)
    {
        List<String> boardConfiguration = new ArrayList<>();
        
        /* The board contains ['.', 'Q' , '.' , '.'] , ['.', '.' , '.' , 'Q'] , ['Q', '.' , '.' , '.'] , ['.', '.' , 'Q' , '.'] */
        /* We need to convert that into [".Q.."] */
        
        for(int i = 0 ; i < chessBoard.length ; i++)
        {
            String rowString = new String(chessBoard[i]);
            boardConfiguration.add(rowString);
        }

        return boardConfiguration;
    }

    public static void main(String args[]) {
        int boardSize = 4;
        List<List<String>> queenSolutions = solveNQueens(boardSize);
        int solutionNumber = 1;
        for(List<String> solution: queenSolutions) {
            System.out.println("Arrangement " + solutionNumber);
            for(String boardRow: solution) {
                System.out.println(boardRow);
            }
            System.out.println();
            solutionNumber += 1;
        }
    }
    
}