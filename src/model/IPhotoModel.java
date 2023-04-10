package model;

import java.util.function.Function;

/**
 * This interface represents a model that stores versions of images and can be used to edit a photo.
 */
public interface IPhotoModel {

  /**
   * Flips the image through the y-axis.
   */
  public Pixel[][] flipHor();

  /**
   * Flips the image through the x-axis.
   */
  public Pixel[][] flipVer();

  /**
   * Increases the values of R, G, and B to make the image brighter by the given amount.
   * If the amount is negative, the image will be darkened.
   */
  public Pixel[][] brighten(int level);

  /**
   * Transforms the image into a scale of grays using the given function to determine which
   * component of the pixel to use.
   */
  public Pixel[][] grayScale(Function<Pixel, Pixel> component);

  /**
   * Returns the working image.
   */
  public Pixel[][] getImage();

}
