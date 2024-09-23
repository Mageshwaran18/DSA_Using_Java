package Patterns;

public class Alpha_hill_pattern {

    public  static void  Alpha_hill_pattern()
    {
        int n = 5 ; 
        for(int row = 0 ; row < n ; row++)
        {
            char ch = 'A' ;
            for(int space = 0 ; space < n - row ; space++)
            {
                System.out.print(" ");
            }
            for(int column = 0 ; column < (2*row)+1 ; column ++)
            {
                if ( column < row)
                {
                    System.out.print( ch++ );
                }
                else
                {
                    System.out.print(ch--);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Alpha_hill_pattern();
        /* 
         * Each row contains odd number of elements in it 
         * When the column is greater than row the element start to decrease
         * The first element wants to be allign in the center at the n th position, which tell that it contains n-1 leading spaces, 
         * For the second row it should be in the n-1 th position , which tells that there should be n-row leading spaces.
         */
    }
}
