package Prefix_Sum;

/* LeetCode :- 724 https://leetcode.com/problems/find-pivot-index/description/ */

/*  Brute Approach :- Calculate the prefix sum and sufffix sum in each two different arrays,
                     the point at which each arrays have the same values 

    Optimal Approach :- Calculate total sum first, then iterate through array keeping track of left sum.
                       At each index, if left sum equals (total sum - left sum - current element),
                       we found pivot index. This uses O(n) time and O(1) space complexity.
*/

class find_pivot {
    public static void display(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /*  Brute Force  

    public static int find_pivot(int[] arr) {
        int n = arr.length;
        int pre[] = new int[n];
        int suf[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            pre[i] = sum;
        }
        sum = 0;

        for (int i = n-1; i >= 0; i--) {
            sum += arr[i];
            suf[i] = sum;
        }

        display(pre);
        display(suf);

        for (int i = 0; i < n; i++) {
            if (pre[i] == suf[i]) {
                return i;
            }
        }

        return -1;
    }
    */

    /* Optimal approach: 
     * 1. Calculate total sum of array
     * 2. Iterate through array, at each index:
     *    - Check if leftSum equals (totalSum - leftSum - current element)
     *    - If equal, we found pivot index where sum of elements on left equals sum on right
     *    - Add current element to leftSum and continue
     * 3. Return -1 if no pivot found
     */
    public static int find_pivot(int[] nums) {
        int total = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            total += nums[i];
        }
        int left_sum = 0;
        for (int i = 0; i < n; i++) {
            if (left_sum == total - left_sum - nums[i]) {
                return i;
            }
            left_sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 6, 5, 6};
        int pivotIndex = find_pivot(arr);
        System.out.println("Pivot Index: " + pivotIndex);
    }
}