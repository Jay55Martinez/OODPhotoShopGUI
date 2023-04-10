package model;

/**
 * class that represents the content of a pixel.
 */
public class Pixel {
  private int red;
  private int green;
  private int blue;

  /**
   * Constructs a new pixel with all three components.
   *
   * @param red   value of the red component
   * @param green value of the green component
   * @param blue  value of the blue component
   */
  public Pixel(int red, int green, int blue) {
    if (red < 0 || green < 0 || blue < 0) {
      throw new IllegalArgumentException("component values can not be less than 0");
    }
    if (red > 255 || green > 255 || blue > 255) {
      throw new IllegalArgumentException("component values can not be more than 244");
    }
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  /**
   * Getter method for the red component.
   *
   * @return the int value of the red component
   */
  public int getRed() {
    return red;
  }

  /**
   * Getter method for the green component.
   *
   * @return the int value of the green component
   */
  public int getGreen() {
    return green;
  }

  /**
   * Getter method for the blue component.
   *
   * @return the int value of the blue component
   */
  public int getBlue() {
    return blue;
  }

  /**
   * Returns Average of all three components.
   *
   * @return int average of the components
   */
  public int getIntensity() {
    return (this.red + this.green + this.blue) / 3;
  }

  /**
   * Returns the weighted average of the components.
   *
   * @return int weighted average
   */
  public int getLuma() {
    return (int) (0.21 * this.red + 0.72 * this.green + 0.07 * this.blue);
  }

  /**
   * Returns the component with the highest value.
   *
   * @return int highest component value
   */
  public int getValue() {
    if (this.red > this.green && this.red > this.blue) {
      return this.red;
    } else if (this.green > this.blue) {
      return this.green;
    } else {
      return this.blue;
    }
  }

  /**
   * Creates a new pixel with all components increased/decreased by the value.
   *
   * @param value the amount to increase the components by
   * @return a pixel with components increased/decreased by the value
   */
  public Pixel addAmountToAll(int value) {
    int[] components = new int[]{this.red + value, this.green + value, this.blue + value};
    for (int x = 0; x < components.length; x++) {
      if (components[x] > 255) {
        components[x] = 255;
      } else if (components[x] < 0) {
        components[x] = 0;
      }
    }
    return new Pixel(components[0], components[1], components[2]);
  }

  /**
   * toString method for Pixel.
   *
   * @return String of all components in order red, green, blue
   */
  public String toString() {
    return this.red + " " + this.green + " " + this.blue;
  }

  @Override
  public int hashCode() {
    int value = this.red * this.green * this.blue + this.red;
    return value;
  }

  @Override
  public boolean equals(Object p) {
    if (!(p instanceof Pixel)) {
      return false;
    }

    Pixel pixel = (Pixel) p;

    return this.hashCode() == pixel.hashCode() && this.getBlue() == pixel.getBlue() &&
            this.getGreen() == pixel.getGreen() && this.getRed() == pixel.getRed();
  }
}
