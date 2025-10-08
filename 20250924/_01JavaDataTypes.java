public class _01JavaDataTypes {
public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════════════╗");
        System.out.println("║                   JAVA BASIC DATA TYPES INFO                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════╝");
        System.out.println();
        
        displayHeader();
        displayByteInfo();
        displayShortInfo();
        displayIntInfo();
        displayLongInfo();
        displayFloatInfo();
        displayDoubleInfo();
        displayCharInfo();
        displayBooleanInfo();
        displaySummary();
    }
    
    private static void displayHeader() {
        System.out.println("┌─────────────┬──────────┬──────────────────────────┬──────────────────────────┐");
        System.out.println("│ Data Type   │ Size     │ Minimum Value            │ Maximum Value            │");
        System.out.println("├─────────────┼──────────┼──────────────────────────┼──────────────────────────┤");
    }
    
    private static void displayByteInfo() {
        System.out.printf("│ %-11s │ %2d bytes │ %-24s │ %-24s │\n", 
            "byte", Byte.BYTES, Byte.MIN_VALUE, Byte.MAX_VALUE);
    }
    
    private static void displayShortInfo() {
        System.out.printf("│ %-11s │ %2d bytes │ %-24s │ %-24s │\n", 
            "short", Short.BYTES, Short.MIN_VALUE, Short.MAX_VALUE);
    }
    
    private static void displayIntInfo() {
        System.out.printf("│ %-11s │ %2d bytes │ %-24s │ %-24s │\n", 
            "int", Integer.BYTES, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private static void displayLongInfo() {
        System.out.printf("│ %-11s │ %2d bytes │ %-24s │ %-24s │\n", 
            "long", Long.BYTES, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private static void displayFloatInfo() {
        System.out.printf("│ %-11s │ %2d bytes │ %-24e │ %-24e │\n", 
            "float", Float.BYTES, Float.MIN_VALUE, Float.MAX_VALUE);
    }
    
    private static void displayDoubleInfo() {
        System.out.printf("│ %-11s │ %2d bytes │ %-24e │ %-24e │\n", 
            "double", Double.BYTES, Double.MIN_VALUE, Double.MAX_VALUE);
    }
    
    private static void displayCharInfo() {
        System.out.printf("│ %-11s │ %2d bytes │ %-24d │ %-24d │\n", 
            "char", Character.BYTES, (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        System.out.println("├─────────────┼──────────┼──────────────────────────┼──────────────────────────┤");
        System.out.printf("│ %-11s │ %-8s │ %-25s │ %-24s │\n", 
            "escape char", "", "\\u0000 ('" + Character.MIN_VALUE + "')", 
            "\\uFFFF ('" + Character.MAX_VALUE + "')");
    }
    
    private static void displayBooleanInfo() {
        System.out.println("├─────────────┼──────────┼──────────────────────────┼──────────────────────────┤");
        System.out.printf("│ %-11s │ %-8s │ %-24s │ %-24s │\n", 
            "boolean", "1 bit*", "false", "true");
    }
    
    private static void displaySummary() {
        System.out.println("└─────────────┴──────────┴──────────────────────────┴──────────────────────────┘");
        System.out.println();
        System.out.println("Additional Information:");
        System.out.println("• boolean size is JVM dependent (typically 1 bit in arrays, 1 byte as variable)");
        System.out.println("• char represents Unicode characters (16-bit)");
        System.out.println("• float and double follow IEEE 754 floating-point standard");
        System.out.println();
        
        // Demonstrate actual usage
        System.out.println("Example Values:");
        byte b = 127;
        short s = 32767;
        int i = 2147483647;
        long l = 9223372036854775807L;
        float f = 3.4028235E38f;
        double d = 1.7976931348623157E308;
        char c = 'A';
        boolean bool = true;
        
        System.out.printf("byte example: %d\n", b);
        System.out.printf("short example: %d\n", s);
        System.out.printf("int example: %d\n", i);
        System.out.printf("long example: %d\n", l);
        System.out.printf("float example: %f\n", f);
        System.out.printf("double example: %f\n", d);
        System.out.printf("char example: %c (Unicode: \\u%04x)\n", c, (int) c);
        System.out.printf("boolean example: %b\n", bool);
    }    
}
