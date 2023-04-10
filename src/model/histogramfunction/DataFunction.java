package model.histogramfunction;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

/**
 * Function object used to populate the histogram data. Takes a value and a field and returns
 * a new map with the value added to the field.
 */
public class DataFunction
        implements Function<Map<Field, Map<Integer, Integer>>, Map<Field, Map<Integer, Integer>>> {

  private final int val;

  private final Field key;

  /**
   * Constructor for the function object.
   *
   * @param val the value to be added to the field
   * @param key the field to add the value to
   */
  public DataFunction(int val, Field key) {
    this.val = val;
    this.key = Objects.requireNonNull(key);
  }

  @Override
  public Map<Field, Map<Integer, Integer>> apply(Map<Field, Map<Integer, Integer>> dataMap) {
    if (dataMap.get(key).containsKey(val)) {
      dataMap.get(key).put(val, dataMap.get(key).get(val) + 1);
    } else {
      dataMap.get(key).put(val, 1);
    }
    return dataMap;
  }
}