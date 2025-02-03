package Array.Strivers.Easy;


/* Hint :- It's a combination of 2 steps 
 *         Step 1 :- Transpose the matrix 
 *                   --> Diagonal remains the same 
 *                   --> j should start after the i , if not it will transform two times resulting the same matrix 
 *                   --> Ex:-  i = 0 , j = 0 will lead to diagonal values , i = 0 , j = 1 swap ( [ 0 , 1] , [ 1 , 0 ]) , if i = 1 , j  = 0 then it may lead to the second swap which can be avoided using i = 0 , then j = i + 1 
 *                   --> If i = 1 , j = i + 1 ( 2 ) it leaves the transposed index unchanged 
 *         Step 2 :- Reverse each row 
 */
public class rotate_matrix_90 {

    public static void display(int [][]mat , int r , int c)
    {
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c ; j++)
            {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }   
    }

    public static void rotate_matrix_90(int [][] mat , int r , int c)
    {
        /* Transpose the matrix*/
        for(int i = 0 ; i < r ; i++)
        {
            for(int j = i+1 ; j < c ; j++)
            {
                int temp = mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }

        /* Reverse the matrix by row */

        for(int i = 0 ; i < r ; i++)
        {
            for(int j = 0 ; j < c/2 ; j++)
            {
                int temp = mat[i][j];
                mat[i][j]=mat[i][c - 1 - j];
                mat[i][c - 1 - j]=temp;
            }
        }
    }
    
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int rows = 3;
        int cols = 3;
        
        System.out.println("Original Matrix:");
        display(matrix, rows, cols);
        
        rotate_matrix_90(matrix, rows, cols);
        
        System.out.println("\nRotated Matrix:");
        display(matrix, rows, cols);
    }
}
