// import java.awt.*;
import javax.swing.*;

public class App {

    final static int WIDTH = 600;
    final static int HEIGHT = 600;
    public static void main(String[] args) throws Exception {


        JFrame frame = new JFrame("Image Effects");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setResizable((false));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ImageProcessor imgPro = new ImageProcessor();
        imgPro.requestFocus();

        frame.add(imgPro);
        frame.pack();
        frame.setVisible(true);

    }
}
