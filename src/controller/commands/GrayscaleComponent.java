package controller.commands;

import java.util.function.Function;

import controller.IController;
import model.DefaultPhotoModel;
import model.Pixel;

/**
 * Class for the grayscale commands implements the PhotoControllerCommand interface.
 */
public class GrayscaleComponent implements PhotoControllerCommand {

  private String imageName;
  private String newImageName;
  private Function<Pixel, Pixel> f;

  /**
   * Constructor for the grayscale command takes in a function to determine which components of the
   * pixel to change.
   *
   * @param args the arguments for the command
   * @param f    grayscale function
   */
  public GrayscaleComponent(String[] args, Function<Pixel, Pixel> f) {
    this.imageName = args[1];
    this.newImageName = args[2];
    this.f = f;
  }

  @Override
  public void execute(IController controller) {
    // Grayscales the given image name and saves it as a new name.
    DefaultPhotoModel model = new DefaultPhotoModel(controller.getImage(imageName));
    controller.storeImage(newImageName, model.grayScale(f));
  }

}
