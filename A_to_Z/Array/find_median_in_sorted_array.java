package Array;

public class find_median_in_sorted_array {

    public double find_median_in_sorted_array(int[] nums1, int[] nums2) {

        int n = nums1.length + nums2.length;
        int [] arr=new int[n];
        int i = 0,j = 0 ,k = 0 ;
        while(k < n)
        {
            if(i < nums1.length && j < nums2.length)
            {
                if(nums1[i]<nums2[j])
                {
                    arr[k++]=nums1[i++];
                }
                else
                {
                    arr[k++]=nums2[j++];
                }
            }
            else if(i < nums1.length)
            {
                arr[k++]=nums1[i++];
            }
            else if(j < nums2.length)
            {
                arr[k++]=nums2[j++];
            }
        }
        int mid = n/2;
        if(n%2==0)
        {
            return (arr[mid]+arr[mid-1])/2.0;
        }
        else
        {
            return arr[mid]/1.0;
        }
        
    }
    
    public static void main(String[] args) {
        find_median_in_sorted_array solution = new find_median_in_sorted_array();
        int[] nums1 = {1, 3 ,5};
        int[] nums2 = {2,6};
        double median = solution.find_median_in_sorted_array(nums1, nums2);
        System.out.println("Median of merged arrays: " + median);
    }
}
