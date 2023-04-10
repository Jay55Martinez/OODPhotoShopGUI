package model;

import java.util.function.Function;

/**
 * Abstract class for a Model.
 */
public abstract class AModel implements IPhotoModelFilter {

  protected final Pixel[][] image;

  protected AModel(Pixel[][] image) {
    if (image == null) {
      throw new IllegalArgumentException("the image array can not be null");
    }
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        if (image[row][col] == null) {
          throw new IllegalArgumentException("no pixels in the array can be null");
        }
      }
    }

    this.image = image;
  }

  @Override
  public Pixel[][] flipHor() {
    Pixel[][] newImage = new Pixel[image.length][image[0].length];
    int count = 0;
    for (int row = image.length - 1; row >= 0; row--) {
      for (int col = 0; col < image[row].length; col++) {
        newImage[count][col] = image[row][col];
      }
      count++;
    }
    return newImage;
  }

  @Override
  public Pixel[][] flipVer() {
    Pixel[][] newImage = new Pixel[image.length][image[0].length];
    for (int row = 0; row < image.length; row++) {
      int count = 0;
      for (int col = image[row].length - 1; col >= 0; col--) {
        newImage[row][count] = image[row][col];
        count++;
      }
    }
    return newImage;
  }

  @Override
  public Pixel[][] brighten(int level) {
    Pixel[][] newImage = new Pixel[image.length][image[0].length];
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[row].length; col++) {
        newImage[row][col] = image[row][col].addAmountToAll(level);
      }
    }
    return newImage;
  }

  @Override
  public Pixel[][] grayScale(Function<Pixel, Pixel> component) {
    return this.applyComponent(component);
  }


  @Override
  public Pixel[][] getImage() {
    return this.image;
  }

  @Override
  public Pixel[][] applyFilter(Function<Pixel[][], Pixel[][]> filter) {
    return filter.apply(image);
  }

  @Override
  public Pixel[][] applyTransformation(Function<Pixel, Pixel> component) {
    return this.applyComponent(component);
  }


  private Pixel[][] applyComponent(Function<Pixel, Pixel> component) {
    Pixel[][] newImage = new Pixel[image.length][image[0].length];
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[row].length; col++) {
        Pixel newRgb = component.apply(image[row][col]);
        newImage[row][col] = newRgb;
      }
    }
    return newImage;
  }
}
