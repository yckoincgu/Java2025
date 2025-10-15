import java.util.ArrayDeque;
import java.util.Deque;

public class EX_05_Stack {

    public static void main(String[] args) {
        // 1. Declare a Deque and use ArrayDeque for the LIFO stack behavior
        Deque<String> documentHistory = new ArrayDeque<>();

        System.out.println("--- 1. Pushing (Adding) Elements (LIFO) ---");
        
        // 2. Add elements to the top of the stack (Push)
        documentHistory.push("Document A");
        documentHistory.push("Document B");
        documentHistory.push("Document C"); // Last one in

        System.out.println("Current Stack (Top to Bottom): " + documentHistory); 
        // Note: The toString() output might look like a Queue, but the push/pop methods enforce LIFO.
        // Output usually shows: [Document C, Document B, Document A]

        // 3. Examine the top element (Peek)
        String topDocument = documentHistory.peek();
        System.out.println("\n--- 2. Peeking at the Top ---");
        System.out.println("Document currently at the top (Peek): " + topDocument);

        // 4. Remove the top element (Pop - LIFO)
        String removedDocument1 = documentHistory.pop(); // Removes C
        String removedDocument2 = documentHistory.pop(); // Removes B
        
        System.out.println("\n--- 3. Popping (Removing) Elements ---");
        System.out.println("Document removed first (Pop): " + removedDocument1);
        System.out.println("Document removed second (Pop): " + removedDocument2);
        
        System.out.println("Stack after two pops: " + documentHistory); // Only Document A remains
        
        // 5. Check if the stack is empty
        System.out.println("\n--- 4. Stack Status ---");
        System.out.println("Is the stack empty? " + documentHistory.isEmpty());
    }
}