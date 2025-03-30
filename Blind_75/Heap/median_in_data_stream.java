import java.util.*;

/* LeetCode :- 295 https://leetcode.com/problems/find-median-from-data-stream/ */

class median_in_data_stream
{

    public median_in_data_stream() {
        
    }
    private PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder());
    private PriorityQueue<Integer> large = new PriorityQueue<>();
    private boolean even = true;
    
        
    public double findMedian() {
        if (even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
    
    public void addNum(int num) {
        if (even) {
            large.offer(num);
            small.offer(large.poll());
        } else {
            small.offer(num);
            large.offer(small.poll());
        }
        even = !even;
    }

    public static void main(String[] args) {
        median_in_data_stream medianFinder = new median_in_data_stream();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian()); // 1.5
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian()); // 2.0
    }
}