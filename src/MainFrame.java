import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        this.canvas = new DrawingPanel(this);
        this.configPanel = new ConfigPanel(this);
        this.controlPanel = new ControlPanel(this);

        //arrange the components in the container (frame)
        //JFrame uses a BorderLayout by default
        this.add(configPanel, BorderLayout.NORTH);
        this.add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        this.add(controlPanel, BorderLayout.SOUTH);
        this.setSize(new Dimension(DrawingPanel.W, DrawingPanel.H));

        //invoke the layout manager
        pack();
    }
}
