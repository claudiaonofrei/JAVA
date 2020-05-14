import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JComboBox colorCombo; // the color of the shape

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        JButton bttn = new JButton("Add selected comp!");

        bttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Class clazz = null;
                try {
                    clazz = Class.forName((String) colorCombo.getItemAt(frame.controlPanel.colorCombo.getSelectedIndex()));
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                Component cmp = null;
                try {
                    cmp = (Component)  clazz.newInstance();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }

                frame.canvas.add(cmp);
                frame.canvas.revalidate();
                frame.canvas.repaint();


                Random r = new Random();
                assert cmp != null;
                cmp.setLocation(r.nextInt((frame.getWidth()  + 1)), r.nextInt((frame.getHeight()  + 1)));
                cmp.setSize(20,20);
            }
        });

        add(bttn);



        this.colorCombo = new JComboBox(new String []{
                "javax.swing.JCheckBox",
                "javax.swing.JRadioButton",
                "javax.swing.JLabel",
                "javax.swing.JList",
                "javax.swing.JTable",
                "javax.swing.JSlider",
                "javax.swing.JMenu",
                "javax.swing.JComboBox",
                "javax.swing.JButton"});

        add(colorCombo);
    }
}