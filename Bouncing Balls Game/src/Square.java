import java.awt.*;
//Jamar Golden jamgolde
public class Square extends Rectangle{
    int length;
    int width;
    Point Location;

    public Square(Color fillColor, Color borderColor, int x, int y, int length, int width){
        this.length = length;
        this.width = length;
        Location = new Point(x, y);
    }
    public Square(Color fillColor, int x, int y, int length, int width){
        this.length = length;
        this.width = length;
    }
    public Square(int x, int y, int length, int width){
        this.length = length;
        this.width = length;
        Location = new Point(x, y);
    }
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
