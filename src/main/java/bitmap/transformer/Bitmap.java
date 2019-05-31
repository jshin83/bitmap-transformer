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
}
