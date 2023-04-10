package model.grayscalefunctions;

import java.util.function.Function;

import model.Pixel;

/**
 * This class implement the Function interface and apply the green component of the pixel to all
 * three components of the pixel.
 */
public class Green implements Function<Pixel, Pixel> {

  @Override
  public Pixel apply(Pixel rgb) {
    return new Pixel(rgb.getGreen(), rgb.getGreen(), rgb.getGreen());
  }
}
