interface Calculator {
    static int add(int a, int b) {
        return a + b;
    }
}

// Open/Closed Principle (O)
interface Shape {
    double area();
}

class Rectangle implements Shape {
    private final double length;
    private final double width;

    public Rectangle(double l, double w) {
        this.length = l;
        this.width = w;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class Circle implements Shape {
    private final double radius;

    public Circle(double r) {
        this.radius = r;
    }

    @Override
    public double area() {
        return 3.14 * radius * radius;
    }
}

// Liskov Substitution Principle (L)
class Bird {
    void fly() {
        System.out.println("Flying...");
    }
}

class Penguin extends Bird {
    @Override
    void fly() {
        System.out.println("Sorry, I can't fly!");
    }
}

// Interface Segregation Principle (I)
interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class Photocopier implements Printer, Scanner {
    @Override
    public void print() {
        System.out.println("Printing...");
    }

    @Override
    public void scan() {
        System.out.println("Scanning...");
    }
}

// Dependency Inversion Principle (D)
class LightBulb {
    void turnOn() {
        System.out.println("LightBulb is ON.");
    }

    void turnOff() {
        System.out.println("LightBulb is OFF.");
    }
}

class Switch {
    private final LightBulb bulb;
    private boolean isOn;  // Add member here

    public Switch(LightBulb bulb) {
        this.bulb = bulb;
        this.isOn = false;  // Initialize isOn in the constructor
    }

    void press() {
        if (isOn) {
            bulb.turnOff();
            isOn = false;
        } else {
            bulb.turnOn();
            isOn = true;
        }
    }
}

public class SOLIDPrinciplesExample {
    public static void main(String[] args) {
        // Single Responsibility Principle
        int result = Calculator.add(5, 3);
        System.out.println("Result: " + result);

        // Open/Closed Principle
        Shape rectangle = new Rectangle(4, 5);
        Shape circle = new Circle(3);

        System.out.println("Rectangle Area: " + rectangle.area());
        System.out.println("Circle Area: " + circle.area());

        // Liskov Substitution Principle
        Bird bird = new Penguin();
        bird.fly();

        // Interface Segregation Principle
        Photocopier copier = new Photocopier();
        copier.print();
        copier.scan();

        // Dependency Inversion Principle
        LightBulb bulb = new LightBulb();
        Switch lightSwitch = new Switch(bulb);
        lightSwitch.press();
    }
}
