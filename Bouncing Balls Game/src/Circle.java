import java.awt.*;
//Jamar Golden jamgolde
public class Circle extends Ellipse {
    int length;
    int width;
    Point Location;
    Point Center;

    public Circle(Color fillColor, Color borderColor, int x, int y, int length, int width){
        this.length = length;
        this.width = length;
        Location = new Point(x, y);
        speed = new Point(1, 1);
    }
    public Circle(Color fillColor, int x, int y, int length, int width){
        this.length = length;
        this.width = length;
        Location = new Point(x, y);
        speed = new Point(1, 1);
    }
    public Circle(int x, int y, int length, int width, int speedx, int speedy){
        this.length = length;
        this.width = length;
        Location = new Point(x, y);
        speed = new Point(speedx, speedy);
        Center = new Point((this.length / 2) + this.Location.x, (this.length / 2) + this.Location.y);
    }
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
