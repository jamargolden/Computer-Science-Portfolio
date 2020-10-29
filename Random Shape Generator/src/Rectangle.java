import javax.swing.*;
import java.awt.*;
import java.util.Random;
//Jamar Golden jamgolde
public class Rectangle extends Shape{
    int length;
    int width;
    Point Location;

    public Rectangle(){

    }
    public Rectangle(Color fillColor,Color borderColor, int x, int y, int length, int width){
        this.length = length;
        this.width = width;
        Location = new Point(x, y);
    }
    public Rectangle(Color fillColor, int x, int y, int length, int width){
        this.length = length;
        this.width = width;
        Location = new Point(x, y);
    }
    public Rectangle(int x, int y, int length, int width){
        this.length = length;
        this.width = width;
        Location = new Point(x, y);
    }
    public double getArea(){
        return length * width;
    }

    public double getPerimeter(){
        return (length * 2) + (width * 2);
    }

    public String toString(){ return "x: " + Location.x + "y: " + Location.y + "Length: " + length + "Width: " + width;}

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //Rectangle rect = new Rectangle(this.getX(), this.getY(), this.length, this.width);
        g2.setColor(getFillColor());
        g2.fillRect(this.Location.x, this.Location.y, this.width, this.length);
        g2.setColor(getBorderColor());
        g2.drawRect(this.Location.x, this.Location.y, this.width, this.length);
    }
    public static void main(String[] args){


    }
}
