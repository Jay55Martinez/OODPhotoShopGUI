package model;

import java.util.function.Function;

/**
 * Interface for photo models with the additional ability to apply filters to images.
 * Extends IPhotoModel.
 */
public interface IPhotoModelFilter extends IPhotoModel {

  /**
   * Applies a filter on the image. A filter is a function object.
   *
   * @param filter function object represents different filters
   * @return new 2d array of Pixels
   */
  public Pixel[][] applyFilter(Function<Pixel[][], Pixel[][]> filter);

  /**
   * Transforms an image to sepia tone through color transformation.
   *
   * @param component the function to convert all pixels to sepia tone.
   * @return the new image as a 2D array of pixels.
   */
  public Pixel[][] applyTransformation(Function<Pixel, Pixel> component);
}
