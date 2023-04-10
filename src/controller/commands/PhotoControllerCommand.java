package controller.commands;

import controller.IController;

/**
 * Interface for the command design pattern represents a command used in the photoController.
 */
public interface PhotoControllerCommand {

  /**
   * Used to execute the command for the image.
   */
  void execute(IController controller);
}
