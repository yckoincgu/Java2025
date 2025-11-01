/**
 * A generic class restricted to types that extend java.lang.Number (Integer, Double, etc.).
 * This is an example of Bounded Generics.
 */
public class NumericBox<T extends Number> { // The 'extends' keyword sets the upper bound

    private T value;

    // Constructor
    public NumericBox(T value) {
        this.value = value;
    }

    // Getter
    public T getValue() {
        return value;
    }

    // Method to double the value. Since T extends Number, we can safely call 
    // methods on the Number class (like doubleValue()).
    public double doubleValue() {
        // We use doubleValue() because the exact type of T is unknown at compile time,
        // but we know it can be converted to a double.
        return value.doubleValue() * 2.0;
    }
    
    // Another method to add the stored value to a number of the same type (T)
    // Note: To perform addition, we must first convert to a primitive type (like double).
    public double add(T other) {
        return this.value.doubleValue() + other.doubleValue();
    }

    // Overriding toString()
    @Override
    public String toString() {
        return "NumericBox<" + value.getClass().getSimpleName() + ">: " + value;
    }

    public static void main(String[] args) {
        
        System.out.println("--- 1. Box for Integer (Extends Number) ---");
        // This is valid: Integer extends Number.
        NumericBox<Integer> integerBox = new NumericBox<>(10);
        System.out.println(integerBox);
        System.out.println("Doubled value: " + integerBox.doubleValue());
        
        // Addition demonstration
        Integer nine = 9;
        System.out.println("Adding " + nine + ": " + integerBox.add(nine)); // 10 + 9 = 19.0

        System.out.println("\n--- 2. Box for Double (Extends Number) ---");
        // This is valid: Double extends Number.
        NumericBox<Double> doubleBox = new NumericBox<>(3.14);
        System.out.println(doubleBox);
        System.out.println("Doubled value: " + doubleBox.doubleValue());
        
        System.out.println("\n--- 3. Demonstrating Bounded Safety ---");
        
        // Uncommenting the line below causes a COMPILE-TIME ERROR:
        // String is NOT a subclass of Number. The bound protects the code!
        // NumericBox<String> stringBox = new NumericBox<>("Error"); 
        // System.out.println("Error check successful."); 
    }
}