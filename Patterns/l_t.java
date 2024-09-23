package Patterns;

public class l_t {
 public static void main(String[] args) {
    
    int n = 5; 
    for(int row = 0 ; row < n ; row++)
    {
        for(int space = 0 ; space < n-row-1 ; space++)
        {
            System.out.print(" ");
        }
        for(int column = row ; column >=0; column--)
        {
            System.out.print("*");
        }
        System.out.println();
    }
    inverted_left_triangle();

 }  
 
 public static void inverted_left_triangle()
 {
    int n = 5 ; 
    for(int row = n ; row >= 0 ; row --)
    {
        
        for(int space = n - row - 1 ; space >= 0 ; space --)
        {
            System.out.print(" ");
        }
        for(int column = row ; column > 0 ; column --)
        {
            System.out.print("*");
        }
        System.out.println();
    }
 }

}
