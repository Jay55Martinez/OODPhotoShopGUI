package iohandler;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.Pixel;

/**
 * class handles png file input output.
 */
public class PngIOHandler extends AIOHandler {

  @Override
  public void save(String path, Pixel[][] image) throws IOException {
    BufferedImage output =
            new BufferedImage(image.length, image[0].length, BufferedImage.TYPE_INT_ARGB);
    WritableRaster raster = output.getRaster();
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        int[] png = new int[4];
        png[0] = image[row][col].getRed();
        png[1] = image[row][col].getGreen();
        png[2] = image[row][col].getBlue();
        png[3] = 255;
        raster.setPixel(row, col, png);
      }
    }
    File outputFile = new File(path);
    ImageIO.write(output, "png", outputFile);
  }

  @Override
  public String getType() {
    return "png";
  }

}
