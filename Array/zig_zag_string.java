package Array;

public class zig_zag_string {

    public static void zig_zag_string(String str , int k)
    {
        int len = str.length();
        int n = k , m ;
        if(len%k==0)
        {
            m = len/k;
        }
        else
        {
            m = (len/k)+1;
        }
        int count=0;
        int row = 0 , col = -1;
        char [][]mat = new char[n][m];
        while(count!=len)
        {
            row = 0;
            col++;
            while(row<n && count!=len)
            {
                mat[row++][col]=str.charAt(count);
                count++;
            }
            col++;
            row--;
            while(row>=0 && count!=len)
            {
                mat[row--][col]=str.charAt(count);
                count++;
            }
        }
        for(int i = 0 ; i < n ; i++)
        {
            for(int j = 0 ; j < m ; j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        String str = "SKILLRACK";
        int k = 3;
        zig_zag_string(str, k);
    }
}
