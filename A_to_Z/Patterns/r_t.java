package Patterns;

public class r_t {
    public static void main(String[] args) {
        int n = 5;
        for(int row = 0 ; row <= n ; row++)
        {
            for(int column = row ; column >=0 ; column--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
        inverted_right_triangle();
    }

    public static void inverted_right_triangle()
    {
        int n = 5;
        for( int row = n ; row > 0 ; row--)
        {
            for(int column = row ; column >0; column--)
            {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
