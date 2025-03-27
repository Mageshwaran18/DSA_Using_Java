package Patterns;

public class diamond_star {
    
    public static void diamond_star()
    {
        int n = 5 ; 
        for(int row = 0 ; row < n ; row++)
        {
            for(int space = 0 ; space < n-row-1 ; space++)
            {
                System.out.print(" ");
            }
            for(int column = 0 ; column < (2*row)+1 ; column ++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int row = n-1 ; row >= 0  ; row--)
        {
            for(int space = 0 ; space < n-row-1 ; space++)
            {
                System.out.print(" ");
            }
            for(int column = 0 ; column < (2*row)+1 ; column ++)
            {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) 
    {
        diamond_star();    

        /*
         * It's a combination of pyramid and the inverse pyramid.
         * The first element should be intialised in the n-1 th place , where the 2nd need to be intialised in the n-2 position , so the no of spaces required are n-row-1
         * Each row contains the 2*row+1 elements 
         */
    }



}
