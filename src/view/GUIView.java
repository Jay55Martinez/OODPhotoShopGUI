package view;

import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;

import model.Pixel;

/**
 * This class represents the GUI view of the program.
 */
public class GUIView extends GUIAbstract {
  private Pixel[][] image;

  private String currentAddress;

  private ActionListener listener;

  /**
   * Constructor for the GUI view.
   */
  public GUIView() {
    super();
    setTitle("OODPhotoshop©");
    setSize(2000, 1000);
  }

  @Override
  public void setImage(Pixel[][] image) {
    this.image = image;
  }

  @Override
  public void setListener(ActionListener listener) {
    this.listener = listener;
  }

  @Override
  public void setCurrentAddress(String address) {
    this.currentAddress = address;
  }

  @Override
  public String getCurrentAddress() {
    return this.currentAddress;
  }

  @Override
  public void display() {
    JPanel background = new JPanel();
    background.setLayout(new BoxLayout(background, BoxLayout.PAGE_AXIS));
    JScrollPane scroll = new JScrollPane(background);
    JPanel section1 = new JPanel();
    section1.setLayout(new BoxLayout(section1, BoxLayout.X_AXIS));
    JPanel section2 = new JPanel();
    section2.setLayout(new BoxLayout(section2, BoxLayout.X_AXIS));
    this.add(scroll);
    this.addHistogram(section1);
    this.addImage(section1);
    this.addCommands(section1);
    background.add(section1);
    this.addLoadNSave(section2);
    background.add(section2);
    this.add(background);
  }

  // add the image to the GUI view.
  private void addImage(JPanel background) {
    //show an image with a scrollbar
    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    //a border around the panel with a caption
    imagePanel.setBorder(BorderFactory.createTitledBorder("Current Image"));
    imagePanel.setLayout(new GridLayout(1, 1, 10, 10));
    imagePanel.setPreferredSize(new Dimension(700, 700));
    background.add(imagePanel);
    JPanel pixelImage = new ImagePanel(this.image);
    imagePanel.add(pixelImage);
    JScrollPane scroll = new JScrollPane(pixelImage);
    imagePanel.add(scroll);
  }

  // add the histogram to the GUI view.
  private void addHistogram(JPanel background) {
    //show an image with a scrollbar
    JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    imagePanel.setBorder(BorderFactory.createTitledBorder("Histogram"));
    imagePanel.setLayout(new GridLayout(1, 1, 10, 10));
    imagePanel.setMaximumSize(new Dimension(400, 400));
    background.add(imagePanel);
    JPanel pixelImage = new HistogramPanel(this.image);
    imagePanel.add(pixelImage);
  }

  // add the button commands to the GUI view.
  private void addCommands(JPanel background) {
    JPanel commandsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    commandsPanel.setBorder(BorderFactory.createTitledBorder("Commands"));
    commandsPanel.setLayout(new BoxLayout(commandsPanel, BoxLayout.Y_AXIS));
    background.add(commandsPanel);
    this.addButton(commandsPanel, "versions", "versions");
    this.addButton(commandsPanel, "brighten", "brighten");
    this.addButton(commandsPanel, "darken", "darken");
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


  // helper method to add buttons to the GUI view.
  private void addButton(JPanel background, String name, String actionCommand) {
    JButton button = new JButton(name);
    button.setActionCommand(actionCommand);
    button.addActionListener(this.listener);
    background.add(button);
  }

  // add the load and save buttons to the GUI view.
  private void addLoadNSave(JPanel background) {
    JPanel loading = new JPanel(new FlowLayout(FlowLayout.CENTER));
    loading.setBorder(BorderFactory.createTitledBorder("Upload or save an image"));
    loading.setLayout(new BoxLayout(loading, BoxLayout.Y_AXIS));
    background.add(loading);
    this.addButton(loading, "      load      ", "load");
    this.addButton(loading, "      save      ", "save");
  }
}
