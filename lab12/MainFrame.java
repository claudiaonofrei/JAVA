import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    ControlPanel controlPanel;
    DesignPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        this.canvas = new DesignPanel(this);
        this.controlPanel = new ControlPanel(this);


        this.add(canvas, BorderLayout.CENTER); //this is BorderLayout.CENTER
        this.add(controlPanel, BorderLayout.SOUTH);
        this.setSize(new Dimension(DesignPanel.W, DesignPanel.H));

        //invoke the layout manager
        pack();
    }

    public static void main(String[] args) {
        Frame f = new MainFrame();
        f.pack();
        f.setVisible(true);
    }
}
