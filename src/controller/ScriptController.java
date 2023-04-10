package controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import controller.commands.Filter;
import controller.commands.FlipHorizontal;
import controller.commands.FlipVertically;
import controller.commands.GrayscaleComponent;
import controller.commands.Load;
import controller.commands.PhotoControllerCommand;
import controller.commands.Save;
import controller.commands.Transformation;
import model.colortransformationfunctions.GreyScale;
import model.colortransformationfunctions.SepiaTone;
import model.fliterfunctions.Blur;
import model.fliterfunctions.Sharpen;
import model.grayscalefunctions.Blue;
import model.grayscalefunctions.Green;
import model.grayscalefunctions.Intensity;
import model.grayscalefunctions.Luma;
import model.grayscalefunctions.Red;
import controller.commands.Brighten;
import model.grayscalefunctions.Value;
import model.Pixel;
import iohandler.ImageUtil;

/**
 * Controller class that handles all the operations in the Controller.main method.
 */
public class ScriptController implements IController {
  private final String filePath;

  private Map<String, Pixel[][]> storedImages;

  private String[] parsedCommands;

  /**
   * Constructor for the controller class that takes in a list of commands
   * where to read the input from and where to write the output to.
   *
   * @param filePath the file path to the script file.
   */
  public ScriptController(String filePath) {
    if (filePath == null) {
      throw new IllegalArgumentException();
    }
    this.filePath = filePath;
    this.storedImages = new HashMap<String, Pixel[][]>();
  }

  @Override
  public void storeImage(String imageName, Pixel[][] image) {
    storedImages.put(imageName, image);
  }

  @Override
  public Pixel[][] getImage(String imageName) {
    return storedImages.get(imageName);
  }

  @Override
  public void execute() {
    String scriptContent;
    // reads the script file stores it as a string
    try {
      scriptContent = ImageUtil.readFileToString(this.filePath);
    } catch (FileNotFoundException e) {
      throw new IllegalArgumentException("File not found");
    }
    // adds command functions to a map where the key is the command name
    Map<String, Function<String[], PhotoControllerCommand>> commands = setCommands();
    // splits the script string into an array of strings where each cell is a command
    String[] scriptArray = scriptContent.split("\n", -1);
    this.parsedCommands = new String[scriptArray.length];
    int flag = 0;
    for (String script : scriptArray) {
      // last cell in scriptArray is always empty we know we are done
      if (script.equals("")) {
        return;
      }
      this.parsedCommands[flag] = script;
      flag++;
      // splits each command into an array of strings where each cell is an argument
      String[] arg = script.split(" ", -1);
      // if the command name is not in the map of commands, throw an exception
      Function<String[], PhotoControllerCommand> cmd =
              commands.getOrDefault(arg[0], null);
      if (cmd == null) {
        throw new IllegalArgumentException("Command " + arg[0] + " not found");
      } else {
        PhotoControllerCommand c = cmd.apply(arg);
        c.execute(this);
      }
    }
  }

  // helper method to add commands to the map
  private Map<String, Function<String[], PhotoControllerCommand>> setCommands() {
    HashMap<String, Function<String[], PhotoControllerCommand>> commands = new HashMap<>();
    commands.put("brighten", (String[] arg) -> new Brighten(arg));
    commands.put("horizontal-flip", (String[] arg) -> new FlipHorizontal(arg));
    commands.put("vertical-flip", (String[] arg) -> new FlipVertically(arg));
    commands.put("save", (String[] arg) -> new Save(arg));
    commands.put("load", (String[] arg) -> new Load(arg));
    commands.put("value-component", (String[] arg) -> new GrayscaleComponent(arg, new Value()));
    commands.put("luma-component", (String[] arg) -> new GrayscaleComponent(arg, new Luma()));
    commands.put("intensity-component",
        (String[] arg) -> new GrayscaleComponent(arg, new Intensity()));
    commands.put("red-component", (String[] arg) -> new GrayscaleComponent(arg, new Red()));
    commands.put("green-component", (String[] arg) -> new GrayscaleComponent(arg, new Green()));
    commands.put("blue-component", (String[] arg) -> new GrayscaleComponent(arg, new Blue()));
    commands.put("filter-blur", (String[] arg) -> new Filter(arg, new Blur()));
    commands.put("filter-sharpen", (String[] arg) -> new Filter(arg, new Sharpen()));
    commands.put("greyscale", (String[] arg) -> new Transformation(arg, new GreyScale()));
    commands.put("sepia", (String[] arg) -> new Transformation(arg, new SepiaTone()));
    commands.put("parse-script", (String[] arg) -> new Load(arg));
    return commands;
  }

  /**
   * Gets the parsing of the commands.
   * @return A String array with every command
   */
  public String[] getParsedCommands() {
    String[] copy = new String[this.parsedCommands.length];
    for (int i = 0; i < this.parsedCommands.length; i++) {
      copy[i] = this.parsedCommands[i];
    }
    return copy;
  }
}
