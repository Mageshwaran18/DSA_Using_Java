package Back_Tracking;


/* LeetCode :- 37 https://leetcode.com/problems/sudoku-solver/description/ */

/* It's when you follow up with the n queen problem, 
    (1) just try every number in a particular posistion 
    (2) if it's valid fill the number and repeat the process
    (3) if not remove the element.
    
    During the recursion just remember only one thing , 

    if nothing can suit in that board[row][column] space, 
    then the number which filled in the previous posistion is not valid 
    so we need to back track to that and we need to change it. 
    Refer Strivers vedio at the time stamp of : 16.50  

*/


public class solve_suduko {

    public static  void solveSudoku(char[][] board) {

        solve(board);
        
    }

    public static boolean isValid(int row , int col , char c , char [][] board){
        for(int i = 0 ; i < 9 ; i++){
            if(board[row][i]==c){
                return false;
            }

            else if(board[i][col]==c){
                return false;
            }

            else if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c)
            {
                return false;
            }
        }
        return true;
    }

    public static boolean solve(char[][] board)
    {
        for(int i = 0 ; i < 9 ; i++)
        {
            for(int j = 0 ; j < 9 ; j++)
            {
                if(board[i][j]=='.') /* CheckPoint 1 */
                {
                    for(char k = '1' ; k <= '9' ;k++)
                    {
                        if(isValid(i,j,k,board))
                        {
                            board[i][j]=k;
                            if(solve(board))
                            {
                                return true;
                            }
                            board[i][j]='.';
                        }
                    }
                     /*if nothing can suit in that board[row][column] space, 
                    then the number which filled in the previous posistion is not valid 
                    so we need to back track to that and we need to change it. 
                    Refer Strivers vedio at the time stamp of : 16.50 */
                    return false;                
                }
            }
        }
        /*If the check point has not been reached then we have not meet a single space in the matrix with the empty element */
        return true; 
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        
        if (solve(board)) {
            // Print the solved Sudoku board
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No solution exists");
        }
    }

    
}
