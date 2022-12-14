package graphicstesting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

public class PanelTest extends JPanel implements ActionListener, KeyListener{
   final int PANEL_WIDTH = 600;
   final int PANEL_HEIGHT = 400;
   //java.awt
   private Image robot;
   private Image fireTrap;
   private Timer timer;
   private double xVelocity = 0;
   private double yVelocity = 0;
   private double xVelocityBall = 2;
   private double yVelocityBall = 1;
   private double xCoordBall = 500;
   private double yCoordBall = 300;
   private double x = 0;
   private double y = 200;

   public void moveX(int pX){
       this.x += pX;
   }

   public void moveY(int pY){
       this.y += pY;
   }
   public PanelTest(){
       this.addKeyListener(this);
       setFocusable(true);
       setFocusTraversalKeysEnabled(false);

       //Background of this panel
       this.setBackground(Color.GREEN);
       //To create an image->This makes an image out of the image icon
       this.robot = new ImageIcon("src/main/java/images/robotRock.png").getImage();
       Image modRobot = robot.getScaledInstance(90,90, Image.SCALE_SMOOTH);
       this.robot = new ImageIcon(modRobot).getImage();
/*
       Toolkit toolkit = Toolkit.getDefaultToolkit();
       Image fireTrap = toolkit.getImage("src/main/java/images/fireTrap.gif");
*/

       this.setOpaque(true);

       timer = new Timer(5, this);
       this.timer.start();
   }

   public void paint(Graphics g){
       super.paintComponent(g);
       Graphics2D g2D = (Graphics2D) g;//Conversion a graphics 2D
/*
       g2D.setFont(new Font("Italic",Font.ITALIC,20));
       g2D.drawString("Programación orientada a objetos...",10,350);

       g2D.drawLine(10,300,50,300);
       g2D.drawRect(400,20,65,60);
       Toolkit toolkit = Toolkit.getDefaultToolkit();
       Image fireTrap = toolkit.getImage("src/main/java/images/fireTrap.gif");
       g2D.drawImage(fireTrap, (int) 390, (int) 285,this);

       Ellipse2D circle = new Ellipse2D.Double(xCoordBall, yCoordBall,40,40);
       g2D.fill(circle);

       g2D.setPaint(Color.blue);
       g2D.fillRoundRect(250,20,70,60,25,25);

       g2D.setPaint(Color.yellow);
       int[] xVertices = {100,160,225};//Coordinates of x axis triangle
       int[] yVertices = {200,150,200};//Coordinates of y axis triangle
       g2D.fillPolygon(xVertices,yVertices,3);

//
       g2D.setPaint(Color.RED);
//
       g2D.fillRect(400, 320,20,60);

       int xPnts[] = {42, 52, 72, 52, 60, 40, 15, 28, 9, 32, 42};//Polygons that do not close
       int yPnts[] = {38, 62, 68, 80, 105, 85, 102, 75, 58, 60, 38};
       g2D.fillPolygon(xPnts, yPnts, xPnts.length);

       int xValues[] = { 350,400,420,440};
       int yValues[] = { 200,150,230,240};
       g2D.drawPolyline( xValues, yValues, xValues.length);

       g2D.setPaint(Color.GREEN);
       g2D.drawOval(40,400,80,80);*/
       g2D.drawImage(robot, (int) x,(int) y,null);
   }

    @Override
    public void actionPerformed(ActionEvent e) {
/*
       if(xCoordBall < 0 || xCoordBall > 545){//-55 //original 545
           xVelocityBall =-xVelocityBall;
       }
       if(yCoordBall < 0 || yCoordBall > 320){//-70 //original 320
           yVelocityBall = -yVelocityBall;
       }
       xCoordBall += xVelocityBall;
       yCoordBall += yVelocityBall;
*/

       x += xVelocity;
       y += yVelocity;
       repaint();
   }

    public void up(){
       yVelocity = -1.5;
       xVelocity = 0;
    }

    public void down(){
        yVelocity = 1.5;
        xVelocity = 0;
    }

    public void left(){
        xVelocity = -2.5;
        yVelocity = 0;
    }

    public void right(){
        xVelocity = 2.5;
        yVelocity = 0;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

       int code = e.getKeyCode();

       if (code == KeyEvent.VK_UP)
           up();
       if (code == KeyEvent.VK_DOWN)
           down();
       if (code == KeyEvent.VK_LEFT)
           left();
       if (code == KeyEvent.VK_RIGHT)
           right();
    }

    @Override
    public void keyReleased(KeyEvent e) {
       int code = e.getKeyCode();

       if(code == KeyEvent.VK_UP)
           yVelocity=0;
       if(code == KeyEvent.VK_DOWN)
           yVelocity=0;
       if(code == KeyEvent.VK_LEFT)
           xVelocity=0;
       if(code == KeyEvent.VK_RIGHT)
           xVelocity=0;
    }
}
