package iohandler;

import java.io.IOException;

import model.Pixel;

/**
 * Interface for handling the Input/Output (load/write) for a specific file type.
 */
public interface IIOHandler {

  /**
   * load method loads the specified file into the program as a 2d array of pixels.
   *
   * @param imageFile file path of image
   * @return 2d array of pixels
   */
  public Pixel[][] load(String imageFile) throws IOException;

  /**
   * saves the given image to the specified file path on the users computer.
   *
   * @param path  destination for the saved file
   * @param image image that will be saved
   */
  public void save(String path, Pixel[][] image) throws IOException;

  /**
   * Returns the type of IOHandler that this is.
   *
   * @return A String representing the type of IOHandler.
   */
  public String getType();
}
