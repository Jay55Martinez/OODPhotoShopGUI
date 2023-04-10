package view;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import model.Pixel;

/**
 * Abstract class for the GUI view.
 */
public abstract class GUIAbstract extends JFrame implements IView {

  /**
   * display method for the GUI view.
   */
  public abstract void display();

  /**
   * set the listener for the GUI view.
   *
   * @param listener the listener for the GUI view.
   */
  public abstract void setListener(ActionListener listener);

  /**
   * set the current address for the GUI view.
   */
  public abstract String getCurrentAddress();

  /**
   * set the current address for the GUI view.
   *
   * @param address the current address for the GUI view.
   */
  public abstract void setCurrentAddress(String address);

  /**
   * set the image for the GUI view.
   *
   * @param image the image for the GUI view.
   */
  public abstract void setImage(Pixel[][] image);

}
