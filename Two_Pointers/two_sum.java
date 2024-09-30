package Two_Pointers;

import   Sorting.merge_sort;

public class two_sum {

    public static int[] two_sum(int arr[],int size ,int target)
    {
        merge_sort ms = new merge_sort();
        ms.merge_sort(arr, size, target);
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
        two_sum(arr, n ,target);
        


    }
    
}
