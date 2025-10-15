
public class Ex_01_CopyingCharacters {
    public static void main(String[] args) {
        
        String sentence = "You are welcome.";
        /* sentence is a String object.
         * Once a String object is created, 
         * its contents can never be changed.
         */
        System.out.println("String object: " + sentence);
        System.out.println("Note: A String object\r\n" + 
                        " * Once a String object is created, \r\n" + 
                        " * its contents can never be changed" + sentence);
        System.out.println("(A). Its content will be copied by String method as below.    ");    
        System.out.print("     ");
        for (char c : sentence.toCharArray()) System.out.print(c);
        System.out.println();  
        System.out.println("(B). Its content will be copied char by char as below.    ");
        char[] charArray = new char[sentence.length()];
        for (int i = 0; i < sentence.length(); i++) {
            charArray[i] = sentence.charAt(i);
        }
        System.out.print("     ");
        for (char c : charArray) {
            System.out.print(c);
        }
    }
}
