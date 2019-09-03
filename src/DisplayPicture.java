import javax.swing.*;
import java.awt.*;

public class DisplayPicture {

    JFrame window;
    Container container;
    JPanel picturePanel;
    JLabel pictureLabel;
    ImageIcon image;


    public static void main(String[] args) {

        new DisplayPicture();
    }

    public DisplayPicture() {

        //Setting up a new window
        window = new JFrame();
        window.setSize(1080, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.BLACK);
        window.setLayout(null);
        container = window.getContentPane();

        //Setting up a new JPanel
        picturePanel = new JPanel();
        picturePanel.setBounds(150, 100, 500, 300);
        picturePanel.setBackground(Color.BLACK);
        container.add(picturePanel);

        image = new ImageIcon(".//res//test_image.jpg");

        pictureLabel = new JLabel();
        pictureLabel.setIcon(image);
        picturePanel.add(pictureLabel);






        window.setVisible(true);

    }
}
