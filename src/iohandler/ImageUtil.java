package iohandler;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import model.Pixel;


/**
 * This class contains utility methods to read a PPM image from file and simply print its contents.
 * Feel free to change this method as required.
 */
public class ImageUtil {

  /**
   * Reads the given image file and returns a 2D array of pixels.
   *
   * @param imageFile the path of the file.
   * @return a 2D array of pixels.
   * @throws IOException if the file is not found.
   */
  public static Pixel[][] readImage(String imageFile) throws IOException {
    File file = new File(imageFile);
    BufferedImage image = ImageIO.read(file);
    String[] data = image.getData().toString().split(" ", -1);
    Pixel[][] images = new Pixel[Integer.parseInt(data[3])][Integer.parseInt(data[6])];
    WritableRaster roast = image.getRaster().createWritableChild(0, 0, image.getWidth(),
            image.getHeight(), 0, 0, null);
    for (int row = 0; row < images.length; row++) {
      for (int col = 0; col < images[row].length; col++) {
        int[] rgb = new int[4];
        roast.getPixel(row, col, rgb);
        images[row][col] = new Pixel(rgb[0], rgb[1], rgb[2]);
      }
    }
    return images;
  }

  /**
   * Saves an image in a given format to the user's computer.
   *
   * @param path      the path to the file to be saved.
   * @param image     the 2D String array with the pixels.
   * @param extension the type of the file to be saved.
   * @throws IOException if it is unable to save the file.
   */
  public static void saveImage(String path, Pixel[][] image, String extension) throws IOException {
    BufferedImage output =
            new BufferedImage(image.length, image[0].length, BufferedImage.TYPE_INT_RGB);
    WritableRaster raster = output.getRaster();
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        int[] png = new int[3];
        png[0] = image[row][col].getRed();
        png[1] = image[row][col].getGreen();
        png[2] = image[row][col].getBlue();
        raster.setPixel(row, col, png);
      }
    }
    File outputFile = new File(path);
    ImageIO.write(output, extension.substring(1), outputFile);
  }

  /**
   * This method pareses the file into a string containing the commands.
   *
   * @param fileName The script to be parsed.
   * @return A string containing the commands.
   * @throws FileNotFoundException if the file is not found.
   */
  public static String readFileToString(String fileName) throws FileNotFoundException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(fileName));
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File " + fileName + " not found!");
    }
    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      builder.append(s + System.lineSeparator());
    }
    return builder.toString();
  }

  /**
   * Provides the type of given file.
   *
   * @param filePath the name of the file.
   * @return the type of the file.
   */
  public static String getExtension(String filePath) {
    return filePath.substring(filePath.lastIndexOf('.'));
  }
}

