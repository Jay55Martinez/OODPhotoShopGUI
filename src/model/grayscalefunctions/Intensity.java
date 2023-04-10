package model.grayscalefunctions;

import java.util.function.Function;

import model.Pixel;

/**
 * This class implement the Function interface and apply the average of the three
 * components pixel to all three components of the pixel.
 */
public class Intensity implements Function<Pixel, Pixel> {

  @Override
  public Pixel apply(Pixel rgb) {
    return new Pixel(rgb.getIntensity(), rgb.getIntensity(), rgb.getIntensity());
  }
}
