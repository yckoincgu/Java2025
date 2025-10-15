/**
 * Box<T> is a generic class (template class equivalent).
 * The 'T' stands for "Type" and is a type parameter that will be
 * replaced by a concrete type (like String or Integer) when the class is instantiated.
 */
class Box<T> {
    // The content field can hold an object of any type T
    private T content;

    // Constructor accepts a generic type T
    public Box(T content) {
        this.content = content;
    }

    // Generic Getter: returns an object of type T
    public T getContent() {
        return content;
    }

    // Generic Setter: accepts an object of type T
    public void setContent(T content) {
        this.content = content;
    }

    public void displayType() {
        // Prints the actual class type of the content at runtime
        System.out.println("The content type is: " + content.getClass().getName());
    }
}

public class EX_02_GenericClass {
    public static void main(String[] args) {
        
        // 1. Instantiate the Box with a specific type: String
        System.out.println("--- 1. String Box ---");
        Box<String> stringBox = new Box<>("Hello Generics!");
        
        String myString = stringBox.getContent();
        System.out.println("Content: " + myString);
        stringBox.displayType();

        // 2. Instantiate the Box with a different specific type: Integer
        System.out.println("\n--- 2. Integer Box ---");
        Box<Integer> integerBox = new Box<>(42);
        
        Integer myInteger = integerBox.getContent();
        System.out.println("Content: " + myInteger);
        integerBox.displayType();
        
        // 3. Type Safety Demonstration
        // stringBox.setContent(100); // <-- This would cause a compile-time error!
        // The compiler ensures the Box<String> only handles Strings.
    }
}