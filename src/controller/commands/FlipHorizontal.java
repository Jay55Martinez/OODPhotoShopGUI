package controller.commands;

import controller.IController;
import model.DefaultPhotoModel;

/**
 * class FlipHorizontal is a command that flips the image horizontally.
 */
public class FlipHorizontal implements PhotoControllerCommand {

  private String imageName;
  private String newImageName;

  /**
   * Constructor for the FlipHorizontal command.
   *
   * @param args the arguments for the command.
   */
  public FlipHorizontal(String[] args) {
    this.imageName = args[1];
    this.newImageName = args[2];
  }

  @Override
  public void execute(IController controller) {
    // flips the given image name horizontally and saves it as a new name.
    DefaultPhotoModel model = new DefaultPhotoModel(controller.getImage(imageName));
    controller.storeImage(newImageName, model.flipHor());
  }
}
