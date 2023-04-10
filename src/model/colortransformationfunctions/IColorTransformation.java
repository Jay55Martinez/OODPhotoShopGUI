package model.colortransformationfunctions;

import java.util.function.Function;

import model.Pixel;

/**
 * This interface represents a color transformation function.
 */
public interface IColorTransformation extends Function<Pixel, Pixel> {

  public void initMatrix();

}
