package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.Objects;
import javax.swing.JPanel;
import model.Pixel;

/**
 * This class represents a panel that displays an image.
 */
public class ImagePanel extends JPanel implements Runnable {
  private final Pixel[][] image;

  /**
   * Constructor takes in an image which will be displayed.
   *
   * @param image image to be displayed
   */
  public ImagePanel(Pixel[][] image) {
    setPreferredSize(new Dimension(700, 700));
    this.image = Objects.requireNonNull(image);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[row].length; col++) {
        Color color = new Color(image[row][col].getRed(), image[row][col].getGreen(),
                image[row][col].getBlue());
        g.setColor(color);
        g.drawRect(row, col, 1, 1);
      }
    }
  }

  @Override
  public void run() {
    this.setUp();
  }

  // helper method for run
  private void setUp() {
    JPanel frame = new JPanel();
    frame.add(this);
    frame.setVisible(true);
  }
}
