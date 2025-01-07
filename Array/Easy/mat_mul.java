package Array.Easy;

public class mat_mul {
    
    public static void mat_mul(int [][] mat1 , int [][] mat2 , int n)
    {
        int [][] mat = new int[n][n];
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                for(int k = 0 ; k < n ; k++)
                {
                    mat[i][j]+=mat1[i][k] * mat2[k][j];
                }
            }
        }

        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 2;
        int[][] mat1 = {{2,1},
                       {1,2}};
        int[][] mat2 = {{1,0},
                        {0,1}};
        
        mat_mul(mat1, mat2, n);
    }
}
