import javax.swing.JOptionPane;

public class SimpleNameCardPopup {
    public static void main(String[] args) {
        // 建立名片內容
        String nameCard = 
            "╔══════════════════════════════════════╗\n" +
            "║              ★ 個人名片 ★            ║\n" +
            "╠══════════════════════════════════════╣\n" +
            "║  姓名: 丁央倫                        ║\n" +
            "║  學號: b11455001                    ║\n" +
            "║  系所: 資訊工程學系                  ║\n" +
            "║  學校: 中華大學                      ║\n" +
            "║  信箱: ding@example.com              ║\n" +
            "║  電話: 0912-345-678                  ║\n" +
            "╚══════════════════════════════════════╝\n\n" +
            "這是我的Java作業名片程式！";
        
        // 顯示彈出視窗
        JOptionPane.showMessageDialog(
            null,
            nameCard,
            "我的個人名片",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}