package testing.GraphicsTesting;
import java.awt.*;
import java.awt.Font;//Fuente
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;//JPanel
import java.awt.geom.GeneralPath;//Geometry
import java.awt.geom.Path2D;

import static java.awt.event.KeyEvent.*;

public class PanelTest extends JPanel implements ActionListener, KeyListener{
   final int PANEL_WIDTH = 600;
   final int PANEL_HEIGHT = 400;
   //java.awt
   private Image robot;
   private Image backgroundImage;
   private Image ball;
   private Timer timer;
   private double xVelocity = 0;
   private double yVelocity = 0;
   private double xVelocityBall = 2;
   private double yVelocityBall = 1;
   private double xCoordBall = 500;
   private double yCoordBall = 300;
   private double x = 0;
   private double y = 0;

   public void moveX(int pX){
       this.x += pX;
   }

   public void moveY(int pY){
       this.y += pY;
   }
   public PanelTest(){
       timer = new Timer(0, this);
       this.timer.start();
       this.addKeyListener(this);
       setFocusable(true);
       setFocusTraversalKeysEnabled(false);


       this.x = 0;
       this.y = 0;
       this.xVelocity = 0;
       this.yVelocity = 0;


       //Background type image
       this.setBackground(Color.GREEN);
       backgroundImage = new ImageIcon("src/Background.jpg").getImage();
       //To create an image->This makes an image out of the image icon
       this.robot = new ImageIcon("src/robotRock.png").getImage();
       Image modRobot = robot.getScaledInstance(90,90,java.awt.Image.SCALE_SMOOTH);
       this.ball = new ImageIcon("src/ball.png").getImage();
       Image modBall = ball.getScaledInstance(90,90, java.awt.Image.SCALE_SMOOTH);
       this.ball = new ImageIcon(modBall).getImage();
       this.robot = new ImageIcon(modRobot).getImage();
       this.setOpaque(true);
   }



   public void paint(Graphics g){
       super.paintComponent(g);
       Graphics2D g2D = (Graphics2D) g;//Conversion a graphics 2D

       g2D.setFont(new Font("Italic",Font.ITALIC,20));
       g2D.drawString("Programación orientada a objetos...",10,350);

       g2D.drawLine(10,300,50,300);
       g2D.drawRect(400,20,90,60);

       Ellipse2D circle = new Ellipse2D.Double(xCoordBall, yCoordBall,40,40);
       g2D.fill(circle);

       g2D.setPaint(Color.blue);
       g2D.fillRoundRect(250,20,70,60,25,25);

       g2D.setPaint(Color.yellow);
       int[] xVertices = {100,160,225};//Coordinates of x axis triangle
       int[] yVertices = {200,150,200};//Coordinates of y axis triangle
       g2D.fillPolygon(xVertices,yVertices,3);

       Path2D pathStar = new GeneralPath(GeneralPath.WIND_NON_ZERO);
       g2D.setPaint(Color.RED);
       g2D.fill(createStar(350, 200, 40, 60, 10, 0));

       g2D.setPaint(Color.GREEN);
       g2D.drawOval(40,400,80,80);
       g2D.drawImage(robot, (int) x,(int) y,null);
   }


    private static Shape createStar(double centerX, double centerY,
                                    double innerRadius, double outerRadius, int numRays,
                                    double startAngleRad)
    {
        Path2D path = new Path2D.Double();
        double deltaAngleRad = Math.PI / numRays;
        for (int i = 0; i < numRays * 2; i++)
        {
            double angleRad = startAngleRad + i * deltaAngleRad;
            double ca = Math.cos(angleRad);
            double sa = Math.sin(angleRad);
            double relX = ca;
            double relY = sa;
            if ((i & 1) == 0)
            {
                relX *= outerRadius;
                relY *= outerRadius;
            }
            else
            {
                relX *= innerRadius;
                relY *= innerRadius;
            }
            if (i == 0)
            {
                path.moveTo(centerX + relX, centerY + relY);
            }
            else
            {
                path.lineTo(centerX + relX, centerY + relY);
            }
        }
        path.closePath();
        return path;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

       if(xCoordBall < 0 || xCoordBall > 545){//-55 //original 545
           xVelocityBall =-xVelocityBall;
       }
       if(yCoordBall < 0 || yCoordBall > 320){//-70 //original 320
           yVelocityBall = -yVelocityBall;
       }
       xCoordBall += xVelocityBall;
       yCoordBall += yVelocityBall;


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
       //1 up right
       if(code == KeyEvent.VK_UP && code == KeyEvent.VK_RIGHT) {
           yVelocity = 0;
           xVelocity = 0;
       }
       // 2 up left
       if(code == KeyEvent.VK_UP && code == KeyEvent.VK_LEFT) {
           yVelocity = 0;
           xVelocity = 0;
       }
        //3 down left
       if(code == KeyEvent.VK_DOWN && code == KeyEvent.VK_LEFT) {
           yVelocity = 0;
           xVelocity = 0;
       }
        //4 down right
       if(code == KeyEvent.VK_DOWN && code == KeyEvent.VK_LEFT) {
           yVelocity = 0;
           xVelocity = 0;
       }
    }
}
