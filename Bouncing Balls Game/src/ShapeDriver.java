////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab8
//  @Author  
//
///////////////////////////////////////////////////////////////////////////////////
 
// These are the imports I used 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Rectangle;
import javax.swing.*;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
//Jamar Golden jamgolde
/*
 * Driver program for randam shape generator app
 */
public class ShapeDriver extends JPanel implements ActionListener, KeyListener {

    int x;
    int y;
    int y1;
    int length;
    int x1;
    int width;
    Color switchColor;
    private Timer timer;

    ArrayList<Rectangle> shapeList = new ArrayList<Rectangle>();
    ArrayList<Circle> cirlcList = new ArrayList<Circle>();
    ArrayList<Color> Colors = new ArrayList<Color>();
    // Panel constants
    public final int FRAME_WIDTH = 600;
    public final int FRAME_HEIGHT = 600;

    Random random = new Random();
    JPanel shapeDrivers;
    public ShapeDriver() {
        super();

        /* T0-DO: 
         *  - set up JPanel
         *  - initialize any other fiels you want to declare and use
         *  - add the KeyListiner 
         */
        this.setBackground(Color.black);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);

        // the second argument to the Timer Constructor takes an ActionListener
        // the this key word informs the JVM to look inside this class for
        // the actionPerformed method that must be overridden when
        // ActionListener is implemented
        // Every tick of the clock will now run the actionPerformed method

        Colors.add(Color.red);
        Colors.add(Color.blue);
        Colors.add(Color.pink);
        Colors.add(Color.green);
        Colors.add(Color.yellow);
        Colors.add(Color.orange);

        timer = new Timer(1000/60, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        // call super class paintComponent method
        // background will not be colored otherwise
        super.paintComponent(g);

        // TO-DO use the different Shapes draw methods here
        // The draw methods in the differnet shapes should take 
        // The Graphics object should be passed to the Shapes Draw method
        for (Circle s: cirlcList){
            s.draw(g);

        }

    }
    // Method that must be implemented since the class implements ActionListener
    public void actionPerformed(ActionEvent e) {
        // move each circle
        // check if circle is in bounds, and bounce off the borders if need be
        // check if circle hits another circle of different color,
        // bounce circles off each other and swap colors
        // if circle of one color hits a circle of same color, remove smaller circle
        // call repaint
        for (int s = 0; s < cirlcList.size(); s++){
            cirlcList.get(s).Location.x =  cirlcList.get(s).Location.x +  cirlcList.get(s).speed.x;
            cirlcList.get(s).Location.y =  cirlcList.get(s).Location.y +  cirlcList.get(s).speed.y;

            shapeList.get(s).x =  cirlcList.get(s).Location.x;
            shapeList.get(s).y =  cirlcList.get(s).Location.y;
            if ((shapeList.get(s).x) >= FRAME_WIDTH - cirlcList.get(s).width){
                cirlcList.get(s).speed.x = cirlcList.get(s).speed.x * -1;
            }
            else if (cirlcList.get(s).Location.x <= 0){
                cirlcList.get(s).speed.x = cirlcList.get(s).speed.x * -1;
            }
            else if ((shapeList.get(s).y) >= FRAME_WIDTH - cirlcList.get(s).width){
                cirlcList.get(s).speed.y = cirlcList.get(s).speed.y * -1;
            }
            else if (cirlcList.get(s).Location.y <= 0){
                cirlcList.get(s).speed.y = cirlcList.get(s).speed.y * -1;
            }
            for (int c = 0; c < cirlcList.size(); c++){
                if (shapeList.get(s).intersects(shapeList.get(c)) && !cirlcList.get(s).getFillColor().equals(cirlcList.get(c).getFillColor())) {
                    cirlcList.get(s).speed.x = cirlcList.get(s).speed.x * -1;
                    cirlcList.get(s).speed.y = cirlcList.get(s).speed.y * -1;

                    cirlcList.get(c).speed.x = cirlcList.get(c).speed.x * -1;
                    cirlcList.get(c).speed.y = cirlcList.get(c).speed.y * -1;

                    switchColor = cirlcList.get(s).getFillColor();
                    cirlcList.get(s).setFillColor(cirlcList.get(c).getFillColor());
                    cirlcList.get(c).setFillColor(switchColor);
                }
                else if (cirlcList.get(s).getFillColor().equals(cirlcList.get(c).getFillColor()) && shapeList.get(s).intersects(shapeList.get(c)) && !(cirlcList.get(s).length == cirlcList.get(c).length)){
                    if (cirlcList.get(s).length < cirlcList.get(c).length){
                        cirlcList.get(s).Location.x = 1000000;
                        cirlcList.get(s).Location.y = 1000000;
                        shapeList.get(s).x = 1000000;
                        shapeList.get(s).y = 1000000;
                        cirlcList.get(s).speed.x = 0;
                        cirlcList.get(s).speed.y = 0;
                    }
                    else{
                        cirlcList.get(c).Location.x = 1000000;
                        cirlcList.get(c).Location.y = 1000000;
                        shapeList.get(c).x = 1000000;
                        shapeList.get(c).y = 1000000;
                        cirlcList.get(c).speed.x = 0;
                        cirlcList.get(c).speed.y = 0;
                    }
                }
            }
            this.repaint();
        }


    }
    @Override
    public void keyPressed(KeyEvent e) {
        /* To-DO:
         *  - if c, r, e, s, or t is pressed draw a cirlce, rectangle, ellipse, square 
         *  - or traingle. 
         *  - repaint the JPanel
         */
        x = random.nextInt(400)+1;
        y = random.nextInt(400)+1;
        y1 = random.nextInt(5)+1;
        width = random.nextInt(100)+20;
        length = random.nextInt(100)+20;
        x1 = random.nextInt(5)+1;
        Color randColor = Colors.get(random.nextInt(6));
        Color randColor2 = new Color(random.nextInt(255)+1, random.nextInt(255)+1, random.nextInt(255)+1);
        /*if (e.getKeyCode() == KeyEvent.VK_R){
            Shape rect = new Rectangle(x, y, length, width);
            rect.setFillColor(randColor);
            rect.setBorderColor(randColor2);
            this.shapeList.add(rect);
            this.repaint();
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            Shape square = new Square(x, y, length, width);
            square.setFillColor(randColor);
            square.setBorderColor(randColor2);
            this.shapeList.add(square);
            this.repaint();
        }else if (e.getKeyCode() == KeyEvent.VK_E){
            Shape elip = new Ellipse(x, y, length, width);
            elip.setFillColor(randColor);
            elip.setBorderColor(randColor2);
            this.shapeList.add(elip);
            this.repaint();

        }*/
        if (e.getKeyCode() == KeyEvent.VK_C){
            Circle circle = new Circle(x, y, length, width, x1, y1);
            circle.setFillColor(randColor);
            circle.setBorderColor(randColor2);
            this.cirlcList.add(circle);
            Rectangle rect = new Rectangle(x, y, length, width);
            this.shapeList.add(rect);
            //this.repaint();
        }/*else if (e.getKeyCode() == KeyEvent.VK_T){
            Shape tri = new Triangle(x, y, length, y1, width, length1);
            tri.setFillColor(randColor);
            tri.setBorderColor(randColor2);
            this.shapeList.add(tri);
            this.repaint();
        }*/
    }

    // do not need to do anything with this method from KeyListener
    // but must have since this class implements KeyListiner 
    @Override
    public void keyReleased(KeyEvent e) { }
    
    // do not neet to do anything with this method from KeyListener
    // but must have since this class implements KeyListiner 
    @Override
    public void keyTyped(KeyEvent e) { }

    // test client
    public static void main(String[] args) {
        ShapeDriver sD = new ShapeDriver();
    }



}

