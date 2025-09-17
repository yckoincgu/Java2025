public class J01_Hello {
    // Main.java (JDK 24 preview features may require flags)

/*

(A)　Algorithm for "Hello, World!"
    1. Start: The program begins execution.
    2. Define a Class: Create a container (a class) to hold the program's code. 
       Name it something descriptive, like HelloWorld.
    3. Define the Main Method: Inside the class, create a special method named main. 
       This is the designated starting point where the Java Virtual Machine (JVM) 
        will begin running the program's instructions.
    4. Print a Message: Within the main method, 
       issue a command to display the string "Hello, World!" on the console.
End: The program completes its task and terminates.

This algorithm outlines the fundamental logical flow required for the most basic Java program. The actual code would then implement these steps using Java's specific syntax.
     
（Ｂ）pseudo code for Java hello world program

    1. BEGIN 
    2.  Define a class to hold the program's code.
        CLASS HelloWorld
    3.      Define the main method, which is the starting point of the program.
            METHOD main(STRING array of arguments)
                // Print the text "Hello, World!" to the console.
                PRINT "Hello, World!"
            END METHOD
        END CLASS
    END
    
(C) The definition of the class and method, as well as the print statement,
    would be implemented using Java's specific syntax in the actual code.
    The declaration of the class and method provide the name and type information, 
    allowing the compiler to know that the entity exists

     */
    
    public static void main(String[] args) {
        System.out.println();
        System.out.println("Running on JDK " + Runtime.version());
        int number = 42;
        System.out.println("Hello, World! The answer is " + number);
    }

}
