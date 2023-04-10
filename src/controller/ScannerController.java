package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

import controller.commands.Brighten;
import controller.commands.Filter;
import controller.commands.FlipHorizontal;
import controller.commands.FlipVertically;
import controller.commands.GrayscaleComponent;
import controller.commands.Load;
import controller.commands.PhotoControllerCommand;
import controller.commands.Save;
import controller.commands.ScriptControllerCommand;
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
import model.grayscalefunctions.Value;
import model.Pixel;

/**
 * Controller class that handles inputs from a Scanner.
 */
public class ScannerController implements IController {

  private Map<String, Pixel[][]> storedImages;
  private final Readable in;

  private final Appendable out;

  /**
   * Constructor takes in a Readable and Appendable which determines the destination for the
   * Scanners input/output.
   *
   * @param in Readable
   */
  public ScannerController(Readable in, Appendable out) {
    if (in == null) {
      throw new IllegalArgumentException("constructors can not be null");
    }
    this.in = in;
    this.out = out;
    this.storedImages = new HashMap<String, Pixel[][]>();
  }


  @Override
  public void execute() throws IllegalArgumentException {
    Scanner scan = new Scanner(this.in);
    Map<String, Function<String[], PhotoControllerCommand>> commands = setCommands();

    while (scan.hasNextLine()) {
      String[] arg = scan.nextLine().split(" ", -1);
      if (arg[0].equalsIgnoreCase("q") || arg[0].equalsIgnoreCase("quit")) {
        break;
      }
      Function<String[], PhotoControllerCommand> cmd = commands.getOrDefault(arg[0], null);
      if (cmd == null) {
        try {
          out.append("not a valid input\n");
        }
        catch (IOException e) {
          e.getMessage();
        }
      } else {
        PhotoControllerCommand c = cmd.apply(arg);
        c.execute(this);
      }
    }
  }

  @Override
  public void storeImage(String imageName, Pixel[][] image) {
    storedImages.put(imageName, image);
  }

  @Override
  public Pixel[][] getImage(String imageName) {
    return this.storedImages.get(imageName);
  }

  // functions for the command design pattern
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
    commands.put("script", (String[] arg) -> new ScriptControllerCommand(arg));
    return commands;
  }

}
