/**
 * 一個在控制台中顯示個人名片的簡單程式。
 */
public class NameCard {

    public static void main(String[] args) {
        
        // --- 請替換成您自己的資訊 ---
        String name = "LEI YU XIANG";
        String title = "大2";
        String email = "a0905726798@gmail.com";
        String university = "CHU";
        // ------------------------------------------

        String border = "+--------------------------------------------------+";
        
        System.out.println(border);
        System.out.println("|");
        System.out.println("|  " + name);
        System.out.println("|  " + title);
        System.out.println("|  " + university);
        System.out.println("|");
        System.out.println("|  Email: " + email);
        System.out.println("|");
        System.out.println(border);
    }
}