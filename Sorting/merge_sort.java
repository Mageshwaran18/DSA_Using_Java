package Sorting;

/*
* Merge Sort is a divide and conquers algorithm, it divides the given array into equal parts and then merges the 2 sorted parts. 
 * Time Complexity --> O(n logn)
 */

public class merge_sort {
    
    public  void merge(int arr[], int l , int mid , int r)
    {
        int n1 = mid - l +1; /*mid element is included  */
        int n2 = r - mid;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for(int i = 0 ; i < n1 ; i++)
        {
            L[i]=arr[l+i]; /*as it should start from the lowest ( mid is included ) */
        }
        for(int j = 0; j < n2 ; j++)
        {
            R[j]=arr[mid+1+j];/*as it should start after the mid (mid is excluded )so we included + 1 */
        }

        int i= 0 , j = 0, k = l ;
        while(i < n1 && j <n2)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i++];
            }
            else
            {
                arr[k]=R[j++];
            }
            k++;
        }
        while(i<n1)
        {
            arr[k++]=L[i++];
        }
        while(j<n2)
        {
            arr[k++]=R[j++];
        }
        
    }

    public  void merge_sort(int arr[], int l , int r)
    {
        if(l<r)
        {
            int mid = (l+r)/2;
            merge_sort(arr, l, mid);
            merge_sort(arr, mid + 1, r);
            merge(arr,l,mid,r);
        }
    }


    public static void main(String[] args) {
        
        int arr[] = {3,30,34,5,1};
        int n = arr.length;
        System.out.print("Before Sorting : ");
        for(int i = 0 ;  i < n ; i++)
        {
            System.out.print(arr[i]+" ");   
        }
        merge_sort ms = new merge_sort();
        ms.merge_sort(arr,0,n-1);
        System.out.print("\nAfter Sorting : ");
        for(int i = 0 ;  i < n ; i++)
        {
            System.out.print(arr[i]+" ");   
        }
    }
}
