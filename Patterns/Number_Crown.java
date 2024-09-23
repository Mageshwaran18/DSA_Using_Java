package Patterns;

public class Number_Crown {

    public static void Number_Crown()
    {
        int n = 3 ; 
        for( int row = 1 ; row <= n ;row++)
        {
            for(int column = 1 ; column <= row ; column++)
            {
                System.out.print(column);
            }
            for(int space = 0 ; space < (n-row)*2 ; space++ )
            {
                System.out.print(" ");
            }
            for(int column = row ; column > 0 ; column--)
            {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        Number_Crown();
    }
    
}

