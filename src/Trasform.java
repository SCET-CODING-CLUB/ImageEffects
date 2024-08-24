// import java.awt.*;
import java.awt.image.BufferedImage;

public final class Trasform {

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

                r = (r / count);
                g = (g / count);
                b = (b / count);

                int[] argb = IOImage.getRGB(image, x, y);
                IOImage.setRGB(output, x, y, argb[0], r, g, b);
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
        
        // TODO
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(
        w, h, BufferedImage.TYPE_INT_ARGB);

        for (int y = 0; y < h; y++){
            for (int x = 0; x < w; x++){

                int[] argbSrc = IOImage.getRGB(image, x, y);
                int[] argbOut;
                
                int redX = x+rDirX*offset;
                int redY = y+rDirY*offset;
                if (redX >= 0 && redX < w && redY >= 0 && redY < h){
                    argbOut = IOImage.getRGB(output, redX, redY);
                    IOImage.setRGB(output, redX, redY, argbOut[0], argbSrc[1], argbOut[2], argbOut[3]);
                }
                
                int greenX = x+gDirX*offset;
                int greenY = y+gDirY*offset;
                if (greenX >= 0 && greenX < w && greenY >= 0 && greenY < h){
                    argbOut = IOImage.getRGB(output, greenX, greenY);
                    IOImage.setRGB(output, greenX, greenY, argbOut[0], argbOut[1], argbSrc[2], argbOut[3]);
                }
                
                int blueX = x+bDirX*offset;
                int blueY = y+bDirY*offset;
                if (blueX >= 0 && blueX < w && blueY >= 0 && blueY < h){
                    argbOut = IOImage.getRGB(output, blueX, blueY);
                    IOImage.setRGB(output, blueX, blueY, argbOut[0], argbOut[1], argbOut[2], argbSrc[3]);
                }

            }
        }

        return output;

    }

}
