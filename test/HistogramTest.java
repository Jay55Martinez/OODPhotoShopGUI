import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Before;

import model.histogramfunction.Field;
import model.histogramfunction.Histogram;
import model.Pixel;

/**
 * Testing class for the Histogram class.
 */
public class HistogramTest {
  Histogram histogram1;
  Histogram histogram2;

  @Before
  public void setUp() {
    Pixel[][] image1 = new Pixel[5][5];

    Pixel[][] image2 = new Pixel[5][5];

    for (int row = 0; row < image1.length; row++) {
      for (int col = 0; col < image1[0].length; col++) {
        if ((row + col) % 2 == 0) {
          image1[row][col] = new Pixel(255, 255, 255);
          image2[row][col] = new Pixel(255, 255, 255);
        } else {
          image1[row][col] = new Pixel(0, 0, 0);
          image2[row][col] = new Pixel(0, 0, 0);
        }
      }
    }

    image2[0][0] = new Pixel(200, 100, 80);
    image2[0][1] = new Pixel(0, 255, 0);
    image2[0][2] = new Pixel(25, 35, 255);
    image2[1][0] = new Pixel(10, 100, 90);
    image2[1][1] = new Pixel(2, 25, 200);
    image2[2][0] = new Pixel(255, 0, 0);

    histogram1 = new Histogram(image1);
    histogram2 = new Histogram(image2);
  }

  @Test
  public void testNumberOfComponents() {
    assertEquals(13, histogram1.numberOfComponents(255, Field.red));
    assertEquals(12, histogram1.numberOfComponents(0, Field.red));
    assertEquals(13, histogram1.numberOfComponents(255, Field.green));
    assertEquals(12, histogram1.numberOfComponents(0, Field.green));
    assertEquals(13, histogram1.numberOfComponents(255, Field.blue));
    assertEquals(12, histogram1.numberOfComponents(0, Field.blue));
    assertEquals(13, histogram1.numberOfComponents(255, Field.intensity));
    assertEquals(12, histogram1.numberOfComponents(0, Field.intensity));
    assertEquals(0, histogram1.numberOfComponents(120, Field.red));
    assertEquals(0, histogram1.numberOfComponents(56, Field.green));
    assertEquals(0, histogram1.numberOfComponents(12, Field.blue));
    assertEquals(0, histogram1.numberOfComponents(32, Field.intensity));

    assertEquals(10, histogram2.numberOfComponents(255, Field.red));
    assertEquals(11, histogram2.numberOfComponents(0, Field.red));
    assertEquals(1, histogram2.numberOfComponents(25, Field.red));
    assertEquals(1, histogram2.numberOfComponents(2, Field.red));
    assertEquals(1, histogram2.numberOfComponents(10, Field.red));
    assertEquals(0, histogram2.numberOfComponents(45, Field.red));
    assertEquals(10, histogram2.numberOfComponents(255, Field.green));
    assertEquals(11, histogram2.numberOfComponents(0, Field.green));
    assertEquals(2, histogram2.numberOfComponents(100, Field.green));
    assertEquals(1, histogram2.numberOfComponents(25, Field.green));
    assertEquals(0, histogram2.numberOfComponents(26, Field.green));
    assertEquals(10, histogram2.numberOfComponents(255, Field.blue));
    assertEquals(12, histogram2.numberOfComponents(0, Field.blue));
    assertEquals(1, histogram2.numberOfComponents(200, Field.blue));
    assertEquals(1, histogram2.numberOfComponents(80, Field.blue));
    assertEquals(1, histogram2.numberOfComponents(90, Field.blue));
    assertEquals(0, histogram2.numberOfComponents(79, Field.blue));
    assertEquals(1, histogram2.numberOfComponents(126, Field.intensity));
    assertEquals(2, histogram2.numberOfComponents(85, Field.intensity));
    assertEquals(9, histogram2.numberOfComponents(255, Field.intensity));
    assertEquals(1, histogram2.numberOfComponents(105, Field.intensity));
    assertEquals(1, histogram2.numberOfComponents(75, Field.intensity));
    assertEquals(10, histogram2.numberOfComponents(0, Field.intensity));
    assertEquals(1, histogram2.numberOfComponents(66, Field.intensity));
    assertEquals(0, histogram2.numberOfComponents(45, Field.intensity));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNegativeValueNumberOfComponents() {
    histogram1.numberOfComponents(-1, Field.red);
  }

  @Test (expected = IllegalArgumentException.class)
  public void testGreater255ValueNumberOfComponents() {
    histogram1.numberOfComponents(256, Field.blue);
  }
}