public class _02JavaOperatorsReference {
    
    public static void main(String[] args) {
        displayDataTypesTable();
        System.out.println();
        displayOperatorsReference();
    }
    
    public static void displayDataTypesTable() {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   JAVA BASIC DATA TYPES INFO                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        System.out.println("┌─────────────┬──────────┬──────────────────────────┬──────────────────────────┐");
        System.out.println("│ Data Type   │ Size     │ Minimum Value            │ Maximum Value            │");
        System.out.println("├─────────────┼──────────┼──────────────────────────┼──────────────────────────┤");
        System.out.println("│ byte        │  1 bytes │ -128                     │ 127                      │");
        System.out.println("│ short       │  2 bytes │ -32768                   │ 32767                    │");
        System.out.println("│ int         │  4 bytes │ -2147483648              │ 2147483647               │");
        System.out.println("│ long        │  8 bytes │ -9223372036854775808     │ 9223372036854775807      │");
        System.out.println("│ float       │  4 bytes │ 1.401298e-45             │ 3.402823e+38             │");
        System.out.println("│ double      │  8 bytes │ 4.900000e-324            │ 1.797693e+308            │");
        System.out.println("│ char        │  2 bytes │ 0                        │ 65535                    │");
        System.out.println("├─────────────┼──────────┼──────────────────────────┼──────────────────────────┤");
        System.out.println("│ char range  │          │ \\u0000 ('')              │ \\uFFFF ('?')             │");
        System.out.println("├─────────────┼──────────┼──────────────────────────┼──────────────────────────┤");
        System.out.println("│ boolean     │ 1 bit*   │ false                    │ true                     │");
        System.out.println("└─────────────┴──────────┴──────────────────────────┴──────────────────────────┘");
        
        System.out.println();
        System.out.println("Additional Information:");
        System.out.println("• boolean size is JVM dependent (typically 1 bit in arrays, 1 byte as variable)");
        System.out.println("• char represents Unicode characters (16-bit)");
        System.out.println("• float and double follow IEEE 754 floating-point standard");
    }
    
    public static void displayOperatorsReference() {
        System.out.println("═════════════════════════════════════════════════════════════════════");
        System.out.println("                      JAVA OPERATORS REFERENCE");
        System.out.println("═════════════════════════════════════════════════════════════════════");
        System.out.println();
        
        displayArithmeticOperators();
        displayRelationalOperators();
        displayLogicalOperators();
        displayAssignmentOperators();
        displayBitwiseOperators();
        displayOtherOperators();
        displayOperatorPrecedence();
        displayOperatorExamples();
    }
    
    public static void displayArithmeticOperators() {
        System.out.println("ARITHMETIC OPERATORS:");
        System.out.println("┌──────────┬────────────────────────────────────────────────────────┐");
        System.out.println("│ Operator │ Application                                            │");
        System.out.println("├──────────┼────────────────────────────────────────────────────────┤");
        System.out.println("│ +        │ Addition: a + b                                        │");
        System.out.println("│ -        │ Subtraction: a - b                                     │");
        System.out.println("│ *        │ Multiplication: a * b                                  │");
        System.out.println("│ /        │ Division: a / b                                        │");
        System.out.println("│ %        │ Modulus (remainder): a % b                             │");
        System.out.println("│ ++       │ Increment: a++ or ++a                                  │");
        System.out.println("│ --       │ Decrement: a-- or --a                                  │");
        System.out.println("└──────────┴────────────────────────────────────────────────────────┘");
        System.out.println();
    }
    
    public static void displayRelationalOperators() {
        System.out.println("RELATIONAL OPERATORS (return boolean):");
        System.out.println("┌──────────┬────────────────────────────────────────────────────────┐");
        System.out.println("│ Operator │ Application                                            │");
        System.out.println("├──────────┼────────────────────────────────────────────────────────┤");
        System.out.println("│ ==       │ Equal to: a == b                                       │");
        System.out.println("│ !=       │ Not equal to: a != b                                   │");
        System.out.println("│ >        │ Greater than: a > b                                    │");
        System.out.println("│ <        │ Less than: a < b                                       │");
        System.out.println("│ >=       │ Greater than or equal to: a >= b                       │");
        System.out.println("│ <=       │ Less than or equal to: a <= b                          │");
        System.out.println("└──────────┴────────────────────────────────────────────────────────┘");
        System.out.println();
    }
    
    public static void displayLogicalOperators() {
        System.out.println("LOGICAL OPERATORS (boolean operations):");
        System.out.println("┌──────────┬────────────────────────────────────────────────────────┐");
        System.out.println("│ Operator │ Application                                            │");
        System.out.println("├──────────┼────────────────────────────────────────────────────────┤");
        System.out.println("│ &&       │ Logical AND: (a > b) && (c < d)                        │");
        System.out.println("│ ||       │ Logical OR: (a > b) || (c < d)                         │");
        System.out.println("│ !        │ Logical NOT: !(a == b)                                 │");
        System.out.println("└──────────┴────────────────────────────────────────────────────────┘");
        System.out.println();
    }
    
    public static void displayAssignmentOperators() {
        System.out.println("ASSIGNMENT OPERATORS:");
        System.out.println("┌──────────┬────────────────────────────────────────────────────────┐");
        System.out.println("│ Operator │ Application                                            │");
        System.out.println("├──────────┼────────────────────────────────────────────────────────┤");
        System.out.println("│ =        │ Simple assignment: a = 10                              │");
        System.out.println("│ +=       │ Add and assign: a += 5  →  a = a + 5                   │");
        System.out.println("│ -=       │ Subtract and assign: a -= 3 → a = a - 3                │");
        System.out.println("│ *=       │ Multiply and assign: a *= 2 → a = a * 2                │");
        System.out.println("│ /=       │ Divide and assign: a /= 2 → a = a / 2                  │");
        System.out.println("│ %=       │ Modulus and assign: a %= 3 → a = a % 3                 │");
        System.out.println("└──────────┴────────────────────────────────────────────────────────┘");
        System.out.println();
    }
    
    public static void displayBitwiseOperators() {
        System.out.println("BITWISE OPERATORS:");
        System.out.println("┌──────────┬────────────────────────────────────────────────────────┐");
        System.out.println("│ Operator │ Application                                            │");
        System.out.println("├──────────┼────────────────────────────────────────────────────────┤");
        System.out.println("│ &        │ Bitwise AND: a & b                                     │");
        System.out.println("│ |        │ Bitwise OR: a | b                                      │");
        System.out.println("│ ^        │ Bitwise XOR: a ^ b                                     │");
        System.out.println("│ ~        │ Bitwise complement: ~a                                 │");
        System.out.println("│ <<       │ Left shift: a << 2                                     │");
        System.out.println("│ >>       │ Right shift: a >> 2                                    │");
        System.out.println("│ >>>      │ Unsigned right shift: a >>> 2                          │");
        System.out.println("└──────────┴────────────────────────────────────────────────────────┘");
        System.out.println();
    }
    
    public static void displayOtherOperators() {
        System.out.println("OTHER OPERATORS:");
        System.out.println("┌──────────────┬────────────────────────────────────────────────────┐");
        System.out.println("│ Operator     │ Application                                        │");
        System.out.println("├──────────────┼────────────────────────────────────────────────────┤");
        System.out.println("│ ? :          │ Ternary: result = (a > b) ? a : b                  │");
        System.out.println("│ instanceof   │ Type check: obj instanceof String                  │");
        System.out.println("│ .            │ Member access: object.method()                     │");
        System.out.println("│ []           │ Array access: arr[5]                               │");
        System.out.println("│ (type)       │ Cast: (int) doubleValue                            │");
        System.out.println("│ new          │ Object creation: new String(\"hello\")               │");
        System.out.println("└──────────────┴────────────────────────────────────────────────────┘");
        System.out.println();
    }
    
    public static void displayOperatorPrecedence() {
        System.out.println("OPERATOR PRECEDENCE (Highest to Lowest):");
        System.out.println("1.  () [] . (method call, array access, member access)");
        System.out.println("2.  ++ -- ! ~ (unary operators)");
        System.out.println("3.  * / % (multiplicative)");
        System.out.println("4.  + - (additive)");
        System.out.println("5.  << >> >>> (shift)");
        System.out.println("6.  < > <= >= instanceof (relational)");
        System.out.println("7.  == != (equality)");
        System.out.println("8.  & (bitwise AND)");
        System.out.println("9.  ^ (bitwise XOR)");
        System.out.println("10. | (bitwise OR)");
        System.out.println("11. && (logical AND)");
        System.out.println("12. || (logical OR)");
        System.out.println("13. ? : (ternary)");
        System.out.println("14. = += -= etc. (assignment)");
        System.out.println();
    }
    
    public static void displayOperatorExamples() {
        System.out.println("═════════════════════════════════════════════════════════════════════");
        System.out.println("                      PRACTICAL EXAMPLES");
        System.out.println("═════════════════════════════════════════════════════════════════════");
        System.out.println();
        
        // Arithmetic examples
        int a = 10, b = 3;
        System.out.println("Arithmetic Examples:");
        System.out.println("a = " + a + ", b = " + b);
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        System.out.println();
        
        // Relational examples
        System.out.println("Relational Examples:");
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        System.out.println("a > b: " + (a > b));
        System.out.println();
        
        // Logical examples
        boolean x = true, y = false;
        System.out.println("Logical Examples:");
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));
        System.out.println();
        
        // Assignment examples
        int c = 5;
        System.out.println("Assignment Examples:");
        System.out.println("Initial c = " + c);
        c += 3;
        System.out.println("After c += 3: " + c);
        c *= 2;
        System.out.println("After c *= 2: " + c);
        System.out.println();
        
        // Ternary example
        int score = 75;
        String result = (score >= 60) ? "Pass" : "Fail";
        System.out.println("Ternary Example:");
        System.out.println("Score: " + score + " → Result: " + result);
    }
}