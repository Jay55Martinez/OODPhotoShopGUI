package model.histogramfunction;

import java.awt.Color;
import java.util.Objects;

/**
 * Enum representing the different fields that a histogram can have.
 */
public enum Field {
  red(Color.RED),
  green(Color.GREEN),
  blue(Color.BLUE),
  intensity(Color.BLACK);

  private Color color;

  /**
   * Constructor for the enum.
   *
   * @param color the color of the field
   */
  Field(Color color) {
    this.color = Objects.requireNonNull(color);
  }

  /**
   * Returns the color associated with this field.
   *
   * @return the color associated with this field
   */
  public Color getColor() {
    return this.color;
  }
}
