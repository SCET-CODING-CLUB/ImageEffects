import java.io.File; 
import java.io.IOException; 
import javax.imageio.ImageIO;
// import java.awt.*;
import java.awt.image.BufferedImage;

public final class IOImage{

    public static BufferedImage loadImage(String fileName) throws IOException{
        
        // File f = new File(getClass().getResource(fileName).getPath());
        File f = new File(fileName);
        BufferedImage image = ImageIO.read(f);
        return image;
    }

    public static int[] getRGB(BufferedImage image, int x, int y){

        int color = image.getRGB(x, y);
        int[] argb = {
            (color >> 3*8) & 0xff, // alpha
            (color >> 2*8) & 0xff, // red
            (color >> 1*8) & 0xff, // green
            color & 0xff           // blue
        };
        return argb;
    }

    public static void setRGB(BufferedImage image, int x, int y, int a, int r, int g, int b){

        int color = (a << 24) | (r << 16) | (g << 8) | b;
        image.setRGB(x, y, color);
    }

}
