import java.util.LinkedList;
import java.util.Queue;

public class EX_04_QueueTemplate {

    public static void main(String[] args) {
        // 1. Declare a Queue using the LinkedList implementation.
        // Queue is the interface; LinkedList is the concrete class.
        Queue<String> customerQueue = new LinkedList<>();

        System.out.println("--- 1. Adding Elements (Enqueue) ---");

        // 2. Add elements to the end of the queue (Enqueue)
        // offer() is generally preferred over add() in a queue because it handles capacity-restricted queues gracefully.
        customerQueue.offer("Alice");
        customerQueue.offer("Bob");
        customerQueue.offer("Charlie");
        customerQueue.offer("David");

        System.out.println("Current Queue: " + customerQueue); // [Alice, Bob, Charlie, David]

        // 3. Examine the head of the queue (Peek)
        // element() or peek() retrieves, but does not remove, the head.
        // peek() is safer as it returns null if the queue is empty.
        String nextCustomer = customerQueue.peek();
        System.out.println("\n--- 2. Peeking at the Head ---");
        System.out.println("Next customer to be served (Peek): " + nextCustomer);

        // 4. Remove the head of the queue (Dequeue - FIFO)
        // remove() or poll() retrieves and removes the head.
        // poll() is safer as it returns null if the queue is empty.
        String servedCustomer1 = customerQueue.poll();
        String servedCustomer2 = customerQueue.poll();
        
        System.out.println("\n--- 3. Removing Elements (Dequeue) ---");
        System.out.println("Served Customer 1 (Poll): " + servedCustomer1);
        System.out.println("Served Customer 2 (Poll): " + servedCustomer2);
        
        System.out.println("Queue after serving: " + customerQueue); // [Charlie, David]

        // 5. Check if the queue is empty
        System.out.println("\n--- 4. Queue Status ---");
        System.out.println("Is the queue empty? " + customerQueue.isEmpty());
        System.out.println("Current queue size: " + customerQueue.size());

        System.out.println("\nFollowings are displayed by FOR loop");
        for (String customer : customerQueue) {
            System.out.println("Waiting Customer: " + customer);
        }            
    }
}
