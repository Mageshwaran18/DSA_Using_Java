package Array.Strivers.Easy;

public class print_Alternately_Elements_in_Matrix {

    public void printAlternatelyElements(int[][] mat,int m,int n) {
        int j = 0 ;
        for(int i = 0 ; i < m ; i++)
        {
            if(i%2==0)
            {
                while( j < n)
                {
                    System.out.print(mat[i][j] + " ");
                    j++;
                }
            }
            else
            {
                while(j > 0)
                {
                    j--;
                    System.out.print(mat[i][j] + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int m = 3; // number of rows
        int n = 3; // number of columns
        
        print_Alternately_Elements_in_Matrix obj = new print_Alternately_Elements_in_Matrix();
        obj.printAlternatelyElements(matrix, m, n);
    }
}