package view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import model.Pixel;

/**
 * This class is for testing proposes.
 */
public class GUIViewMock extends GUIAbstract {
  private Pixel[][] image;

  private String currentAddress;

  /**
   * Public only in mock for testing purposes.
   */
  public ActionListener listener;

  /**
   * Constructor for the mock.
   */
  public GUIViewMock() {
    setTitle("OODPhotoshop©");
    setSize(2000, 1000);
  }

  public void setImage(Pixel[][] image) {
    this.image = image;
  }

  @Override
  public void display() {
    JPanel background = new JPanel();
  }

  public void setListener(ActionListener listener) {
    this.listener = listener;
  }

  public void setCurrentAddress(String address) {
    this.currentAddress = address;
  }

  public String getCurrentAddress() {
    return this.currentAddress;
  }

  public Pixel[][] getImage() {
    return this.image;
  }


  private void addImage(JPanel background) {
    //show an image with a scrollbar
    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image"));
    imagePanel.setLayout(new GridLayout(1, 1, 10, 10));
    imagePanel.setPreferredSize(new Dimension(700, 700));

    background.add(imagePanel);

    JPanel pixelImage = new ImagePanel(this.image);
    imagePanel.add(pixelImage);
    JScrollPane scroll = new JScrollPane(pixelImage);
    imagePanel.add(scroll);
  }

  private void addHistogram(JPanel background) {
    //show an image with a scrollbar
    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image"));
    imagePanel.setLayout(new GridLayout(1, 1, 10, 10));
    imagePanel.setMaximumSize(new Dimension(400, 400));
    background.add(imagePanel);
    JPanel pixelImage = new HistogramPanel(this.image);
    imagePanel.add(pixelImage);
  }

  private void addCommands(JPanel background) {
    JPanel commandsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    commandsPanel.setBorder(BorderFactory.createTitledBorder("Commands"));
    commandsPanel.setLayout(new BoxLayout(commandsPanel, BoxLayout.Y_AXIS));
    background.add(commandsPanel);
    this.addButton(commandsPanel, "versions", "versions");
    this.addButton(commandsPanel, "brighten", "brighten");
    this.addButton(commandsPanel, "horizontal-flip", "horizontal-flip");
    this.addButton(commandsPanel, "vertical-flip", "vertical-flip");
    this.addButton(commandsPanel, "value-component", "value-component");
    this.addButton(commandsPanel, "luma-component", "luma-component");
    this.addButton(commandsPanel, "intensity-component", "intensity-component");
    this.addButton(commandsPanel, "red-component", "red-component");
    this.addButton(commandsPanel, "green-component", "green-component");
    this.addButton(commandsPanel, "blue-component", "blue-component");
    this.addButton(commandsPanel, "sepia", "sepia");
    this.addButton(commandsPanel, "greyscale", "greyscale");
    this.addButton(commandsPanel, "filter-blur", "filter-blur");
    this.addButton(commandsPanel, "filter-sharpen", "filter-sharpen");
  }


  private void addButton(JPanel background, String name, String actionCommand) {
    JButton button = new JButton(name);
    button.setActionCommand(actionCommand);
    button.addActionListener(this.listener);
    background.add(button);
  }

  private void addLoadNSave(JPanel background) {
    JPanel loading = new JPanel(new FlowLayout(FlowLayout.CENTER));
    loading.setBorder(BorderFactory.createTitledBorder("Upload or save an image"));
    loading.setLayout(new BoxLayout(loading, BoxLayout.Y_AXIS));
    background.add(loading);
    this.addButton(loading, "      load      ", "load");
    this.addButton(loading, "      save      ", "save");
  }
}
