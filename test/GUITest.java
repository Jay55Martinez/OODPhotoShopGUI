import org.junit.Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.GUIController;
import controller.IController;
import model.DefaultPhotoModel;
import model.Pixel;
import view.GUIViewMock;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * tests for the GUIView class.
 */
public class GUITest {

  @Test
  public void testingGUIFLipHor() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = pixel3;
    pixExpected[0][1] = pixel4;
    pixExpected[1][0] = pixel1;
    pixExpected[1][1] = pixel2;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "horizontal-flip");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2horizontal-flip", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingGUIFLipVer() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = pixel2;
    pixExpected[0][1] = pixel1;
    pixExpected[1][0] = pixel4;
    pixExpected[1][1] = pixel3;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "vertical-flip");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2vertical-flip", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingRedComponent() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = pixel4;
    pixExpected[0][1] = new Pixel(250, 250, 250);
    pixExpected[1][0] = pixel4;
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "red-component");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2red-component", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingGreenComponent() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(250, 250, 250);
    pixExpected[0][1] = pixel4;
    pixExpected[1][0] = pixel4;
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "green-component");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2green-component", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingBlueComponent() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = pixel4;
    pixExpected[0][1] = pixel4;
    pixExpected[1][0] = new Pixel(250, 250, 250);
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "blue-component");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2blue-component", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingValueComponent() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(250, 250, 250);
    pixExpected[0][1] = new Pixel(250, 250, 250);
    pixExpected[1][0] = new Pixel(250, 250, 250);
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "value-component");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2value-component", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingLumaComponent() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(180, 180, 180);
    pixExpected[0][1] = new Pixel(52, 52, 52);
    pixExpected[1][0] = new Pixel(17, 17, 17);
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "luma-component");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2luma-component", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingIntensityComponent() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(83, 83, 83);
    pixExpected[0][1] = new Pixel(83, 83, 83);
    pixExpected[1][0] = new Pixel(83, 83, 83);
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "intensity-component");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2intensity-component", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingFilterBlur() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(31, 62, 31);
    pixExpected[0][1] = new Pixel(62, 31, 15);
    pixExpected[1][0] = new Pixel(15, 31, 62);
    pixExpected[1][1] = new Pixel(31, 15, 31);

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "filter-blur");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2filter-blur", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingFilterSharpen() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(62, 62, 62);
    pixExpected[0][1] = new Pixel(62, 0, 0);
    pixExpected[1][0] = new Pixel(0, 0, 62);
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "filter-sharpen");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2filter-sharpen", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingSepia() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(192, 171, 133);
    pixExpected[0][1] = new Pixel(98, 87, 68);
    pixExpected[1][0] = new Pixel(47, 42, 32);
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "sepia");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2sepia", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testingGreyscale() {
    Pixel pixel1 = new Pixel(0, 250, 0);
    Pixel pixel2 = new Pixel(250, 0, 0);
    Pixel pixel3 = new Pixel(0, 0, 250);
    Pixel pixel4 = new Pixel(0, 0, 0);
    Pixel[][] pix = new Pixel[2][2];
    pix[0][0] = pixel1;
    pix[0][1] = pixel2;
    pix[1][0] = pixel3;
    pix[1][1] = pixel4;
    Pixel[][] pixExpected = new Pixel[2][2];
    pixExpected[0][0] = new Pixel(178, 178, 178);
    pixExpected[0][1] = new Pixel(53, 53, 53);
    pixExpected[1][0] = new Pixel(18, 18, 18);
    pixExpected[1][1] = pixel4;

    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    ActionEvent e = new ActionEvent(view, 0, "greyscale");
    controller.actionPerformed(e);
    Pixel[][] realPix = view.getImage();
    assertEquals("image2greyscale", view.getCurrentAddress());
    for (int i = 0; i < pixExpected.length; i++) {
      for (int j = 0; j < pixExpected[0].length; j++) {
        assertEquals(pixExpected[i][j].getRed(), realPix[i][j].getRed());
        assertEquals(pixExpected[i][j].getGreen(), realPix[i][j].getGreen());
        assertEquals(pixExpected[i][j].getBlue(), realPix[i][j].getBlue());
      }
    }
  }

  @Test
  public void testSetListener() {
    Pixel[][] pix = new Pixel[0][0];
    DefaultPhotoModel model = new DefaultPhotoModel(pix);
    GUIViewMock view = new GUIViewMock();
    GUIController controller = new GUIController(model, view, pix);
    view.setListener(controller);
    assertEquals(view.listener,controller);
    assertTrue(view.listener instanceof ActionListener);
    assertTrue(view.listener instanceof IController);
  }
}
