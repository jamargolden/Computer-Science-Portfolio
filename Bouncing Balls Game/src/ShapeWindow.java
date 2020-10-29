////////////////////////////////////////////////////////////////////////////////////
//
//  C212
//
//  Lab8
//  @Author  
//
///////////////////////////////////////////////////////////////////////////////////
//Jamar Golden jamgolde
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

/*
 * Main application for random rhape renerator app
 */
public class ShapeWindow extends JFrame {

    JPanel shapeDriver;

    public ShapeWindow() {
        super();
        this.setTitle("Shape");
        this.setSize(600, 600);
        this.getContentPane().add(shapeDriver = new ShapeDriver());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        // run main application
        ShapeDriver drive = new ShapeDriver();
        JFrame shapeWindow = new ShapeWindow();
        shapeWindow.add(drive);
    }
}
