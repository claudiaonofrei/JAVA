import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    //create all buttons (Load, Reset, Exit)
    JButton loadBttn = new JButton("Load");
    JButton resetBttn = new JButton("Reset");
    JButton exitBttn = new JButton("Exit");

    public ControlPanel(MainFrame frame) {
        this.frame = frame; init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 5));
        //add all buttons
        this.add(saveBtn, BorderLayout.WEST);
        this.add(resetBttn, BorderLayout.CENTER);
        this.add(loadBttn, BorderLayout.CENTER);
        this.add(exitBttn, BorderLayout.EAST);
        //configure listeners for all buttons
        saveBtn.addActionListener(this::save);
        resetBttn.addActionListener(this::reset);
        loadBttn.addActionListener(this::load);
        exitBttn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        try {
            ImageIO.write(frame.canvas.image, "PNG", new File("E:\\faculty\\JAVA\\laborator6\\test.png"));
        } catch (IOException ex) { System.err.println(ex.getMessage()); }
    }
    public void reset(ActionEvent e) {
        frame.canvas.image = new BufferedImage(DrawingPanel.W, DrawingPanel.H, BufferedImage.TYPE_INT_ARGB);
        frame.canvas.graphics = frame.canvas.image.createGraphics();
        frame.canvas.graphics.setColor(Color.WHITE); //fill the image with white

        frame.canvas.graphics.drawImage(frame.canvas.image, 0, 0, this);
        frame.canvas.graphics.fillRect(0, 0, DrawingPanel.W, DrawingPanel.H);
    }
    public void load(ActionEvent e){
        BufferedImage img = null;
        try{
            img = ImageIO.read(new File("E:\\faculty\\JAVA\\laborator6\\test.png"));
            frame.canvas.image = img;
            frame.canvas.graphics = frame.canvas.image.createGraphics();
            frame.canvas.graphics.drawImage(img, 0, 0, this);

        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
    public void exit(ActionEvent e){
        System.exit(2);
    }
}