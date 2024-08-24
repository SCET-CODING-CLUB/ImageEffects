import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImageProcessor extends JPanel{

    final static int WIDTH = 600;
    final static int HEIGHT = 600;
    BufferedImage img1, imgBlur, imgAberrate;

    ImageProcessor() throws IOException{
        
        setBackground(Color.darkGray);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        // image
        img1 = IOImage.loadImage("./src/test.png");
        imgBlur = Trasform.boxBlur(img1, 5);
        imgAberrate = Trasform.chromaticAberrate(
            img1, -1, 0,
            0, 1,
            1, 0,
            5);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    void draw(Graphics g){
        g.drawImage(img1, 0, 0, null);
        g.drawImage(imgBlur, 0, 0, null);
        // g.drawImage(imgAberrate, 0, 0, null);
    }

}
