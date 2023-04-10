package controller;

import model.Pixel;

/**
 * Interface for the controller.
 */
public interface IController {

  /**
   * This is the Controller main method that will be used to run the program.
   */
  public void execute() throws IllegalArgumentException;

  /**
   * puts the image into the map of stored images.
   *
   * @param imageName key for the image
   * @param image     content of the image
   */
  public void storeImage(String imageName, Pixel[][] image);

  /**
   * returns the stored image with the corresponding name.
   */
  public Pixel[][] getImage(String imageName);
}
