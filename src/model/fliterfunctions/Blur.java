package model.fliterfunctions;

import model.Pixel;

/**
 * Class extends AFilter and AFilter implements Function. This class represents a blur filter.
 */
public class Blur extends AFilter {

  @Override
  public Pixel[][] apply(Pixel[][] image) {
    float[][] filter = new float[][]{{0.0625f, 0.125f, 0.0625f},
      {0.125f, 0.25f, 0.125f},
      {0.0625f, 0.125f, 0.0625f}};
    return runFilter(filter, image);
  }
}