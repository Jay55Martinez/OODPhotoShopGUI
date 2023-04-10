package view;

import java.awt.event.ActionListener;

/**
 * This interface represents a view.
 */
public interface IView {

  /**
   * This method triggers the animation.
   */
  public void display();

  /**
   * This method gives the view a listener.
   * @param listener a listener object.
   */
  public void setListener(ActionListener listener);

  /**
   * This method the visibility of a panel.
   * @param visible true if visible false if not visible.
   */
  public void setVisible(boolean visible);
}
