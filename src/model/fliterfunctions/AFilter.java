package model.fliterfunctions;

import java.util.function.Function;

import model.Pixel;

/**
 * Abstract class for applying different filters to an image. Implements the function class.
 */
public abstract class AFilter implements Function<Pixel[][], Pixel[][]> {

  @Override
  abstract public Pixel[][] apply(Pixel[][] image);

  /**
   * Applies the given filter to the image.
   *
   * @param filter 2d array of floats
   * @param image  2d array of pixels
   * @return new 2d array of pixels
   */
  public Pixel[][] runFilter(float[][] filter, Pixel[][] image) {
    Pixel[][] newImage = new Pixel[image.length][image[0].length];
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        int newRed = 0;
        int newGreen = 0;
        int newBlue = 0;
        for (int filterRow = 0; filterRow < filter.length; filterRow++) {
          for (int filterCol = 0; filterCol < filter[0].length; filterCol++) {
            int rowFetch = row + filterRow - 1;
            int colFetch = col + filterCol - 1;
            if (rowFetch < 0 || rowFetch >= image.length) {
              break;
            } else if (colFetch >= 0 && colFetch < image[0].length) {
              newRed += image[rowFetch][colFetch].getRed() * filter[filterRow][filterCol];
              newGreen += image[rowFetch][colFetch].getGreen() * filter[filterRow][filterCol];
              newBlue += image[rowFetch][colFetch].getBlue() * filter[filterRow][filterCol];
            }
          }
        }
        if (newRed > 255) {
          newRed = 255;
        } else if (newRed < 0) {
          newRed = 0;
        }
        if (newGreen > 255) {
          newGreen = 255;
        } else if (newGreen < 0) {
          newGreen = 0;
        }
        if (newBlue > 255) {
          newBlue = 255;
        } else if (newBlue < 0) {
          newBlue = 0;
        }
        newImage[row][col] = new Pixel(newRed, newGreen, newBlue);
      }
    }
    return newImage;
  }
}
