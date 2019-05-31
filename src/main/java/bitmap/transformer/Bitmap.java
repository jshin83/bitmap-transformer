package bitmap.transformer;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Bitmap {
    private static BufferedImage image;
    private static int width;
    private static int height;

    public Bitmap(BufferedImage img) {
        image = img;
        width = image.getWidth();
        height = image.getHeight();

    }

    public static BufferedImage getImage() {
        return image;
    }


    // this code was taken from
    // https://www.dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-grayscale-image-in-java
    public void greyScaleTransform() {
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = image.getRGB(x,y);

                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8&0xff);
                int b = p&0xff;

                //calculate average
                int avg = (r+g+b)/3;

                //replace RGB value with avg
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;

                image.setRGB(x, y, p);
            }
        }
    }

    public void pixelate() {
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int p = image.getRGB(x,y);

                int a = (p>>21)&0xff;
                int r = (p>>14)&0xff;
                int g = (p>>6&0xff);
                int b = p&0xff;

                //calculate average
                int avg = (r+g+b)/3;

                //replace RGB value with avg
                p = (a<<21) | (avg<<14) | (avg<<6) | avg;

                image.setRGB(x, y, p);
            }
        }
    }

    public void blackout() {
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                image.setRGB(x, y, 0);
            }
        }
    }

    public void blur() {
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                int random = (int)(Math.random() * 256);
                image.setRGB(x, y, random);
            }
        }
    }

    public void resize() {

        BufferedImage b = new BufferedImage(width * 2, height * 2, image.getType());

        Graphics g = b.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        setImage(b);
    }

    private static void setWidth(int newWidth) {
        width = newWidth;
    }

    private static void setHeight(int newHeight) {
        height = newHeight;
    }

    private static void setImage(BufferedImage newImage) {
        image = newImage;
    }
}
