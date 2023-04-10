import org.junit.Test;

import java.io.StringReader;

import controller.ScannerController;
import controller.ScriptController;
import model.Pixel;

import static org.junit.Assert.assertEquals;

/**
 * This class test the controller.
 */
public class ControllerTest {
  @Test
  public void loadJPGsavePNGTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/wing.jpg wing"
            + "\nsepia wing wing-sepia"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia." +
            "png wing-sepia"
            + "\nload /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia." +
            "png wing-sepia2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("wing-sepia2");
    Pixel[][] pixExpected = control.getImage("wing-sepia");
    for (int row = 0; row < pix.length; row++) {
      for (int col = 0; col < pix[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  //fix this test
  @Test
  public void loadBMPsaveJPGTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/field.bmp wing"
            + "\nsepia wing wing-sepia"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.jpg " +
            "wing-sepia"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia2.jpg" +
            " wing-sepia"
            + "\nload /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.jpg " +
            "wing-sepia2"
            + "\nload /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia2.jpg" +
            " wing-sepia2b");
    //due to the compression of jpg, the images are not exactly
    // the same thus why when need to save it two times and compare it to itself.
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("wing-sepia2");
    Pixel[][] pixExpected = control.getImage("wing-sepia2b");
    for (int row = 0; row < pix.length; row++) {
      for (int col = 0; col < pix[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void loadPNGsavePPMTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/beach.png wing"
            + "\nsepia wing wing-sepia"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.ppm" +
            " wing-sepia"
            + "\nload /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.ppm " +
            "wing-sepia2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("wing-sepia2");
    Pixel[][] pixExpected = control.getImage("wing-sepia");
    for (int row = 0; row < pix.length; row++) {
      for (int col = 0; col < pix[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void loadPPMsaveBMPTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/post.ppm wing"
            + "\nsepia wing wing-sepia"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.bmp" +
            " wing-sepia"
            + "\nload /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.bmp" +
            " wing-sepia2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("wing-sepia2");
    Pixel[][] pixExpected = control.getImage("wing-sepia");
    for (int row = 0; row < pix.length; row++) {
      for (int col = 0; col < pix[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void brightenTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/smallBackground.ppm small"
            + "\nbrighten 200 small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(255, 255, 255);
    pixExpected[0][1] = new Pixel(200, 200, 200);
    pixExpected[1][0] = new Pixel(200, 200, 200);
    pixExpected[1][1] = new Pixel(255, 255, 255);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void horizontalFLipTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nhorizontal-flip small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(255, 255, 255);
    pixExpected[0][1] = new Pixel(0, 0, 0);
    pixExpected[1][0] = new Pixel(0, 0, 0);
    pixExpected[1][1] = new Pixel(255, 255, 255);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void verticalFLipTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nhorizontal-flip small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(255, 255, 255);
    pixExpected[0][1] = new Pixel(0, 0, 0);
    pixExpected[1][0] = new Pixel(0, 0, 0);
    pixExpected[1][1] = new Pixel(255, 255, 255);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void redComponentTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nred-component small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(200, 200, 200);
    pixExpected[0][1] = new Pixel(0, 0, 0);
    pixExpected[1][0] = new Pixel(10, 10, 10);
    pixExpected[1][1] = new Pixel(2, 2, 2);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void greenComponentTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks" +
            "/OODPhotoshop/code13/smallBackground2.ppm small"
            + "\ngreen-component small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(100, 100, 100);
    pixExpected[0][1] = new Pixel(255, 255, 255);
    pixExpected[1][0] = new Pixel(100, 100, 100);
    pixExpected[1][1] = new Pixel(25, 25, 25);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void blueComponentTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nblue-component small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(80, 80, 80);
    pixExpected[0][1] = new Pixel(0, 0, 0);
    pixExpected[1][0] = new Pixel(90, 90, 90);
    pixExpected[1][1] = new Pixel(200, 200, 200);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void valueComponentTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nvalue-component small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(200, 200, 200);
    pixExpected[0][1] = new Pixel(255, 255, 255);
    pixExpected[1][0] = new Pixel(100, 100, 100);
    pixExpected[1][1] = new Pixel(200, 200, 200);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void lumaComponentTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nluma-component small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(119, 119, 119);
    pixExpected[0][1] = new Pixel(183, 183, 183);
    pixExpected[1][0] = new Pixel(80, 80, 80);
    pixExpected[1][1] = new Pixel(32, 32, 32);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void intensityComponentTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nintensity-component small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(126, 126, 126);
    pixExpected[0][1] = new Pixel(85, 85, 85);
    pixExpected[1][0] = new Pixel(66, 66, 66);
    pixExpected[1][1] = new Pixel(75, 75, 75);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void greyScaleTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\ngreyscale small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(119, 119, 119);
    pixExpected[0][1] = new Pixel(182, 182, 182);
    pixExpected[1][0] = new Pixel(80, 80, 80);
    pixExpected[1][1] = new Pixel(32, 32, 32);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void sepiaTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nsepia small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(170, 151, 118);
    pixExpected[0][1] = new Pixel(196, 174, 136);
    pixExpected[1][0] = new Pixel(97, 87, 67);
    pixExpected[1][1] = new Pixel(57, 51, 40);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void BlurTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nfilter-blur small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(51, 69, 43);
    pixExpected[0][1] = new Pixel(28, 88, 71);
    pixExpected[1][0] = new Pixel(58, 55, 57);
    pixExpected[1][1] = new Pixel(44, 72, 96);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void sharpenTest() {
    StringReader reader = new StringReader("load /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small"
            + "\nfilter-sharpen small small2"
            + "\nsave /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/wing-sepia.png" +
            " small2");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    Pixel[][] pix = control.getImage("small2");
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(90, 113, 255);
    pixExpected[0][1] = new Pixel(0, 50, 89);
    pixExpected[1][0] = new Pixel(38, 0, 30);
    pixExpected[1][1] = new Pixel(226, 234, 255);
    for (int row = 0; row < pixExpected.length; row++) {
      for (int col = 0; col < pixExpected[0].length; col++) {
        int rPix = pix[row][col].getRed();
        int gPix = pix[row][col].getGreen();
        int bPix = pix[row][col].getBlue();
        int rPixExpected = pixExpected[row][col].getRed();
        int gPixExpected = pixExpected[row][col].getGreen();
        int bPixExpected = pixExpected[row][col].getBlue();
        assertEquals(rPixExpected, rPix);
        assertEquals(gPixExpected, gPix);
        assertEquals(bPixExpected, bPix);
      }
    }
  }

  @Test
  public void parseScript() {
    String filepath = "/Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/test/Script";
    ScriptController control = new ScriptController(filepath);
    control.execute();
    String[] commands = control.getParsedCommands();
    String[] expected = new String[5];
    expected[0] = "load /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/beach.png beach";
    expected[1] = "sepia beach beach2";
    expected[2] = "horizontal-flip beach2 beach3";
    expected[3] = "vertical-flip beach3 beach4";
    expected[4] = "save /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/beach4.png beach4";
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], commands[i]);
    }
  }

  @Test
  public void controlScript() {
    ScriptController control = new ScriptController("/Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/test/Script");
    control.execute();
    String[] commands = control.getParsedCommands();
    String[] expected = new String[5];
    expected[0] = "load /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/beach.png beach";
    expected[1] = "sepia beach beach2";
    expected[2] = "horizontal-flip beach2 beach3";
    expected[3] = "vertical-flip beach3 beach4";
    expected[4] = "save /Users/migu31/Desktop/OODSavedWorks/OODPhotoshop/code13/beach4.png beach4";
    for (int i = 0; i < expected.length; i++) {
      assertEquals(expected[i], commands[i]);
    }
  }

  @Test
  public void testNotValidInput() {
    StringReader reader = new StringReader("blah /Users/migu31/Desktop/OODSavedWorks/" +
            "OODPhotoshop/code13/smallBackground2.ppm small");
    Appendable out = new StringBuilder();
    ScannerController control = new ScannerController(reader, out);
    control.execute();
    assertEquals(out.toString(), "not a valid input\n");
  }
}
