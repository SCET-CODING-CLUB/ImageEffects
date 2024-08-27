import java.awt.*;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.util.HashMap;

public class ImageProcessor extends JPanel{

    final static int WIDTH = 600;
    final static int HEIGHT = 600;
    BufferedImage original;
    HashMap<String, BufferedImage> imageMap;
    String selectedEffect = "Original";

    ImageProcessor() throws IOException{
        
        setBackground(Color.lightGray);
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setFocusable(true);

        // image
        {
        original = IOImage.loadImage("./src/test.png");
        BufferedImage boxBlur = Effects.boxBlur(original, 5);
        BufferedImage chromaticAberrate = Effects.chromaticAberrate(
            original, -1, 0,
            0, 1,
            1, 0,
            5);
        BufferedImage sepia = Effects.sepia(original);
        BufferedImage invert = Effects.invert(original);
        BufferedImage greyscale = Effects.greyscale(original);

        imageMap = new HashMap<>();
        imageMap.put(selectedEffect, original);
        imageMap.put("Greyscale", greyscale);
        imageMap.put("Sepia", sepia);
        imageMap.put("Invert", invert);
        imageMap.put("Box Blur", boxBlur);
        imageMap.put("Chromatic Aberrate", chromaticAberrate);
        }

    }

    public Object[] getEffectNames(){
        return imageMap.keySet().toArray();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    void draw(Graphics g){
        g.drawImage(imageMap.get(selectedEffect), 0, 0, null);
    }

}
