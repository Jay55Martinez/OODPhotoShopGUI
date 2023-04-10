package controller.commands;

import java.io.IOException;

import controller.IController;
import iohandler.IOHandlerFactory;
import iohandler.IIOHandler;

/**
 * Class that represents a command to load an image used in the photoController.
 */
public class Load implements PhotoControllerCommand {

  private String imageFile;
  private String imageName;

  /**
   * Constructor for the load command.
   *
   * @param args the arguments for the command.
   */
  public Load(String[] args) {
    this.imageFile = args[1];
    this.imageName = args[2];
  }


  @Override
  public void execute(IController controller) {
    try {
      //factory returns the corresponding IOHandler based on the image file extension
      IIOHandler handler = new IOHandlerFactory().createIOHandler(imageFile);
      controller.storeImage(imageName, handler.load(imageFile));
    } catch (IllegalArgumentException e) {
      e.getMessage();
    } catch (IOException e) {
      e.getMessage();
    }
  }
}
