package Binary_Search;

public class lower_upper_bound {

    public static int lower_bound(int arr[],int target)
    {
        int n = arr.length;
        int low = 0 ; 
        int high = arr.length-1;
        int ans = n;
        while(low<=high)
        {
            int mid = low + ( high - low )/2;
            if(arr[mid] >= target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return ans;
    }

    public static int upper_bound(int arr[],int target)
    {
        int n = arr.length;
        int low = 0 ; 
        int high = arr.length-1;
        int ans = -1;
        while(low<=high)
        {
            int mid = low + ( high - low )/2;
            if(arr[mid] >= target)
            {
                ans = mid;
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 3, 4, 5};
        int target = 3;
        
        int lowerBound = lower_bound(arr, target);
        int upperBound = upper_bound(arr, target);
        
        System.out.println("Lower bound of " + target + " is at index: " + lowerBound);
        System.out.println("Upper bound of " + target + " is at index: " + upperBound);
    }
    
}
