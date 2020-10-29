//Jamar Golden jamgolde

import java.awt.*;

abstract class Shape {
    private Color fillColor;
    private Color borderColor;
    private Boolean isFilled;
    private Point Location;

    public Shape(){};
    // the three constructors initialize the instance fields
    public Shape(Color fillColor,Color borderColor, int x, int y) {
        this.fillColor = fillColor;
        this.borderColor = borderColor;
        this.Location = new Point(x, y);
    }
    // set borderColor to Black since not provided
    public Shape(Color fillColor, int x, int y) {
        this.fillColor = fillColor;
        this.Location = new Point(x, y);
    }
    // set fillColor to white and border color to black
    public Shape(int x, int y) {
        this.Location = new Point(x, y);
    }
    public void setFillColor(Color c) {
        fillColor = c;
    }
    public Color getFillColor() {
        return this.fillColor;
    }
    public void setBorderColor(Color c) {
        borderColor = c;
    }
    public Color getBorderColor() {
        return this.borderColor;
    }
    public void setLocation(Point pt) {
        Location = new Point(pt);
    }
    public Point getLocation() {
        return this.Location;
    }
    // Note: subclasses of Shape do not inherent private members so we need methods the subclasses
// can use to get the x and y values from the private Point instance field
    public int getX() {
        return this.Location.x;
    }
    public void setX(int x) {
        Location.x = x;
    }
    public int getY() {
        return this.Location.y;
    }
    public void setY(int y) {
        Location.y = y;
    }
    // if fillColor is white returns true, else returns false
    public boolean isFilled() {
        if (this.fillColor.equals("white")){
            isFilled = true;
            return isFilled;
        }else{
            isFilled = false;
            return isFilled;
        }
    }
    // moves location by dx and dy
    private void moveLocation(int dx, int dy) {
        Location = new Point(dx, dy);
    }
    abstract double getArea();
    abstract double getPerimeter();
    abstract void draw(Graphics g);
}
