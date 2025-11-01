
import javax.swing.JOptionPane;


public class NameCardGUI {

    public static void main(String[] args) {
        
        
        String name = "";
        String title = "LEI YU XIANG ";
        String email = "a0905726798@gmail.com";
        String university = "CHU";
        String message = "<html>" +
                         "<h2>" + name + "</h2>" + 
                         "<p><b>職稱:</b> " + title + "</p>" +  
                         "<p><b>學校:</b> " + university + "</p>" +
                         "<p><b>Email:</b> " + email + "</p>" +
                         "</html>";
            JOptionPane.showMessageDialog(
            null,                  
            message,                
            "我的個人名片",             
            JOptionPane.INFORMATION_MESSAGE 
        );
    }
}