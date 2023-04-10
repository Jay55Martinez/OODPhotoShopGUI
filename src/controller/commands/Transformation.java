package controller.commands;

import java.util.function.Function;

import controller.IController;
import model.DefaultPhotoModel;
import model.Pixel;

/**
 * This class represents the transformation command.
 */
public class Transformation implements PhotoControllerCommand {

  private String imageName;
  private String newImageName;
  private Function<Pixel, Pixel> f;

  /**
   * Constructor for the FlipVertically command.
   *
   * @param args the arguments for the command.
   */
  public Transformation(String[] args, Function<Pixel, Pixel> f) {
    this.imageName = args[1];
    this.newImageName = args[2];
    this.f = f;
  }

  @Override
  public void execute(IController controller) {
    DefaultPhotoModel model = new DefaultPhotoModel(controller.getImage(imageName));
    controller.storeImage(newImageName, model.applyTransformation(f));
  }
}
