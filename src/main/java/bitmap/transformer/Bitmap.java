package bitmap.transformer;

import java.awt.image.BufferedImage;

public class Bitmap {
    private static BufferedImage image;
    private static int width;
    private static int height;

    public Bitmap(BufferedImage image) {
        this.image = image;
        this.width = image.getWidth();
        this.height = image.getHeight();

    }

    public static BufferedImage getImage() {
        return image;
    }


    //this code was taken from
    // https://www.dyclassroom.com/image-processing-project/how-to-convert-a-color-image-into-grayscale-image-in-java
    public static void greyScaleTransform() {
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

    public static void pixelate() {
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

    public static void blackout() {
        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                image.setRGB(x, y, 0);
            }
        }
    }

    public static void doubleSize() {
        int height = image.getHeight();
        height *= 2;
        width *= 2;
    }
}
