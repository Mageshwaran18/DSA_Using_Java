package Queue;

import java.util.Scanner;


// Enqueue logic:
        // 1. Check if the queue is full (rear == SIZE - 1)
        // 2. If not full, increment rear and add the new element at rear position


// Dequeue logic:
        // 1. Check if the queue is empty (front == rear)
        // 2. If not empty, increment front and return the element at front position

// Display logic:
        // 1. Check if the queue is empty (rear == front)
        // 2. If not empty, iterate from front+1 to rear and print each element


public class queue_implementation {

    private static final int SIZE = 5;

    static class Queue {
        int front;
        int rear;
        int[] arr;

        Queue() {
            front = -1;
            rear = -1;
            arr = new int[SIZE];
        }

        
        void enqueue(int data) {
            if (rear == SIZE - 1)
                System.out.println("The queue is full");
            else {
                rear++;
                arr[rear] = data;
            }
        }

       
        void display() {
            if (rear == front)
                System.out.println("The queue is empty");
            else {
                for (int i = front + 1; i <= rear; i++) {
                    System.out.print(arr[i] + " -> ");
                }
                System.out.println();
            }
        }

        
        void dequeue() {
            if (front == rear) {
                System.out.println("The queue is empty");
            } else {
                front++;
                System.out.println(arr[front] + " is deleted from the queue");
            }
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner scanner = new Scanner(System.in);

        // Input phase
        System.out.print("Enter the number of elements to be added: ");
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the element: ");
            int data = scanner.nextInt();
            queue.enqueue(data);
        }

        // Display after insertion
        System.out.print("After insertion: ");
        queue.display();

        // Dequeue phase
        System.out.print("Enter the number of elements to be deleted: ");
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            queue.dequeue();
        }

        // Display after deletion
        System.out.print("After deletion: ");
        queue.display();

        // Print first and last elements
        if (queue.front != queue.rear) {
            System.out.println("The first element in the queue is: " + queue.arr[queue.front + 1]);
            System.out.println("The last element in the queue is: " + queue.arr[queue.rear]);
        }

        scanner.close();
    }
}
