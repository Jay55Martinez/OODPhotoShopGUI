package controller.commands;

import controller.IController;
import model.DefaultPhotoModel;

/**
 * Class that represents a command to flip an image vertically used in the photoController.
 */
public class FlipVertically implements PhotoControllerCommand {
  private String imageName;
  private String newImageName;

  /**
   * Constructor for the FlipVertically command.
   *
   * @param args the arguments for the command.
   */
  public FlipVertically(String[] args) {
    this.imageName = args[1];
    this.newImageName = args[2];
  }

  @Override
  public void execute(IController controller) {
    // flips the given image name vertically and saves it as a new name.
    DefaultPhotoModel model = new DefaultPhotoModel(controller.getImage(imageName));
    controller.storeImage(newImageName, model.flipVer());
  }
}
