import java.awt.*;
import java.lang.reflect.Array;

public class Triangle extends Shape{
    int [] xpoint = {0, 0, 0};
    int [] ypoint = {0, 0, 0};

    public Triangle(Color fillColor, Color borderColor, int xp1, int xp2, int xp3, int yp1, int yp2, int yp3){
        xpoint[0] = xp1;
        xpoint[1] = xp2;
        xpoint[2] = xp3;

        ypoint[0] = yp1;
        ypoint[1] = yp2;
        ypoint[2] = yp3;
    }
    public Triangle(Color fillColor,  int xp1, int xp2, int xp3, int yp1, int yp2, int yp3){
        xpoint[0] = xp1;
        xpoint[1] = xp2;
        xpoint[2] = xp3;

        ypoint[0] = yp1;
        ypoint[1] = yp2;
        ypoint[2] = yp3;
    }
    public Triangle(int xp1, int xp2, int xp3, int yp1, int yp2, int yp3){
        xpoint[0] = xp1;
        xpoint[1] = xp2;
        xpoint[2] = xp3;

        ypoint[0] = yp1;
        ypoint[1] = yp2;
        ypoint[2] = yp3;
    }
    public double getArea(){
        return 1;
    }
    public String toString(){
        return "X Points: " + xpoint[0] + ", " + xpoint[1] + ", " + xpoint[2] + "Y Points:" + ypoint[0] + ", " + ypoint[1] + ", " + xpoint[2];
    }
    public double getPerimeter(){
        return 1;
    }

    public void draw(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        //Rectangle rect = new Rectangle(this.getX(), this.getY(), this.length, this.width);
        g2.setColor(getFillColor());
        g2.fillPolygon(this.xpoint, this.ypoint, 3);
        g2.setColor(getBorderColor());
        g2.drawPolygon(this.xpoint, this.ypoint, 3);
    }
    public static void main(String[] args){


    }
}
