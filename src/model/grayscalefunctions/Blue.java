package model.grayscalefunctions;

import java.util.function.Function;
import model.Pixel;

/**
 * This class implement the Function interface and apply the blue component of the pixel to all
 * three components of the pixel.
 */
public class Blue implements Function<Pixel, Pixel> {



  @Override
  public Pixel apply(Pixel rgb) {
    return new Pixel(rgb.getBlue(), rgb.getBlue(), rgb.getBlue());
  }
}
