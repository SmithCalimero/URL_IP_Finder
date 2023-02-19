import javax.swing.*;
import java.awt.*;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) {

        //URL IP Finder Program

        //Object for the graphical window
        JFrame jFrame = new JFrame("URL IP Finder Program"); //name of the window
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500, 150);
        jFrame.setLayout(new BorderLayout());
        jFrame.setLocationRelativeTo(null);

        //Label
        JLabel label = new JLabel("Enter URL: ");
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        label.setForeground(Color.DARK_GRAY);

        //Textfield to input the URL
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(250, 30));
        textField.setFont(new Font("Arial", Font.PLAIN, 16));

        //button for the event
        JButton button = new JButton("Find IP");
        button.setPreferredSize(new Dimension(100, 30));
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(45, 138, 224));
        button.setFocusPainted(false);

        //if the button is used
        button.addActionListener(e -> {
            String url = textField.getText();
            try {
                InetAddress ia = InetAddress.getByName(url);
                String ip = ia.getHostAddress();
                JOptionPane.showMessageDialog(jFrame, ip, "IP Address for " + url, JOptionPane.INFORMATION_MESSAGE);
            } catch (UnknownHostException ex) {
                String errorMessage = "Unable to find IP address for " + url + ".\nPlease check the host name or IP address and try again.";
                JOptionPane.showMessageDialog(jFrame, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
                //throw new RuntimeException(ex);
            }
        });

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        panel.add(label);
        panel.add(textField);
        panel.add(button);

        jFrame.add(panel, BorderLayout.CENTER);
        jFrame.setVisible(true);
    }
}