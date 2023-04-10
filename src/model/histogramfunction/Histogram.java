package model.histogramfunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import model.Pixel;
import static model.histogramfunction.Field.blue;
import static model.histogramfunction.Field.green;
import static model.histogramfunction.Field.intensity;
import static model.histogramfunction.Field.red;


/**
 * Class represents a histogram graph for an image. Takes each pixel's component value (red,
 * green, blue) and intensity keeping track of how many times that value appeaser in the image.
 * Each component and intensity will have its separate graph denoted by its field.
 */
public class Histogram {

  private Map<Field, Map<Integer, Integer>> histogramData;
  private final Pixel[][] image;

  /**
   * Constructor creates a new Histogram with the data fields of the map initialized to
   * red, green, blue, and intensity.
   *
   * @param image 2d array of pixels that the histogram will reference
   */
  public Histogram(Pixel[][] image) {
    this.image = Objects.requireNonNull(image);
    this.histogramData = new HashMap<>();
    this.histogramData.put(red, new HashMap<>());
    this.histogramData.put(green, new HashMap<>());
    this.histogramData.put(blue, new HashMap<>());
    this.histogramData.put(intensity, new HashMap<>());
    initData();
  }

  // initializes all the data for the histogram
  private void initData() {
    for (int row = 0; row < this.image.length; row++) {
      for (int col = 0; col < this.image[0].length; col++) {
        int redVal = this.image[row][col].getRed();
        int greenVal = this.image[row][col].getGreen();
        int blueVal = this.image[row][col].getBlue();
        int intensityVal = this.image[row][col].getIntensity();
        this.histogramData = new DataFunction(redVal, red).apply(this.histogramData);
        this.histogramData = new DataFunction(greenVal, green).apply(this.histogramData);
        this.histogramData = new DataFunction(blueVal, blue).apply(this.histogramData);
        this.histogramData = new DataFunction(intensityVal, intensity).apply(this.histogramData);
      }
    }
  }

  /**
   * Returns the number of components with the given value in the specified field.
   *
   * @param value will return the number of components with the value
   * @param field specified component field to get data from
   * @return returns an int of the number of times the value shows up in the field
   * @throws IllegalArgumentException if the value is negative or above 255
   */
  public int numberOfComponents(int value, Field field) throws IllegalArgumentException {
    if (value < 0 || value > 255) {
      throw new IllegalArgumentException("the value given can not be negative/ over 255");
    }
    if (this.histogramData.get(field).containsKey(value)) {
      return this.histogramData.get(field).get(value);
    }
    else {
      return 0;
    }
  }

  /**
   * Gets the value of the component with the highest frequency in the whole image.
   *
   * @return int value of the component with the highest frequency
   */
  public int maxFrequency() {
    int highest = 0;
    for (Field field : this.histogramData.keySet()) {
      for (int value : this.histogramData.get(field).keySet()) {
        if (this.histogramData.get(field).get(value) > highest) {
          highest = this.histogramData.get(field).get(value);
        }
      }
    }
    return highest;
  }
}