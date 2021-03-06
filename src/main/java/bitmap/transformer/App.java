/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package bitmap.transformer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static bitmap.transformer.Bitmap.getImage;

public class App {
    private static String[] classArgs;
    private static Bitmap readImage;
    private static final String[] SET_VALUES = new String[] { "blackout", "blur", "greyScale", "pixelate", "resize" };
    private static final Set<String> functionCalls  = new HashSet<>(Arrays.asList(SET_VALUES));

    public static void main(String[] args) {
        classArgs = args;
        verifyArgs();
    }

    private static void verifyArgs() {
        String transform;
        try {
            if(classArgs.length != 3) {
                throw new Exception("You must send in three arguments - input output transform.");
            }
            if(!functionCalls.contains(classArgs[2])){
                throw new Exception("please call functions from available choices - blackout, blur, greyScale, pixelate, resize");
            }

            readFile(classArgs[0]);
            //methods we could use
            if(classArgs[2].equals("blur")) {
                readImage.blur();
            } else if (classArgs[2].equals("blackout")) {
                readImage.blackout();
            } else if (classArgs[2].equals("greyScale")) {
                readImage.greyScaleTransform();
            }  else if (classArgs[2].equals("resize")) {
                readImage.resize();
            } else {
                readImage.pixelate();
            }

            writeFile(classArgs[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void readFile(String filepath) {
        BufferedImage img;
        //read image
        try{
            File file = new File(filepath);
            System.out.println(file.getPath());
            img = ImageIO.read(file);
            readImage = new Bitmap(img);
        }catch(IOException e){
            System.out.println("Input file path is incorrect or doesn't exist: " + e);
        }
    }

    private static void writeFile(String filepath) {
        try{
            File file = new File(filepath);
            ImageIO.write( getImage(), "bmp", file );
        }catch(IOException e){
            System.out.println("File path is incorrect or doesn't exist: " + e);
        }
    }
}
