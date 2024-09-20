package DesignPatterns;

// Step 1: Prototype Interface
interface Shape extends Cloneable {
    Shape clone(); // Method to clone the object
    void draw();   // Method to draw the shape
}

// Step 2: Concrete Prototype 1 - Circle
class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Circle with radius: " + radius);
    }

    @Override
    public Shape clone() {
        try {
            return (Circle) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Step 2: Concrete Prototype 2 - Rectangle
class Rectangle implements Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setDimensions(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle with width: " + width + " and height: " + height);
    }

    @Override
    public Shape clone() {
        try {
            return (Rectangle) super.clone(); // Shallow copy
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Client Code
public class PrototypePatternExample {
    public static void main(String[] args) {
        // Step 3: Creating and Cloning a Circle
        Circle originalCircle = new Circle(10);
        originalCircle.draw();  // Output: Drawing a Circle with radius: 10

        Circle clonedCircle = (Circle) originalCircle.clone();
        clonedCircle.setRadius(20);
        clonedCircle.draw();    // Output: Drawing a Circle with radius: 20

        // Step 3: Creating and Cloning a Rectangle
        Rectangle originalRectangle = new Rectangle(30, 40);
        originalRectangle.draw();  // Output: Drawing a Rectangle with width: 30 and height: 40

        Rectangle clonedRectangle = (Rectangle) originalRectangle.clone();
        clonedRectangle.setDimensions(50, 60);
        clonedRectangle.draw();    // Output: Drawing a Rectangle with width: 50 and height: 60
    }
}
