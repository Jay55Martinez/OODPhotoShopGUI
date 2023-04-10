package model.fliterfunctions;

import model.Pixel;

/**
 * Class extends AFilter and AFilter implements Function. This class represents a Sharpen filter.
 */
public class Sharpen extends AFilter {
  @Override
  public Pixel[][] apply(Pixel[][] image) {
    float[][] filter = new float[][]{{-0.125f, -0.125f, -0.125f, -0.125f, -0.125f},
        {-0.125f, 0.25f, 0.25f, 0.25f, -0.125f},
        {-0.125f, 0.25f, 1f, 0.25f, -0.124f},
        {-0.125f, 0.25f, 0.25f, 0.25f, -0.125f},
        {-0.125f, -0.125f, -0.125f, -0.125f, -0.125f}};
    return runFilter(filter, image);
  }
}
