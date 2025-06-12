package Array.Strivers.Medium;
import java.util.*;

/* LeetCode :- 31 https://leetcode.com/problems/next-permutation/description/ */

/* Brute Force :- --> Generate all the permutation possible , Make sure you generate in the lexographical order
 *                --> Find the matching permutation with the target and also the index position of it
 *                --> If the index position is last of all the permutation then return the first permutation , if not return the next permutation after matching 
 *                --> T.C :- O( 2^N * N ) [ for generating all the permutation and also checking that with the target array ]
 *                --> S.C :- O( 2^N ) [ for storing all the permutations possible ]
 * 
 * Optimal Approach :- --> Find the longest unchangeing possible lexographics , [ determine where the change in the array should start ]
 *                         Ex:- ranb range rank [ the longest unchangeing lexo is ran , the follwoing would be changing from there ]
 *                              --> I also know that g comes before k and b comes before g
 *                         Ex:- [2,1,5,4,3]
 *                                   --> I know that 543 can't be arrange in such way that we will get number greater than 543
 *                                       so i need to replace 1 with any other numbers only.
 *                                   --> Because when i draw a graph from the end of the array the graph is strictly increasing only , hence i found a dip only in the 1 after 5.
 *                                   --> Now i know that i need to replace 1 , but with which number ? the number which is greater than 1 but minimum among the left behind array [ 5, 4, 3]
 *                                   --> 3 is the replacement Because i have 5 , 3 , 4 then possible number that can come after 1543 can start only with 3
 *                                   --> Now the array becomes [2,3,5,4,1] , now what is the array i need ? [ 2 , 3, 1, 4, 5]
 *                                   --> Then once after the replacement just reverse the left behind array from the breaking point (1)
 *                                   --> Now i got [2,3,1,4,5] --> which is the next permutation.
 *
 *                     --> Algo :- 1. Find the break point (i)
 *                                 2. Replace the break point arr[i] with the number which is greater than break point number arr[i]  but minimum among the left behind array arr[i+1:]
 *                                 3. Reverse the array after break point (i) reverse (arr[i+1:])
 *                              
 *                     --> T.C :- O(N) + O(N) + O(N) = O(3N) [find break point + find the replacement + reverse the left over array ]
 *                     --> S.C :- O( 1 )
 */
public class next_permutation {

    static class brute_force
    {
        public static void all_permutations(ArrayList<ArrayList<Integer>> ans , ArrayList<Integer> perm , ArrayList<Integer> nums)
        {
            if(nums.size()==0)
            {
                ans.add(perm);
            }
            else
            {
                for(int i = 0 ; i < nums.size(); i++)
                {
                    ArrayList<Integer> temp_nums = new ArrayList<>(nums);
                    int rem = temp_nums.remove(i);
                    ArrayList<Integer> temp_perm =  new ArrayList<>(perm);
                    temp_perm.add(rem);
                    all_permutations(ans,temp_perm,temp_nums);
                }
            }
        }

        public static boolean check(ArrayList<Integer>arr1,int[] arr2)
        {
            for(int i = 0  ; i < arr2.length ; i++)
            {
                if(arr2[i]!=arr1.get(i))
                {
                    return false;
                }
            }
            return true;
        }

        public static int[] format(ArrayList<Integer> arr)
        {
            int ans [] = new int[arr.size()];
            for(int i = 0 ; i < arr.size() ; i++)
            {
                ans[i]=arr.get(i);
            }
            return ans;
        }

        public static int[] brute_force(int[] arr)
        {
            int sorted_arr[] = arr.clone();
            Arrays.sort(sorted_arr);
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ArrayList<Integer> nums = new ArrayList<>();
            ArrayList<Integer> perm = new ArrayList<>();
            int final_ans[];
            for(int i : sorted_arr)
            {
                    nums.add(i);
            }
            all_permutations(ans,perm,nums);
            int index = 0;
            for(ArrayList<Integer> temp : ans)
            {
                    if(check(temp,arr))
                    {
                        break;
                    }
                    index++;
            }

            if(index+1==ans.size())
            {
                    final_ans=format(ans.get(0));
            }
            else
            {
                    final_ans=format(ans.get(index+1));
            }

            return final_ans;

        }
    }

    static class optimal_approach
    {
        public static int break_point(int[]arr)
        {
            int index = -1;
            for(int i = arr.length-1;i > 0 ; i--)
            {
                if(arr[i-1]<arr[i])
                {
                    index = i-1;
                    return index;
                }
            }

            return index;
        }

        public static int[] reverse(int[] ans,int start)
        {
            int i = start;
            int j = ans.length-1;
            while(i<=j)
            {
                int temp = ans[i];
                ans[i] = ans[j];
                ans[j] = temp;
                i++;
                j--;
            }
            return ans;
        }

        public static int next_lowest(int[]arr , int start,int to_be_replaced)
        {
            int min_index = start;
            for(int i = start ; i < arr.length ; i++)
            {
                if(arr[min_index]>=arr[i] && arr[to_be_replaced] < arr[i])
                  /*
                 * Why equal to in next_lowest function?
                 * Example: [2,3,1,3,3]
                 * Without equal to in comparison (arr[min_index]>=arr[i]):
                 * Break Point: 2
                 * Next Lowest: 3
                 * After Swapping: [2,3,3,1,3]
                 * This gives incorrect next permutation
                 * 
                 * With equal to:
                 * Correctly handles duplicate elements and finds
                 * the rightmost next lowest number
                 */
                {
                    min_index=i;
                }
            }
            return min_index;
        }

        public static int[] optimal_approach(int[] arr)
        {
            int index = break_point(arr);
            int ans[] = arr.clone();
            // System.out.println("Break Point :- " + index);
            if(index==-1)
            {
                return reverse(ans,0);
            }
            else
            {
                
                int temp_index = next_lowest(arr,index+1,index);
                int temp = ans[index];
                ans[index]= ans[temp_index];
                ans[temp_index]=temp;
                // System.out.println("Next Lowest :- " + temp_index);
                // System.out.println("After Swapping :- " + Arrays.toString(ans));
                return reverse(ans,index+1);
            }

        }

    }
    public static void main(String args[])
    {
       int arr[] = {2,1,5,4,3};
       int ans1[] = brute_force.brute_force(arr);
       int ans2[] = optimal_approach.optimal_approach(arr);
       System.out.println(Arrays.toString(ans1));
       System.out.println(Arrays.toString(ans2));
    }
    
}
