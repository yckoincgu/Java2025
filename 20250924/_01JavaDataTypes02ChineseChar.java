public class _01JavaDataTypes02ChineseChar {
public static void main(String[] args) {
        String chineseText = "你好世界"; // "Hello World" in Chinese
        System.out.println(chineseText); // Output: 你好世界 
        // Using Unicode escapes
        String hello = "\u4F60\u597D\u4E16\u754C";
        System.out.println(hello); // Output: 你好世界

        System.out.println("compiler hints: javac -encoding UTF-8 <filename.java>"); // Output: 你好世界
    }
}
