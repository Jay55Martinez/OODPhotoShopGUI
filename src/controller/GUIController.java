package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import controller.commands.Brighten;
import controller.commands.Filter;
import controller.commands.FlipHorizontal;
import controller.commands.FlipVertically;
import controller.commands.GrayscaleComponent;
import controller.commands.Load;
import controller.commands.PhotoControllerCommand;
import controller.commands.Save;
import controller.commands.Transformation;
import model.IPhotoModel;
import model.Pixel;
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
import view.GUIAbstract;

/**
 * This is a class that initialize the application with a GUI for friendly interactions.
 */
public class GUIController implements IController, ActionListener {

  private Map<String, Pixel[][]> storedImages;
  private String address;
  private GUIAbstract view;
  private boolean initialized = false;

  /**
   * Constructor takes in a Readable and Appendable which determines the destination for the
   * Scanners input/output.
   *
   * @param model Model.
   */
  public GUIController(IPhotoModel model, GUIAbstract view) {
    if (model == null) {
      throw new IllegalArgumentException("constructors can not be null");
    }
    this.storedImages = new HashMap<String, Pixel[][]>();

    this.view = view;
  }

  /**
   * this constructor is used to tes.
   *
   * @param model model.
   * @param view  view.
   * @param image the image provided as 2D array of pixels.
   */
  public GUIController(IPhotoModel model, GUIAbstract view, Pixel[][] image) {
    if (model == null) {
      throw new IllegalArgumentException("constructors can not be null");
    }
    this.storedImages = new HashMap<String, Pixel[][]>();

    this.view = view;
    this.view.setListener(this);
    this.view.display();
    this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.view.setVisible(true);

    String[] arg = new String[3];
    arg[0] = "load";
    arg[1] = this.address;
    arg[2] = "image" + (this.storedImages.size() + 1);
    this.storeImage(arg[2], image);
    this.view.setImage(this.storedImages.get(arg[2]));
    this.view.setListener(this);
    //this.sendMap(this.view);
    this.view.setCurrentAddress(arg[2]);
    this.initialized = true;
  }

  // this method is used to set the map to an array.
  private ArrayList<String> setMapToArray() {
    ArrayList<String> list = new ArrayList<String>();
    for (String key : this.storedImages.keySet()) {
      list.add(key);
    }
    return list;
  }


  @Override
  public void execute() throws IllegalArgumentException {
    this.view.setListener(this);
    this.view.display();
    this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.view.setVisible(true);
  }

  @Override
  public void storeImage(String imageName, Pixel[][] image) {
    storedImages.put(imageName, image);
  }

  @Override
  public Pixel[][] getImage(String imageName) {
    return this.storedImages.get(imageName);
  }

  // this method refreshes the view when a new image is loaded.
  private void actionRefresh(PhotoControllerCommand pcmd, String imageName) {
    pcmd.execute(this);
    this.view.setImage(this.storedImages.get(imageName));
    this.view.setListener(this);
    this.view.setCurrentAddress(imageName);
    this.view.display();
    this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.view.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "load":
        final JFileChooser fchooser = new JFileChooser(".");
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "JPG, PPM, PNG, & BMP Images", "jpg", "png", "bmp", "ppm");
        fchooser.setFileFilter(filter);
        int retvalue = fchooser.showOpenDialog(this.view);
        if (retvalue == JFileChooser.APPROVE_OPTION) {
          File f = fchooser.getSelectedFile();
          this.address = f.getAbsolutePath();
        }
        String[] arg = new String[3];
        arg[0] = "load";
        arg[1] = this.address;
        arg[2] = "image" + (this.storedImages.size() + 1);
        Load l = new Load(arg);
        l.execute(this);
        this.view.setImage(this.storedImages.get(arg[2]));
        this.view.setListener(this);
        this.view.setCurrentAddress(arg[2]);
        this.view.display();
        this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.view.setVisible(true);
        this.initialized = true;
        break;
      case "save":
        if (initialized) {
          String[] formats = new String[]{"jpg", "png", "bmp", "ppm"};
          String formatSelected = (String) JOptionPane.showInputDialog(
                  this.view, "Select a format to save", "formats",
                  JOptionPane.INFORMATION_MESSAGE, null, formats, formats[0]);
          String[] argsave = new String[3];
          argsave[0] = "save";
          argsave[1] = this.view.getCurrentAddress() + "." + formatSelected;
          argsave[2] = this.view.getCurrentAddress();
          Save save = new Save(argsave);
          save.execute(this);
        }
        break;
      case "brighten":
        if (initialized) {
          String bright = JOptionPane.showInputDialog("Enter an increase in brightness (0-255)");
          try {
            int brightInt = Integer.parseInt(bright);
            String[] argbright = new String[4];
            argbright[0] = "brighten";
            argbright[1] = bright;
            argbright[2] = this.view.getCurrentAddress();
            argbright[3] = "image" + (this.storedImages.size() + 1) + "brighten";
            Brighten brighten = new Brighten(argbright);
            this.actionRefresh(brighten, argbright[3]);
          } catch (NumberFormatException noNumber) {
            JOptionPane.showMessageDialog(this.view, "Please enter a number (0-255)",
                    "please enter a number (0-255)", JOptionPane.ERROR_MESSAGE);
          }
        }
        break;
      case "darken":
        if (initialized) {
          String bright = JOptionPane.showInputDialog("Enter a decrease in brightness (0-255)");
          try {
            int brightInt = Integer.parseInt(bright) * -1;
            String[] argbright = new String[4];
            argbright[0] = "brighten";
            argbright[1] = brightInt + "";
            argbright[2] = this.view.getCurrentAddress();
            argbright[3] = "image" + (this.storedImages.size() + 1) + "brighten";
            Brighten brighten = new Brighten(argbright);
            this.actionRefresh(brighten, argbright[3]);
          } catch (NumberFormatException noNumber) {
            JOptionPane.showMessageDialog(this.view, "Please enter a number (0-255)",
                    "please enter a number (0-255)", JOptionPane.ERROR_MESSAGE);
          }
        }
        break;
      case "horizontal-flip":
        if (initialized) {
          String[] argh = new String[3];
          argh[0] = "horizontal-flip";
          argh[1] = this.view.getCurrentAddress();
          argh[2] = "image" + (this.storedImages.size() + 1) + "horizontal-flip";
          FlipHorizontal fh = new FlipHorizontal(argh);
          this.actionRefresh(fh, argh[2]);
        }
        break;
      case "vertical-flip":
        if (initialized) {
          String[] argv = new String[3];
          argv[0] = "vertical-flip";
          argv[1] = this.view.getCurrentAddress();
          argv[2] = "image" + (this.storedImages.size() + 1) + "vertical-flip";
          FlipVertically fv = new FlipVertically(argv);
          this.actionRefresh(fv, argv[2]);
        }
        break;
      case "value-component":
        if (initialized) {
          String[] argvc = new String[3];
          argvc[0] = "value-component";
          argvc[1] = this.view.getCurrentAddress();
          argvc[2] = "image" + (this.storedImages.size() + 1) + "value-component";
          GrayscaleComponent vc = new GrayscaleComponent(argvc, new Value());
          this.actionRefresh(vc, argvc[2]);
        }
        break;
      case "luma-component":
        if (initialized) {
          String[] arglc = new String[3];
          arglc[0] = "luma-component";
          arglc[1] = this.view.getCurrentAddress();
          arglc[2] = "image" + (this.storedImages.size() + 1) + "luma-component";
          GrayscaleComponent lc = new GrayscaleComponent(arglc, new Luma());
          this.actionRefresh(lc, arglc[2]);
        }
        break;
      case "intensity-component":
        if (initialized) {
          String[] argic = new String[3];
          argic[0] = "intensity-component";
          argic[1] = this.view.getCurrentAddress();
          argic[2] = "image" + (this.storedImages.size() + 1) + "intensity-component";
          GrayscaleComponent ic = new GrayscaleComponent(argic, new Intensity());
          this.actionRefresh(ic, argic[2]);
        }
        break;
      case "red-component":
        if (initialized) {
          String[] argrc = new String[3];
          argrc[0] = "red-component";
          argrc[1] = this.view.getCurrentAddress();
          argrc[2] = "image" + (this.storedImages.size() + 1) + "red-component";
          GrayscaleComponent rc = new GrayscaleComponent(argrc, new Red());
          this.actionRefresh(rc, argrc[2]);
        }
        break;
      case "green-component":
        if (initialized) {
          String[] arggc = new String[3];
          arggc[0] = "green-component";
          arggc[1] = this.view.getCurrentAddress();
          arggc[2] = "image" + (this.storedImages.size() + 1) + "green-component";
          GrayscaleComponent gc = new GrayscaleComponent(arggc, new Green());
          this.actionRefresh(gc, arggc[2]);
        }
        break;
      case "blue-component":
        if (initialized) {
          String[] argbc = new String[3];
          argbc[0] = "blue-component";
          argbc[1] = this.view.getCurrentAddress();
          argbc[2] = "image" + (this.storedImages.size() + 1) + "blue-component";
          GrayscaleComponent bc = new GrayscaleComponent(argbc, new Blue());
          this.actionRefresh(bc, argbc[2]);
        }
        break;
      case "filter-blur":
        if (initialized) {
          String[] argfb = new String[3];
          argfb[0] = "filter-blur";
          argfb[1] = this.view.getCurrentAddress();
          argfb[2] = "image" + (this.storedImages.size() + 1) + "filter-blur";
          Filter b = new Filter(argfb, new Blur());
          this.actionRefresh(b, argfb[2]);
        }
        break;
      case "filter-sharpen":
        if (initialized) {
          String[] argfs = new String[3];
          argfs[0] = "filter-sharpen";
          argfs[1] = this.view.getCurrentAddress();
          argfs[2] = "image" + (this.storedImages.size() + 1) + "filter-sharpen";
          Filter s = new Filter(argfs, new Sharpen());
          this.actionRefresh(s, argfs[2]);
        }
        break;
      case "greyscale":
        if (initialized) {
          String[] arggs = new String[3];
          arggs[0] = "greyscale";
          arggs[1] = this.view.getCurrentAddress();
          arggs[2] = "image" + (this.storedImages.size() + 1) + "greyscale";
          Transformation g = new Transformation(arggs, new GreyScale());
          this.actionRefresh(g, arggs[2]);
        }
        break;
      case "sepia":
        if (initialized) {
          String[] argsp = new String[3];
          argsp[0] = "sepia";
          argsp[1] = this.view.getCurrentAddress();
          argsp[2] = "image" + (this.storedImages.size() + 1) + "sepia";
          Transformation sp = new Transformation(argsp, new SepiaTone());
          this.actionRefresh(sp, argsp[2]);
        }
        break;
      case "versions":
        if (initialized) {
          ArrayList<String> versions = this.setMapToArray();
          String[] selection = versions.toArray(new String[versions.size()]);
          String version = (String) JOptionPane.showInputDialog(
                  this.view, "Select a version to work on", "versions",
                  JOptionPane.INFORMATION_MESSAGE, null, selection, selection[0]);
          if (version != null) {
            this.view.setImage(this.storedImages.get(version));
            this.view.setListener(this);
            this.view.setCurrentAddress(version);
            this.view.display();
            this.view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.view.setVisible(true);
          }
        }
        break;
      default:
        throw new IllegalArgumentException("how did we even get here?!");
    }
  }
}
