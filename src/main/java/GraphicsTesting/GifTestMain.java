package GraphicsTesting;
//Code base from http://www.java2s.com/Tutorials/Java/Graphics/Image/Draw_gif_image_in_Java.htm

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GifTestMain extends JComponent implements ActionListener{

    private int x = 0;
    private int y = 0;
    Timer timer;
    public GifTestMain(){
        this.timer = new Timer(5,this);
        this.setBackground(Color.GREEN);
        this.setOpaque(true);
    }


    public void paint(Graphics g){
        Graphics2D g2D = (Graphics2D) g;//Conversion from g to g2D
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image fireball = toolkit.getImage("src/fireball.gif");
        g2D.drawImage(fireball, x,y,this);

        timer.start();
    }

    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setBounds(30,30,650,650);
        window.getContentPane().add(new GifTestMain());
        window.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();//Paint and redraws
    }
}
