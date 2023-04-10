package controller.commands;

import java.util.function.Function;

import controller.IController;
import model.DefaultPhotoModel;
import model.Pixel;

/**
 * Class Filter is a command that applies a filter to the image.
 */
public class Filter implements PhotoControllerCommand {

  private String imageName;
  private String newImageName;
  private Function<Pixel[][], Pixel[][]> f;

  /**
   * Constructor for the filter command takes in a function to determine which filter to
   * apply to the image.
   *
   * @param arg list of commands
   * @param f   filter function
   */
  public Filter(String[] arg, Function<Pixel[][], Pixel[][]> f) {
    this.imageName = arg[1];
    this.newImageName = arg[2];
    this.f = f;
  }

  @Override
  public void execute(IController controller) {
    DefaultPhotoModel model = new DefaultPhotoModel(controller.getImage(imageName));
    controller.storeImage(newImageName, model.applyFilter(f));
  }
}
