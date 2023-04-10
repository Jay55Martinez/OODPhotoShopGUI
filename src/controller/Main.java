package controller;

import java.io.InputStreamReader;

import model.DefaultPhotoModel;
import model.Pixel;
import view.GUIView;

/**
 * this class contains the main method for the program.
 */
public class Main {

  /**
   * This is the main method for the program.
   *
   * @param args the arguments for the program.
   */
  public static void main(String[] args) {
    IController controller;
    if (args.length == 0) {
      GUIView view = new GUIView();
      view.setImage(new Pixel[0][0]);
      controller = new GUIController(new DefaultPhotoModel(new Pixel[0][0]), view);
    } else {
      switch (args[0]) {
        case "-text":
          controller = new ScannerController(new InputStreamReader(System.in), System.out);
          break;
        case "-file":
          controller = new ScriptController(args[1]);
          break;
        default:
          throw new IllegalArgumentException("Invalid command >:c");
      }
    }
    controller.execute();
  }
}
