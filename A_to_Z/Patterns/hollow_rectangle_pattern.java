package Patterns;

public class hollow_rectangle_pattern {

    public static void hollow_rectangle_pattern()
    {
        int n = 5; 
        for(int row=0 ; row < n ; row++)
        {
            for(int column=0 ; column < n; column++)
            {
             if(row==0 || row==n-1 || column ==0||column==n-1)
             {
                System.out.print("*");
             }
             else
             {
                System.out.print(" ");
             }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        hollow_rectangle_pattern();
    }
}
