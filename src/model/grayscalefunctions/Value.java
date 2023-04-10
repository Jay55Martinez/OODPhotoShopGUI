package model.grayscalefunctions;

import java.util.function.Function;

import model.Pixel;

/**
 * This class implements the Function interface
 * and applies the component with the highest value
 * to all the three of the components of the pixel.
 */
public class Value implements Function<Pixel, Pixel> {

  @Override
  public Pixel apply(Pixel rgb) {
    return new Pixel(rgb.getValue(), rgb.getValue(), rgb.getValue());
  }
}
