import org.junit.Test;
import org.junit.Before;

import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Test class for Pixel.
 */
public class PixelTest {
  Pixel pixel;

  @Before
  public void setUp() {
    pixel = new Pixel(100, 200, 69);
  }

  @Test
  public void testGetRed() {
    assertEquals(100, pixel.getRed());
  }

  @Test
  public void testGetGreen() {
    assertEquals(200, pixel.getGreen());
  }

  @Test
  public void testGetBlue() {
    assertEquals(69, pixel.getBlue());
  }

  @Test
  public void testGetIntensity() {
    assertEquals(123, pixel.getIntensity());
  }

  @Test
  public void testGetLuma() {
    assertEquals(169, pixel.getLuma());
  }

  @Test
  public void testGetValue() {
    Pixel pixel1 = new Pixel(34, 64, 90);
    assertEquals(200, pixel.getValue());
    assertEquals(90, pixel1.getValue());
  }

  @Test
  public void testAddAmountToAll() {
    Pixel pixelAdd10 = pixel.addAmountToAll(10);
    Pixel pixelSub10 = pixel.addAmountToAll(-10);
    assertEquals(110, pixelAdd10.getRed());
    assertEquals(210, pixelAdd10.getGreen());
    assertEquals(79, pixelAdd10.getBlue());
    assertEquals(90, pixelSub10.getRed());
    assertEquals(190, pixelSub10.getGreen());
    assertEquals(59, pixelSub10.getBlue());

    Pixel pixelAdd255 = pixel.addAmountToAll(255);
    Pixel pixelSub255 = pixel.addAmountToAll(-255);
    assertEquals(255, pixelAdd255.getRed());
    assertEquals(255, pixelAdd255.getGreen());
    assertEquals(255, pixelAdd255.getBlue());
    assertEquals(0, pixelSub255.getRed());
    assertEquals(0, pixelSub255.getGreen());
    assertEquals(0, pixelSub255.getBlue());
  }

  @Test
  public void testToString() {
    assertEquals("100 200 69", pixel.toString());
  }

  @Test
  public void testHashCode() {
    assertEquals(1380100, pixel.hashCode());
  }

  @Test
  public void testNotEquals() {
    Pixel pixel1 = new Pixel(100, 69, 200);
    assertFalse(pixel.equals(pixel1));
  }

  @Test
  public void testEquals() {
    Pixel pixel1 = new Pixel(100, 200, 69);
    assertTrue(pixel.equals(pixel1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeRedComponent() {
    new Pixel(-1, 3, 9);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeGreenComponent() {
    new Pixel(53, -23, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeBlueComponent() {
    new Pixel(23, 53, -7);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToLargeRedComponent() {
    new Pixel(256, 23, 6);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToLargeGreenComponent() {
    new Pixel(2, 432, 80);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testToLargeBlueComponent() {
    new Pixel(23, 32, 900);
  }
}
