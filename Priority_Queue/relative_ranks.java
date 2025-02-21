package Priority_Queue;

import java.util.PriorityQueue;

/* LeetCode:- 506 https://leetcode.com/problems/relative-ranks/description/?envType=problem-list-v2&envId=heap-priority-queue */

/* Easy code and direct approach is enough  */

public class relative_ranks {

    public static String[] findRelativeRanks(int[] score) {
        int pos = 0;
        int n = score.length;
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> b[0]-a[0]);
        String []ans = new String[n];
        for(int i = 0 ; i < n ; i++)
        {
            pq.add(new int[]{score[i],i});
        }
        while(!pq.isEmpty())
        {
            int temp [] = pq.poll();
            int node = temp[0];
            int ind = temp[1];
            if(pos==0)
            {
                ans[ind]="Gold Medal";
                pos++;
            }
            else if(pos==1)
            {
                ans[ind]="Silver Medal";
                pos++;
            }
            else if(pos==2)
            {
                ans[ind]="Bronze Medal";
                pos++;
            }
            else
            {
                ans[ind]=Integer.toString(pos+1);
                pos++;
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        int[] score = {5, 4, 3, 2, 1};
        String[] result = findRelativeRanks(score);
        
        for(int i = 0; i < result.length; i++) {
            System.out.println("Player " + (i+1) + ": " + result[i]);
        }
    }
}
