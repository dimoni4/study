package patterns.structural;

/**
 * Created by dvetrov on 23.03.15.
 */
public class Bridge {
    public static void main(String[] args) {
        Shape triangle = new Triangle(new RedColor());
        triangle.applyColor();

        Shape rectangle = new Rectangle(new GreenColor());
        rectangle.applyColor();
    }

}

interface Color {
    void applyColor();
}

abstract class Shape {
    Color color;

    Shape(Color color) {
        this.color = color;
    }

    abstract public void applyColor();
}


class Triangle extends Shape {
    Triangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor(){
        System.out.print("Triangle filled with color ");
        color.applyColor();
    }
}


class Rectangle extends Shape {
    Rectangle(Color color) {
        super(color);
    }

    @Override
    public void applyColor(){
        System.out.print("Rectangle filled with color ");
        color.applyColor();
    }
}

class RedColor implements Color {
    public void applyColor(){
        System.out.println("red.");
    }
}

class GreenColor implements Color {
    public void applyColor(){
        System.out.println("green.");
    }
}
