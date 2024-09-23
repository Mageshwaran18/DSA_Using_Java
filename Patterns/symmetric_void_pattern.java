package Patterns;

public class symmetric_void_pattern {

    public static void symmetric_void_pattern()
    {
        int n = 5;
        for(int row = 0 ; row < n ; row++)
        {
            for(int column = n-row ; column > 0 ; column--)
            {
                System.out.print("*");
            }
            for(int space = 0 ; space < row*2;space++)
            {
                System.out.print(" ");
            }
            for(int column = n-row ; column > 0 ; column--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        for(int row = 0 ; row < n ; row++)
        {
            for(int column = row ; column >=0 ; column-- )
            {
                System.out.print("*");
            }
            for(int space = 0 ; space < (n-1-row)*2 ; space++)
            {
                System.out.print(" ");
            }
            for(int column = row ; column >=0 ; column--)
            {
                System.out.print("*");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args)
    {
        symmetric_void_pattern();    
    }
    
}
