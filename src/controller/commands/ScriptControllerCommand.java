package controller.commands;

import controller.IController;
import controller.ScriptController;

/**
 * This class represents the script command.
 */
public class ScriptControllerCommand implements PhotoControllerCommand {
  private final String filePath;


  /**
   * Constructor for the FlipVertically command.
   *
   * @param args the arguments for the command.
   */
  public ScriptControllerCommand(String[] args) {
    this.filePath = args[1];
  }

  @Override
  public void execute(IController controller) {
    ScriptController control = new ScriptController(filePath);
    control.execute();
  }
}
