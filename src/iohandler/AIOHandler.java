package iohandler;

import java.io.IOException;

import model.Pixel;

/**
 * Abstract class for IIOHandler.
 */
public abstract class AIOHandler implements IIOHandler {

  @Override
  public Pixel[][] load(String imageFile) throws IOException {
    return ImageUtil.readImage(imageFile);
  }

  @Override
  public void save(String path, Pixel[][] image) throws IOException {
    ImageUtil.saveImage(path, image, ImageUtil.getExtension(path));
  }

  @Override
  public String getType() {
    return "standard jpg/bmp";
  }
}
