import java.util.HashMap;
import java.util.Map;

public class _01JavaDataTypes01EscapeSymbols {

    public static void main(String[] args) {
        System.out.println("--- Common Java 'char' Unicode Values and Symbols ---\n");

        // Define the table header
        String headerFormat = "│ %-10s │ %-17s │ %-6s │ %-50s │%n";
        String rowFormat =    "│ %-10s │ %-17d │ %-6s │ %-50s │%n";
        String separator =    "├-----------─┼-------------------┼--------┼────────────────────────────────────────────────────┤%n";

        System.out.printf(headerFormat, "Unicode", "Code point (Dec)", "Symbol", "Description");
        System.out.printf(separator);

        // Data for the table
        // We'll store this in a Map for easy iteration and to define specific char points
        // The key is the char's decimal value, and the value is its description
        Map<Integer, String> charData = new HashMap<>();
        charData.put(0x0000, "Null character (NUL)");
        charData.put(0x0001, "Start of Heading (SOH) - unprintable");
        charData.put(0x0007, "Bell character (BEL)");
        charData.put(0x0008, "Backspace (BS)");
        charData.put(0x0009, "Horizontal Tab (HT)");
        charData.put(0x000A, "Line Feed (LF)");
        charData.put(0x000B, "Vertical Tab (VT)");
        charData.put(0x000C, "Form Feed (FF)");
        charData.put(0x000D, "Carriage Return (CR)");
        charData.put(0x001B, "Escape character (ESC) - unprintable");
        charData.put(0x0020, "Space");
        charData.put(0x0021, "Exclamation Mark");
        charData.put(0x002A, "Asterisk");
        charData.put(0x0030, "Digit Zero");
        charData.put(0x0039, "Digit Nine");
        charData.put(0x0041, "Uppercase Latin Letter A");
        charData.put(0x005A, "Uppercase Latin Letter Z");
        charData.put(0x0061, "Lowercase Latin Letter A");
        charData.put(0x007A, "Lowercase Latin Letter Z");
        charData.put(0x007F, "Delete (DEL) - unprintable");
        charData.put(0x00A2, "Cent Sign");
        charData.put(0x00AE, "Registered Sign");
        charData.put(0x00B1, "Plus-Minus Sign");
        charData.put(0x00DF, "Latin Small Letter Sharp S (Eszett)");
        charData.put(0x03A3, "Greek Capital Letter Sigma");
        charData.put(0x042F, "Cyrillic Capital Letter Ya");
        charData.put(0x20AC, "Euro Sign");
        charData.put(0x2122, "Trade Mark Sign");
        charData.put(0x221A, "Square Root");
        charData.put(0x2605, "Black Star");
        charData.put(0x2764, "Heavy Black Heart");
        charData.put(0x3042, "Hiragana Letter A");
        charData.put(0x4E00, "CJK Unified Ideograph-One");
        // We'll show MAX_VALUE explicitly
        charData.put((int)Character.MAX_VALUE, "Invalid Code Point (Character.MAX_VALUE)");


        // Iterate through the sorted keys to print in order
        charData.keySet().stream().sorted().forEach(decimalValue -> {
            char symbol = (char) decimalValue.intValue();
            String unicodeEscape = String.format("\\u%04X", decimalValue);

            // Handle unprintable control characters or special cases for display
            String displaySymbol;
            if (decimalValue >= 0x0000 && decimalValue <= 0x001F) {
                // Control characters
                displaySymbol = ""; // Don't print for visual table clarity
                if (decimalValue == 0x0000) displaySymbol = "\\0";
                else if (decimalValue == 0x0008) displaySymbol = "\\b";
                else if (decimalValue == 0x0009) displaySymbol = "\\t";
                else if (decimalValue == 0x000A) displaySymbol = "\\n";
                else if (decimalValue == 0x000D) displaySymbol = "\\r";
            } else if (decimalValue == 0x007F) {
                 displaySymbol = ""; // DEL character
            } else if (decimalValue == 0xFFFE) { // Not a character
                displaySymbol = "";
            } else if (decimalValue == 0xFFFF) { // Not a character / Replacement character usually
                displaySymbol = "�"; // Commonly displayed as replacement char
            }
            else {
                displaySymbol = String.valueOf(symbol);
            }

            System.out.printf(rowFormat,
                    unicodeEscape,
                    decimalValue,
                    displaySymbol,
                    charData.get(decimalValue)
            );
        });

        System.out.printf(separator);
        System.out.println("\nNote: Symbol rendering depends on your console's font support.");
        System.out.println("      Unprintable control characters are shown as blank or specific escape sequences.");
        System.out.println("      Character.MIN_VALUE = \\u0000");
        System.out.println("      Character.MAX_VALUE = \\uFFFF");
    }
}