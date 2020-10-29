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
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
//Jamar Golden jamgolde
/*
 * Driver program for randam shape generator app
 */
public class ShapeDriver extends JPanel implements KeyListener {

    int x;
    int y;
    int y1;
    int length;
    int length1;
    int width;


    ArrayList<Shape> shapeList = new ArrayList<Shape>();
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



        this.setBackground(Color.yellow);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);


    }

    @Override
    public void paintComponent(Graphics g) {
        // call super class paintComponent method
        // background will not be colored otherwise
        super.paintComponent(g);

        // TO-DO use the different Shapes draw methods here
        // The draw methods in the differnet shapes should take 
        // The Graphics object should be passed to the Shapes Draw method
        for (Shape s: shapeList){
            s.draw(g);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        /* To-DO: 
         *  - if c, r, e, s, or t is pressed draw a cirlce, rectangle, ellipse, square 
         *  - or traingle. 
         *  - repaint the JPanel
         */
        x = random.nextInt(500)+1;
        y = random.nextInt(500)+1;
        y1 = random.nextInt(500)+1;
        width = random.nextInt(200)+1;
        length = random.nextInt(200)+1;
        length1 = random.nextInt(200)+1;
        Color randColor = new Color(random.nextInt(255)+1, random.nextInt(255)+1, random.nextInt(255)+1);
        Color randColor2 = new Color(random.nextInt(255)+1, random.nextInt(255)+1, random.nextInt(255)+1);
        if (e.getKeyCode() == KeyEvent.VK_R){
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
        }else if (e.getKeyCode() == KeyEvent.VK_C){
            Shape circle = new Circle(x, y, length, width);
            circle.setFillColor(randColor);
            circle.setBorderColor(randColor2);
            this.shapeList.add(circle);
            this.repaint();
        }else if (e.getKeyCode() == KeyEvent.VK_T){
            Shape tri = new Triangle(x, y, length, y1, width, length1);
            tri.setFillColor(randColor);
            tri.setBorderColor(randColor2);
            this.shapeList.add(tri);
            this.repaint();
        }
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