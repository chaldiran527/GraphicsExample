package testing.GraphicsTesting;

import javax.swing.*;
import java.awt.*;
import model.IConstants;

public class FrameTest extends JFrame {
    PanelTest panel;
    JLabel label;
    public FrameTest(String pTitle){
        this.panel = new PanelTest();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.setTitle(pTitle);
        this.setBackground(Color.GREEN);
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
