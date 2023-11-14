// Factory Pattern
interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape is Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Shape is Rectangle");
    }
}

class ShapeFactory {
    Shape getShape(String strInput) {
        if (strInput.equals("Circle")) {
            return new Circle();
        } else if (strInput.equals("Rectangle")) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactoryObj = new ShapeFactory();
        Shape rectangle = shapeFactoryObj.getShape("Circle");
        rectangle.draw();
    }
}
