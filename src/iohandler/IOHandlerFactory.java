package iohandler;

/**
 * Factory class for IOHandler creates the IOHandler based on the given file extension.
 */
public class IOHandlerFactory {

  /**
   * Creates a IOHandler based on the file extension of the given file path.
   *
   * @param path used to determine the file type
   * @return IIOHandler
   */
  public IIOHandler createIOHandler(String path) {
    String extension = ImageUtil.getExtension(path);
    switch (extension) {
      case ".png":
        return new PngIOHandler();
      case ".jpg":
      case ".bmp":
        return new StandardIOHandler();
      case ".ppm":
        return new PpmIOHandler();
      default:
        throw new IllegalArgumentException("Invalid file type");
    }
  }
}
