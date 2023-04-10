package model.colortransformationfunctions;

import model.Pixel;

/**
 * Abstract class for color transformation.
 */
public abstract class AColorTransformation implements IColorTransformation {
  protected double[][] matrix = new double[3][3];


  @Override
  public Pixel apply(Pixel pixel) {
    int[] values = new int[3];
    this.initMatrix();
    values[0] = this.matrixMult(this.matrix[0], pixel);
    values[1] = this.matrixMult(this.matrix[1], pixel);
    values[2] = this.matrixMult(this.matrix[2], pixel);
    return new Pixel(values[0], values[1], values[2]);
  }

  /**
   * Does the matrix multiplication.
   *
   * @param matrix the matrix of given values.
   * @param pixel  a pixel.
   * @return returns the new value of the R,G, or B component of a pixel.
   */
  private int matrixMult(double[] matrix, Pixel pixel) {
    int value = (int) (matrix[0] * pixel.getRed() + matrix[1]
            * pixel.getGreen() + matrix[2] * pixel.getBlue());
    if (value > 255) {
      return 255;
    }
    if (value < 0) {
      return 0;
    }
    return value;
  }
}
