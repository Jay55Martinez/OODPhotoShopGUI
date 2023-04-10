package model.colortransformationfunctions;

/**
 * This class implements sepia tone through color transformation.
 */
public class SepiaTone extends AColorTransformation {
  @Override
  public void initMatrix() {
    this.matrix[0][0] = .393;
    this.matrix[0][1] = .769;
    this.matrix[0][2] = .189;
    this.matrix[1][0] = .349;
    this.matrix[1][1] = .686;
    this.matrix[1][2] = .168;
    this.matrix[2][0] = .272;
    this.matrix[2][1] = .534;
    this.matrix[2][2] = .131;
  }
}
