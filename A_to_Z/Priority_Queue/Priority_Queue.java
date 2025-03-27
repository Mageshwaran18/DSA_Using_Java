package Priority_Queue;

import java.util.*;

public class Priority_Queue {
    public static void main(String[] args) {
        // Creating Priority Queue
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        
        // Adding elements (Enqueue)
        numbers.add(10);
        numbers.offer(20);
        numbers.offer(5);
        numbers.offer(15);
        
        // Printing the queue
        System.out.println("Priority Queue: " + numbers);
        
        // Peek - View head element without removing
        System.out.println("Head element: " + numbers.peek());
        
        // Poll - Remove and return head element
        System.out.println("Removed element: " + numbers.poll());
        System.out.println("Queue after poll: " + numbers);
        
        // Other useful methods
        System.out.println("Queue size: " + numbers.size());
        System.out.println("Contains 20? " + numbers.contains(20));
        
        // Creating Priority Queue with custom comparator (descending order)
        PriorityQueue<Integer> descendingQueue = new PriorityQueue<>(Collections.reverseOrder());
        descendingQueue.addAll(Arrays.asList(10, 20, 5, 15));
        System.out.println("Descending Priority Queue: " + descendingQueue);
        
        // Creating Priority Queue with initial capacity
        PriorityQueue<String> strings = new PriorityQueue<>(10);
        strings.add("Apple");
        strings.add("Banana");
        strings.add("Cherry");
        System.out.println("String Priority Queue: " + strings);
        
        // Iterating through queue
        System.out.println("Iterating through queue:");
        for(Integer element : numbers) {
            System.out.print(element + " ");
        }
        System.out.println();
        
        // Clear the queue
        numbers.clear();
        System.out.println("Is queue empty? " + numbers.isEmpty());

        // (a,b) -> b-a creates a comparator that sorts in descending order
        // by comparing elements b and a. If b-a is positive, b is placed before a
        PriorityQueue <Integer> pq = new PriorityQueue<>((a,b)->b-a);    }
}