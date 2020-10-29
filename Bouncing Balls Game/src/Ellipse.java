import java.awt.*;
//Jamar Golden jamgolde
public class Ellipse extends Shape{
    int length;
    int width;
    Point Location;
    Point speed;

    public Ellipse(){}
    public Ellipse(Color fillColor, Color borderColor, int x, int y, int length, int width){
        this.length = length;
        this.width = width;
        Location = new Point(x, y);
        speed = new Point(1, 1);
    }
    public Ellipse(Color fillColor, int x, int y, int length, int width){
        this.length = length;
        this.width = width;
        Location = new Point(x, y);
        speed = new Point(1, 1);
    }
    public Ellipse( int x, int y, int length, int width){
        this.length = length;
        this.width = width;
        Location = new Point(x, y);
        speed = new Point(1, 1);
    }
    public double getArea(){
        return (length / 2) * (width / 2) * 3.14;
    }
    public double getPerimeter(){
        return ((length / 2) * 3.14) * 2;
    }
    public String toString(){
        return "x: " + Location.x + "y: " + Location.y + "Length: " + length + "Width: " + width;}

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //Ellipse ellilp = new Ellipse(this.getX(), this.getY(), this.length, this.width);
        g2.setColor(getFillColor());
        g2.fillOval(this.Location.x, this.Location.y, this.width, this.length);
        g2.setColor(getBorderColor());
        g2.drawOval(this.Location.x, this.Location.y, this.width, this.length);
    }
    public static void main(String[] args){


    }
}
