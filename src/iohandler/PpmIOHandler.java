package iohandler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import model.Pixel;

/**
 * class handles ppm file input output.
 */
public class PpmIOHandler extends AIOHandler {

  @Override
  public Pixel[][] load(String imageFile) throws IOException {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(imageFile));
    } catch (FileNotFoundException e) {
      throw new IOException("File " + imageFile + " not found!");
    }

    StringBuilder builder = new StringBuilder();
    while (sc.hasNextLine()) {
      String s = sc.nextLine();
      if (s.charAt(0) != '#') {
        builder.append(s + System.lineSeparator());
      }
    }
    sc = new Scanner(builder.toString());
    String token;
    token = sc.next();
    if (!token.equals("P3")) {
      throw new IOException("Invalid PPM file: plain RAW file should begin with P3");
    }
    int width = sc.nextInt();
    int height = sc.nextInt();
    int maxValue = sc.nextInt();
    Pixel[][] image = new Pixel[width][height];
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        image[j][i] = new Pixel(sc.nextInt(), sc.nextInt(), sc.nextInt());
      }
    }
    return image;
  }

  @Override
  public void save(String path, Pixel[][] image) throws IOException {
    try {
      PrintWriter newFile = new PrintWriter(path);
      newFile.println("P3");
      newFile.println(image.length + " " + image[0].length);
      newFile.println("255");
      for (int row = 0; row < image[0].length; row++) {
        for (int col = 0; col < image.length; col++) {
          if (col == image.length - 1) {
            newFile.println(image[col][row].toString());
          } else {
            newFile.print(image[col][row].toString() + " ");
          }
        }

      }
      newFile.flush();
      newFile.close();
    } catch (FileNotFoundException e) {
      throw new IOException("file not found");
    }
  }

  @Override
  public String getType() {
    return "ppm";
  }
}
