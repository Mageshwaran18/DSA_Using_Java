package Hashing;

import java.util.HashMap;

public class two_pointersh {

   public static int[] two_pointersh(int arr[],int size , int target)
    {
        int result [] = new int[2];
        HashMap <Integer,Integer> hm = new HashMap<>();
        for(int i = 0 ; i < size;i++)
        {
             hm.put(arr[i],i);
        }
        for(int i = 0 ; i < size;i++)
        {
            if(hm.get(target-arr[i])!=null)
            {
                result[0]=i;
                result[1]=hm.get(target-arr[i]);
                System.out.println(result[0] + "+" +  result[1]);
                return result;
            }

        }
        return new int[]{-1,-1};

    }
    
    
    public static void main(String[] args) {
        
        int arr[] = {10,15,2,90,80,8,42,33,1};
        int n = arr.length;
        int target = 11;
        System.out.println("The index are found in : " + two_pointersh(arr, n, target));

    }
}
