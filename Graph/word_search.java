package Graph;


/* LeetCode :- 79 https://leetcode.com/problems/word-search/ */

/* I feel like it's combination of n queen and the no_of_islands */

public class word_search {

    public static boolean dfs(int row , int col , int need , char[][]board , String word)
    {
        if(need >= word.length())
        {
            return true;
        }
        else if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col]!=word.charAt(need))
        {
            return false;
        }
        board[row][col]='.';
        if(dfs(row+1,col,need+1,board,word) || dfs(row-1,col,need+1,board,word) || 
        dfs(row,col+1,need+1,board,word) || dfs(row,col-1,need+1,board,word)) // if diagonal is also allowed then call another two dfs calls dfs(row-1,col-1,need+1,borad,word) || dfs(row+1,col+1,need+1,borad,word) 
        {
            return true;
        }
        else
        {
            board[row][col]=word.charAt(need);
            return false;
        }
        

    }

    public boolean exist(char[][] board, String word) {

        for(int i = 0 ; i < board.length ; i++)
        {
            for(int j = 0 ; j < board[0].length ;j++)
            {
                if(board[i][j]==word.charAt(0))
                {
                    if(dfs(i,j,0,board,word))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
        
    }

    public static void main(String[] args) {
        word_search solution = new word_search();
        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean result = solution.exist(board, word);
        System.out.println("Word '" + word + "' exists: " + result);
    }
    
}