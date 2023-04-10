package controller.commands;

import controller.IController;
import model.DefaultPhotoModel;

/**
 * Brighten class for the command design pattern used to brighten an image.
 */
public class Brighten implements PhotoControllerCommand {

  private String imageName;
  private String newImageName;
  private int amount;

  /**
   * Constructor for the brighten command.
   *
   * @param args the arguments for the command.
   */
  public Brighten(String[] args) {
    this.imageName = args[2];
    this.newImageName = args[3];
    this.amount = Integer.parseInt(args[1]);
  }

  @Override
  public void execute(IController controller) {
    // brightens/darkens the given image name in by the given amount. if the amount is
    // negative it will darken the image. the image will be saved with the given name in
    // the argument and will be referenced by that name going forward.
    DefaultPhotoModel model = new DefaultPhotoModel(controller.getImage(imageName));
    controller.storeImage(newImageName, model.brighten(amount));
  }
}
