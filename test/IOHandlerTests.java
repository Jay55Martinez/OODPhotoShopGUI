import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import iohandler.IIOHandler;
import iohandler.IOHandlerFactory;
import iohandler.PngIOHandler;
import iohandler.PpmIOHandler;
import iohandler.StandardIOHandler;
import model.Pixel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * tests IOHandler.
 */
public class IOHandlerTests {

  Pixel[][] image;

  @Before
  public void setUp() {
    image = new Pixel[][]{
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
  }

  @Test
  public void testCreatePNG() {
    IOHandlerFactory factory = new IOHandlerFactory();
    IIOHandler io = factory.createIOHandler("myfile.png");
    assertEquals("png", io.getType());
  }

  @Test
  public void testCreatPPM() {
    IOHandlerFactory factory = new IOHandlerFactory();
    IIOHandler io = factory.createIOHandler("myfile.ppm");
    assertEquals("ppm", io.getType());
  }

  @Test
  public void testCreateStandardJPG() {
    IOHandlerFactory factory = new IOHandlerFactory();
    IIOHandler io = factory.createIOHandler("myfile.jpg");
    assertEquals("standard jpg/bmp", io.getType());
  }

  @Test
  public void testCreateStandardBMP() {
    IOHandlerFactory factory = new IOHandlerFactory();
    IIOHandler io = factory.createIOHandler("myfile.bmp");
    assertEquals("standard jpg/bmp", io.getType());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidExtension() {
    IOHandlerFactory factory = new IOHandlerFactory();
    IIOHandler io = factory.createIOHandler("myfile.txt");
  }

  @Test
  public void testLoadAndSavePPM() throws IOException {
    IIOHandler handler = new PpmIOHandler();
    Pixel[][] loadedImage =
            handler.load("/Users/jaymartinez/Downloads/smallBackground.ppm");
    assertTrue(sameArray(image, loadedImage));

    handler.save("/Users/jaymartinez/Downloads/saveTest.ppm", loadedImage);
    Pixel[][] loadedSavedImage =
            handler.load("/Users/jaymartinez/Downloads/saveTest.ppm");
    assertTrue(sameArray(image, loadedSavedImage));
  }

  @Test
  public void testPngLoadAndSave() throws IOException {
    IIOHandler handler = new PngIOHandler();
    Pixel[][] loadedImage =
            handler.load("/Users/jaymartinez/Downloads/smallBackground.png");
    assertTrue(sameArray(image, loadedImage));

    handler.save("/Users/jaymartinez/Downloads/saveTest.png", loadedImage);
    Pixel[][] loadedSavedImage =
            handler.load("/Users/jaymartinez/Downloads/saveTest.png");
    assertTrue(sameArray(image, loadedSavedImage));
  }

  @Test
  public void testStandardLoadAndSave() throws IOException {
    //because of compression the pixels values will change so the test just check if the files
    //are loaded into the program and saved
    IIOHandler handler = new StandardIOHandler();
    handler.save("/Users/jaymartinez/Downloads/saveTest.jpg", image);
    Pixel[][] loadedSavedImage =
            handler.load("/Users/jaymartinez/Downloads/saveTest.jpg");
    assertTrue(loadedSavedImage != null);

    handler.save("/Users/jaymartinez/Downloads/smallBackground.bmp", image);
    Pixel[][] loadedImage =
            handler.load("/Users/jaymartinez/Downloads/smallBackground.bmp");
    assertTrue(loadedImage != null);
  }

  @Test(expected = IOException.class)
  public void testLoadFileNotFoundStandard() throws IOException {
    new StandardIOHandler().load("Uers/jayartinez/Down/smallBackground.bmp");
  }

  @Test(expected = IOException.class)
  public void testLoadFileNotFoundPPM() throws IOException {
    new PpmIOHandler().load("/Usayartinez/Downloads/smallBackground.ppm");
  }

  @Test(expected = IOException.class)
  public void testLoadFileNotFoundPNG() throws IOException {
    new PngIOHandler().load("/Users/jayartinez/Dowds/smallBackground.png");
  }

  @Test(expected = IOException.class)
  public void testSaveFileNotFoundStandard() throws IOException {
    new StandardIOHandler().save("/Uers/jayartinez/Down/smallBackground.bmp", image);
  }

  @Test(expected = IOException.class)
  public void testSaveFileNotFoundPNG() throws IOException {
    new PngIOHandler().save("/Users/jayartinez/Dowds/smallBackground.png", image);
  }

  @Test(expected = IOException.class)
  public void testSaveFileNotFoundPPM() throws IOException {
    new PpmIOHandler().save("/Usayartinez/Downloads/smallBackground.ppm", image);
  }

  //helper method
  private boolean sameArray(Pixel[][] expected, Pixel[][] actual) {
    if (expected.length != actual.length) {
      return false;
    }
    for (int row = 0; row < image.length; row++) {
      for (int col = 0; col < image[0].length; col++) {
        if (!(expected[row][col].equals(actual[row][col]))) {
          return false;
        }
      }
    }
    return true;
  }
}
