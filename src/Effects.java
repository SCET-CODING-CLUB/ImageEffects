// import java.awt.*;
import java.awt.image.BufferedImage;

public final class Effects {

    public static BufferedImage greyscale(BufferedImage image){

        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(
            w, h, BufferedImage.TYPE_INT_ARGB);

        
        // TODO
        return output;

    }
    
    public static BufferedImage boxBlur(BufferedImage image, int size){
        
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(
                    w, h, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < h; y++){
            for (int x = 0; x < w; x++){

                int count = 0;
                int r = 0, g = 0, b = 0;
                for (int yi = y-size; yi < y+size+1; yi++){
                    for (int xi = x-size; xi < x+size+1; xi++){
                        if (yi < 0 || yi >= h || xi < 0 || xi >= w){
                            continue;
                        }

                        int[] argb = IOImage.getRGB(image, xi, yi);
                        r += argb[1];
                        g += argb[2];
                        b += argb[3];
                        count++;
                    }
                }

                int rAvg = (r / count);
                int gAvg = (g / count);
                int bAvg = (b / count);

                int alpha = IOImage.getRGB(image, x, y)[0];
                IOImage.setRGB(output, x, y, alpha, rAvg, gAvg, bAvg);
            }
        }

        return output;
    }

    public static BufferedImage chromaticAberrate(
                            BufferedImage image,
                            int rDirX, int rDirY,
                            int gDirX, int gDirY,
                            int bDirX, int bDirY,
                            int offset){
        
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(
        w, h, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < h; y++){
            for (int x = 0; x < w; x++){

                int red = 0, green = 0, blue = 0;
                
                int redX = x-rDirX*offset;
                int redY = y-rDirY*offset;
                if (redX >= 0 && redX < w && redY >= 0 && redY < h){
                    red = IOImage.getRGB(image, redX, redY)[1];
                }
                
                int greenX = x-gDirX*offset;
                int greenY = y-gDirY*offset;
                if (greenX >= 0 && greenX < w && greenY >= 0 && greenY < h){
                    green = IOImage.getRGB(image, greenX, greenY)[2];
                }
                
                int blueX = x-bDirX*offset;
                int blueY = y-bDirY*offset;
                if (blueX >= 0 && blueX < w && blueY >= 0 && blueY < h){
                    blue = IOImage.getRGB(image, blueX, blueY)[3];
                }

                int alpha = IOImage.getRGB(image, x, y)[0];
                IOImage.setRGB(output, x, y, alpha, red, green, blue);

            }
        }

        return output;

    }

    // add sepia effect by ayaan
    public static BufferedImage sepia(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(
            w, h, BufferedImage.TYPE_INT_ARGB);
            for (int y = 0; y < h; y++)
            {
                for (int x = 0; x < w; x++)
                {
                    int[] rgb = IOImage.getRGB(image, x, y);
                        int red = rgb[1];
                        int green = rgb[2];
                        int blue = rgb[3];
                    
                     int newRed =(int) ( 0.393 * red + 0.769 * green + 0.189 * blue);
                     int newGreen = (int) (0.349 * red + 0.686 * green + 0.168 * blue);
                    int newBlue = (int) (0.272 * red + 0.534 * green + 0.131 * blue);
                    
                    newRed = Math.min(255, Math.max(0, newRed));
                    newGreen = Math.min(255,Math.max(0,  newGreen));
                    newBlue = Math.min(255, Math.max(0, newBlue));

                    
                    IOImage.setRGB(output, x, y, rgb[0], newRed, newGreen, newBlue);
                    

                }
            }
        

        return output;
    }



}
