import org.junit.Test;
import org.junit.Before;

import model.colortransformationfunctions.GreyScale;
import model.colortransformationfunctions.SepiaTone;
import model.fliterfunctions.Blur;
import model.fliterfunctions.Sharpen;
import model.grayscalefunctions.Blue;
import model.grayscalefunctions.Green;
import model.grayscalefunctions.Intensity;
import model.grayscalefunctions.Luma;
import model.grayscalefunctions.Red;
import model.grayscalefunctions.Value;
import model.IPhotoModelFilter;
import model.DefaultPhotoModel;
import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Tests for any model class.
 */
public class DefaultModelTest {

  IPhotoModelFilter model1;
  IPhotoModelFilter model2;
  Pixel[][] image1;
  Pixel[][] image2;

  @Before
  public void setUp() {
    image1 = new Pixel[5][5];

    image2 = new Pixel[5][5];

    for (int row = 0; row < image1.length; row++) {
      for (int col = 0; col < image1[0].length; col++) {
        if ((row + col) % 2 == 0) {
          image1[row][col] = new Pixel(255, 255, 255);
          image2[row][col] = new Pixel(255, 255, 255);
        } else {
          image1[row][col] = new Pixel(0, 0, 0);
          image2[row][col] = new Pixel(0, 0, 0);
        }
      }
    }

    image2[0][0] = new Pixel(200, 100, 80);
    image2[0][1] = new Pixel(0, 255, 0);
    image2[0][2] = new Pixel(25, 35, 255);
    image2[1][0] = new Pixel(10, 100, 90);
    image2[1][1] = new Pixel(2, 25, 200);
    image2[2][0] = new Pixel(255, 0, 0);
    //PPM model serves as a default model.
    model1 = new DefaultPhotoModel(image1);
    model2 = new DefaultPhotoModel(image2);
  }

  @Test
  public void testBlur() {
    Pixel[][] blurImage1 = model1.applyFilter(new Blur());
    Pixel[][] expectedBlurImage1 = new Pixel[][]{
            {new Pixel(78, 78, 78),
             new Pixel(93, 93, 93),
             new Pixel(93, 93, 93),
             new Pixel(93, 93, 93),
             new Pixel(78, 78, 78)},
            {new Pixel(93, 93, 93),
             new Pixel(123, 123, 123),
             new Pixel(124, 124, 124),
             new Pixel(123, 123, 123),
             new Pixel(93, 93, 93)},
            {new Pixel(93, 93, 93),
             new Pixel(124, 124, 124),
             new Pixel(123, 123, 123),
             new Pixel(124, 124, 124),
             new Pixel(93, 93, 93)},
            {new Pixel(93, 93, 93),
             new Pixel(123, 123, 123),
             new Pixel(124, 124, 124),
             new Pixel(123, 123, 123),
             new Pixel(93, 93, 93)},
            {new Pixel(78, 78, 78),
             new Pixel(93, 93, 93),
             new Pixel(93, 93, 93),
             new Pixel(93, 93, 93),
             new Pixel(78, 78, 78)}};

    Pixel[][] blurImage2 = model2.applyFilter(new Blur());
    Pixel[][] expectedBlurImage2 = new Pixel[][]{
            {new Pixel(51, 69, 43),
             new Pixel(28, 88, 71),
             new Pixel(21, 55, 90),
             new Pixel(65, 66, 93),
             new Pixel(78, 78, 78)},
            {new Pixel(58, 55, 57),
             new Pixel(44, 72, 96),
             new Pixel(65, 84, 118),
             new Pixel(109, 110, 123),
             new Pixel(93, 93, 93)},
            {new Pixel(79, 28, 38),
             new Pixel(93, 71, 92),
             new Pixel(108, 109, 120),
             new Pixel(124, 124, 124),
             new Pixel(93, 93, 93)},
            {new Pixel(93, 62, 62),
             new Pixel(123, 108, 108),
             new Pixel(124, 124, 124),
             new Pixel(123, 123, 123),
             new Pixel(93, 93, 93)},
            {new Pixel(78, 78, 78),
             new Pixel(93, 93, 93),
             new Pixel(93, 93, 93),
             new Pixel(93, 93, 93),
             new Pixel(78, 78, 78)}};

    assertTrue(sameArray(expectedBlurImage2, blurImage2));
    assertTrue(sameArray(expectedBlurImage1, blurImage1));
  }

  @Test
  public void testBrighten() {
    Pixel[][] sharpenImage1 = model1.applyFilter(new Sharpen());
    Pixel[][] expectedSharpenImage1 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(61, 61, 61),
             new Pixel(255, 255, 255),
             new Pixel(94, 94, 94),
             new Pixel(62, 62, 62)},
            {new Pixel(63, 63, 63),
             new Pixel(255, 255, 255),
             new Pixel(64, 64, 64),
             new Pixel(224, 224, 224),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(65, 65, 65),
             new Pixel(255, 255, 255),
             new Pixel(95, 95, 95),
             new Pixel(63, 63, 63)},
            {new Pixel(96, 96, 96),
             new Pixel(225, 225, 225),
             new Pixel(97, 97, 97),
             new Pixel(225, 225, 225),
             new Pixel(1, 1, 1)},
            {new Pixel(64, 64, 64),
             new Pixel(0, 0, 0),
             new Pixel(64, 64, 64),
             new Pixel(1, 1, 1),
             new Pixel(32, 32, 32)}};

    Pixel[][] sharpenImage2 = model2.applyFilter(new Sharpen());
    Pixel[][] expectedSharpenImage2 = new Pixel[][]{
            {new Pixel(90, 113, 255),
             new Pixel(0, 50, 89),
             new Pixel(255, 255, 255),
             new Pixel(122, 121, 94),
             new Pixel(62, 62, 62)},
            {new Pixel(38, 0, 30),
             new Pixel(226, 234, 255),
             new Pixel(122, 88, 70),
             new Pixel(252, 251, 224),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(94, 111, 91),
             new Pixel(255, 255, 255),
             new Pixel(95, 95, 95),
             new Pixel(63, 63, 63)},
            {new Pixel(96, 126, 126),
             new Pixel(225, 255, 255),
             new Pixel(97, 97, 97),
             new Pixel(225, 225, 225),
             new Pixel(1, 1, 1)},
            {new Pixel(64, 64, 64),
             new Pixel(0, 0, 0),
             new Pixel(64, 64, 64),
             new Pixel(1, 1, 1),
             new Pixel(32, 32, 32)}};

    assertTrue(sameArray(expectedSharpenImage1, sharpenImage1));
    assertTrue(sameArray(expectedSharpenImage2, sharpenImage2));
  }

  @Test
  public void testBright() {
    Pixel[][] brightenImage1 = model1.brighten(10);
    Pixel[][] expectedBrightenImage1 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255)},
            {new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10)},
            {new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255)},
            {new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10)},
            {new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255)}};

    Pixel[][] brightenImage2 = model2.brighten(10);
    Pixel[][] expectedBrightenImage2 = new Pixel[][]{
            {new Pixel(210, 110, 90),
             new Pixel(10, 255, 10),
             new Pixel(35, 45, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255)},
            {new Pixel(20, 110, 100),
             new Pixel(12, 35, 210),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10)},
            {new Pixel(255, 10, 10),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255)},
            {new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10)},
            {new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255),
             new Pixel(10, 10, 10),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedBrightenImage1, brightenImage1));
    assertTrue(sameArray(expectedBrightenImage2, brightenImage2));
  }

  @Test
  public void testDarken() {
    Pixel[][] darkenImage1 = model1.brighten(-10);
    Pixel[][] expectedDarkenImage1 = new Pixel[][]{
            {new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245)},
            {new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0)},
            {new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245)},
            {new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0)},
            {new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245)}};

    Pixel[][] darkenImage2 = model2.brighten(-10);
    Pixel[][] expectedDarkenImage2 = new Pixel[][]{
            {new Pixel(190, 90, 70),
             new Pixel(0, 245, 0),
             new Pixel(15, 25, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245)},
            {new Pixel(0, 90, 80),
             new Pixel(0, 15, 190),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0)},
            {new Pixel(245, 0, 0),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245)},
            {new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0)},
            {new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245),
             new Pixel(0, 0, 0),
             new Pixel(245, 245, 245)}};

    assertTrue(sameArray(expectedDarkenImage1, darkenImage1));
    assertTrue(sameArray(expectedDarkenImage2, darkenImage2));
  }

  @Test
  public void testSepia() {
    Pixel[][] sepiaImage1 = model1.applyTransformation(new SepiaTone());
    Pixel[][] expectedSepiaImage1 = new Pixel[][]{
            {new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238)}};

    Pixel[][] sepiaImage2 = model2.applyTransformation(new SepiaTone());
    Pixel[][] expectedSepiaImage2 = new Pixel[][]{
            {new Pixel(170, 151, 118),
             new Pixel(196, 174, 136),
             new Pixel(84, 75, 58),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238)},
            {new Pixel(97, 87, 67),
             new Pixel(57, 51, 40),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0)},
            {new Pixel(100, 88, 69),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 238)}};

    assertTrue(sameArray(expectedSepiaImage1, sepiaImage1));
    assertTrue(sameArray(expectedSepiaImage2, sepiaImage2));
  }

  @Test
  public void testGrayScaleTransformation() {
    Pixel[][] grayscaleImage1 = model1.applyTransformation(new GreyScale());
    Pixel[][] expectedGrayscaleImage1 = new Pixel[][]{
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)}};

    Pixel[][] grayscaleImage2 = model2.applyTransformation(new GreyScale());
    Pixel[][] expectedGrayscaleImage2 = new Pixel[][]{
            {new Pixel(119, 119, 119),
             new Pixel(182, 182, 182),
             new Pixel(48, 48, 48),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(80, 80, 80),
             new Pixel(32, 32, 32),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(54, 54, 54),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)}};

    assertTrue(sameArray(expectedGrayscaleImage1, grayscaleImage1));
    assertTrue(sameArray(expectedGrayscaleImage2, grayscaleImage2));
  }

  @Test
  public void testGrayscaleComponentBlue() {
    Pixel[][] componentBlueImage1 = model1.grayScale(new Blue());
    Pixel[][] expectedComponentBlueImage1 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    Pixel[][] componentBlueImage2 = model2.grayScale(new Blue());
    Pixel[][] expectedComponentBlueImage2 = new Pixel[][]{
            {new Pixel(80, 80, 80),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(90, 90, 90),
             new Pixel(200, 200, 200),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(0, 0, 0),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedComponentBlueImage1, componentBlueImage1));
    assertTrue(sameArray(expectedComponentBlueImage2, componentBlueImage2));
  }

  @Test
  public void testGrayscaleComponentGreen() {
    Pixel[][] componentGreenImage1 = model1.grayScale(new Green());
    Pixel[][] expectedComponentGreenImage1 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    Pixel[][] componentGreenImage2 = model2.grayScale(new Green());
    Pixel[][] expectedComponentGreenImage2 = new Pixel[][]{
            {new Pixel(100, 100, 100),
             new Pixel(255, 255, 255),
             new Pixel(35, 35, 35),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(100, 100, 100),
             new Pixel(25, 25, 25),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(0, 0, 0),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedComponentGreenImage1, componentGreenImage1));
    assertTrue(sameArray(expectedComponentGreenImage2, componentGreenImage2));
  }

  @Test
  public void testGrayscaleComponentIntensity() {
    Pixel[][] componentIntensityImage1 = model1.grayScale(new Intensity());
    Pixel[][] expectedComponentIntensityImage1 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    Pixel[][] componentIntensityImage2 = model2.grayScale(new Intensity());
    Pixel[][] expectedComponentIntensityImage2 = new Pixel[][]{
            {new Pixel(126, 126, 126),
             new Pixel(85, 85, 85),
             new Pixel(105, 105, 105),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(66, 66, 66),
             new Pixel(75, 75, 75),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(85, 85, 85),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedComponentIntensityImage1, componentIntensityImage1));
    assertTrue(sameArray(expectedComponentIntensityImage2, componentIntensityImage2));
  }

  @Test
  public void testGrayscaleComponentValue() {
    Pixel[][] componentValueImage1 = model1.grayScale(new Value());
    Pixel[][] expectedComponentValueImage1 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    Pixel[][] componentValueImage2 = model2.grayScale(new Value());
    Pixel[][] expectedComponentValueImage2 = new Pixel[][]{
            {new Pixel(200, 200, 200),
             new Pixel(255, 255, 255),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(100, 100, 100),
             new Pixel(200, 200, 200),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedComponentValueImage1, componentValueImage1));
    assertTrue(sameArray(expectedComponentValueImage2, componentValueImage2));
  }

  @Test
  public void testGrayscaleComponentRed() {
    Pixel[][] componentRedImage1 = model1.grayScale(new Red());
    Pixel[][] expectedComponentRedImage1 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    Pixel[][] componentRedImage2 = model2.grayScale(new Red());
    Pixel[][] expectedComponentRedImage2 = new Pixel[][]{
            {new Pixel(200, 200, 200),
             new Pixel(0, 0, 0),
             new Pixel(25, 25, 25),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(10, 10, 10),
             new Pixel(2, 2, 2),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedComponentRedImage1, componentRedImage1));
    assertTrue(sameArray(expectedComponentRedImage2, componentRedImage2));
  }

  @Test
  public void testGrayscaleComponentLuma() {
    Pixel[][] componentLumaImage1 = model1.grayScale(new Luma());
    Pixel[][] expectedComponentLumaImage1 = new Pixel[][]{
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)}};

    Pixel[][] componentLumaImage2 = model2.grayScale(new Luma());
    Pixel[][] expectedComponentLumaImage2 = new Pixel[][]{
            {new Pixel(119, 119, 119),
             new Pixel(183, 183, 183),
             new Pixel(48, 48, 48),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(80, 80, 80),
             new Pixel(32, 32, 32),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(53, 53, 53),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)},
            {new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0)},
            {new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254),
             new Pixel(0, 0, 0),
             new Pixel(254, 254, 254)}};

    assertTrue(sameArray(expectedComponentLumaImage1, componentLumaImage1));
    assertTrue(sameArray(expectedComponentLumaImage2, componentLumaImage2));
  }

  @Test
  public void testFlipHorizontal() {
    //flipping Image1 wont change it
    Pixel[][] flipHorizontalImage1 = model1.flipHor();
    assertTrue(sameArray(image1, flipHorizontalImage1));

    Pixel[][] flipHorizontalImage2 = model2.flipHor();
    Pixel[][] expectedFlipHorizontalImage2 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 0, 0),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)},
            {new Pixel(10, 100, 90),
             new Pixel(2, 25, 200),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(200, 100, 80),
             new Pixel(0, 255, 0),
             new Pixel(25, 35, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedFlipHorizontalImage2, flipHorizontalImage2));
  }

  @Test
  public void testFlipVertical() {
    //flipping image1 won't change it
    Pixel[][] flipVerticalImage1 = model1.flipVer();
    assertTrue(sameArray(image1, flipVerticalImage1));

    Pixel[][] flipVerticalImage2 = model2.flipVer();
    Pixel[][] expectedFlipVerticalImage2 = new Pixel[][]{
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(25, 35, 255),
             new Pixel(0, 255, 0),
             new Pixel(200, 100, 80)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(2, 25, 200),
             new Pixel(10, 100, 90)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 0, 0)},
            {new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0)},
            {new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255),
             new Pixel(0, 0, 0),
             new Pixel(255, 255, 255)}};

    assertTrue(sameArray(expectedFlipVerticalImage2, flipVerticalImage2));
  }

  @Test
  public void testGetImage() {
    assertTrue(sameArray(image1, model1.getImage()));
    assertTrue(sameArray(image2, model2.getImage()));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArrayNull() {
    new DefaultPhotoModel(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testArrayContainsNullPixel() {
    Pixel[][] image = new Pixel[][]{
            {new Pixel(23, 23, 5)},
            {null}};
    new DefaultPhotoModel(image);
  }


  //helper method for the tests returns true if both arrays are the same
  private boolean sameArray(Pixel[][] expected, Pixel[][] actual) {
    if (expected.length != actual.length) {
      return false;
    }
    for (int row = 0; row < image1.length; row++) {
      for (int col = 0; col < image1[0].length; col++) {
        if (!(expected[row][col].equals(actual[row][col]))) {
          return false;
        }
      }
    }
    return true;
  }

  @Test
  public void greyScaleApply() {
    GreyScale greyScale = new GreyScale();
    Pixel pixel = new Pixel(108, 32, 147);
    Pixel newPix = greyScale.apply(pixel);
    assertEquals(56, newPix.getRed());
    assertEquals(56, newPix.getGreen());
    assertEquals(56, newPix.getBlue());
  }

  @Test
  public void SepiaApply() {
    SepiaTone sepia = new SepiaTone();
    Pixel pixel = new Pixel(108, 32, 147);
    Pixel newPix = sepia.apply(pixel);
    assertEquals(94, newPix.getRed());
    assertEquals(84, newPix.getGreen());
    assertEquals(65, newPix.getBlue());
  }
}