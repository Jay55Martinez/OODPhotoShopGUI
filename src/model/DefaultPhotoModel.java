package model;

/**
 * This class represents an image as a 2D array of pixels to be edited.
 */
public class DefaultPhotoModel extends AModel {


  /**
   * This constructor takes in the image that will be edited as a 2D array.
   *
   * @param image 2d array of pixels representing an image
   */
  public DefaultPhotoModel(Pixel[][] image) {
    super(image);
  } // constructor
}
