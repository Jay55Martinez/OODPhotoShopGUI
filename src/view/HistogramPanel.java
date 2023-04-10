package view;

import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

import model.histogramfunction.Histogram;
import model.histogramfunction.Field;
import model.Pixel;

/**
 * This class represents a panel that displays a histogram.
 */
public class HistogramPanel extends JPanel implements Runnable {
  private Pixel[][] image;

  /**
   * Constructs a HistogramPanel object.
   *
   * @param image the image to be displayed
   */
  public HistogramPanel(Pixel[][] image) {
    setPreferredSize(new Dimension(500, 500));
    this.image = image;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    Histogram histogram = new Histogram(this.image);
    int width = this.getWidth() - 50;
    int height = this.getHeight() - 50;
    double xSpacing = width / 256 + .75;
    double ySpacing = 0;

    // drawing the outline of the histogram graph setting x and y coordinates
    g2d.setColor(Color.BLACK);
    g2d.drawRect(40, 10, width, height);
    g2d.drawLine(35, 20, 45, 20);
    g2d.drawString("" + histogram.maxFrequency(), 0, 25);
    for (int i = 0; i < 256; i++) {
      int currentX = (int) (i * xSpacing + 40);
      if (i % 15 == 0) {
        g2d.setColor(Color.BLACK);
        g2d.drawLine(currentX, height + 5, currentX, height + 15);
        g2d.drawString("" + i, currentX - 10, height + 30);
      }
    }

    // adding the lines to the histogram graph
    if (histogram.maxFrequency() != 0) {
      g2d.setColor(Color.BLACK);
      g2d.drawLine(35, height / 2 + 10, 45, height / 2 + 10);
      g2d.drawString("" + histogram.maxFrequency() / 2, 0, height / 2 + 10);
      g2d.drawLine(35, height + 10, 45, height + 10);
      g2d.drawString("0", 5, height + 10);
      ySpacing = (double) (height - 10) / (double) histogram.maxFrequency();
      drawLine(histogram, xSpacing, ySpacing, g2d, Field.red);
      drawLine(histogram, xSpacing, ySpacing, g2d, Field.green);
      drawLine(histogram, xSpacing, ySpacing, g2d, Field.blue);
      drawLine(histogram, xSpacing, ySpacing, g2d, Field.intensity);
    }
  }

  // helper method to draw the lines for the histogram graph
  private void drawLine(Histogram histogram, double xSpacing, double ySpacing,
                        Graphics2D g2d, Field field) {
    int prevX = 40;
    int prevY = 335;

    g2d.setColor(field.getColor());
    for (int i = 0; i < 256; i++) {
      int componentFrequency = histogram.numberOfComponents(i, field);
      int currentX = (int) (i * xSpacing + 40);
      int currentY = 335 - (int) (componentFrequency * ySpacing);
      g2d.drawLine(prevX, prevY, currentX, currentY);

      prevX = currentX;
      prevY = currentY;
    }
  }

  @Override
  public void run() {
    this.setUp();
  }

  // helper method to set up the histogram panel
  private void setUp() {
    JPanel frame = new JPanel();
    frame.add(this);
    frame.setVisible(true);
  }
}
