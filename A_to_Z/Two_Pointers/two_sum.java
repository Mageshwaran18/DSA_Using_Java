package Two_Pointers;
import java.util.Arrays;


public class two_sum {

    public static int[] two_sum(int arr[],int size ,int target)
    {
        Arrays.sort(arr);
        int i = 0 ;
        int j = size-1;
        while(i<j)
        {
            if(arr[i]+arr[j]==target)
            {
                return new int[] {i,j};
            }
            else
            {
                if( arr[i] + arr[j] < target)
                {
                    i++;
                }
                else
                {
                    j--;
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        
        int arr[] = {10,15,2,90,85};
        int  n = arr.length;
        int target = 100;
        int []ans = two_sum(arr, n ,target);
        for(int i : ans)
        {
            System.out.print(i +" ");
        }
        
    }
    
}
