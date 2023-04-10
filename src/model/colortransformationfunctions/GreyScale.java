package model.colortransformationfunctions;


/**
 * This class implements grey scale using luma through color transformation.
 */
public class GreyScale extends AColorTransformation {
  @Override
  public void initMatrix() {
    for (int row = 0; row < 3; row++) {
      for (int col = 0; col < 3; col++) {
        if (col == 0) {
          this.matrix[row][col] = .2126;
        } else if (col == 1) {
          this.matrix[row][col] = .7152;
        } else {
          this.matrix[row][col] = .0722;
        }
      }
    }
  }
}
