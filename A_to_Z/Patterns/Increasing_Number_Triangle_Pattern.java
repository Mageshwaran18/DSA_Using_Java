package Patterns;

public class Increasing_Number_Triangle_Pattern {

    public static void Increasing_Number_Triangle_Pattern()
    {
        int i = 1 , n = 5  ;
        for(int row = 0 ; row < n ; row++ )
        {
            for(int column = row ; column >= 0 ; column --)
            {
                System.out.print(i+" ");
                i+=1;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Increasing_Number_Triangle_Pattern();   
    }
}
