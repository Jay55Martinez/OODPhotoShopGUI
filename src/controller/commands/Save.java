package controller.commands;

import java.io.IOException;

import controller.IController;
import iohandler.IOHandlerFactory;
import iohandler.IIOHandler;

/**
 * Class for save command implements the PhotoControllerCommand interface.
 */
public class Save implements PhotoControllerCommand {
  private String imageName;
  private String filePath;

  /**
   * Constructor for the save command. Saves the image with the given name to the user computers.
   *
   * @param args the arguments for the command.
   */
  public Save(String[] args) {
    this.filePath = args[1];
    this.imageName = args[2];
  }


  @Override
  public void execute(IController controller) {
    try {
      //factory returns the corresponding IOHandler based on the image file extension
      IIOHandler handler = new IOHandlerFactory().createIOHandler(filePath);
      handler.save(filePath, controller.getImage(imageName));
    }
    catch (IllegalArgumentException e) {
      e.getMessage();
    } catch (IOException e) {
      e.getMessage();
    }
  }
}
