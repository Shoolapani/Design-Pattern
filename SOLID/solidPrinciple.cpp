#include <iostream>
#include <vector>

// Single Responsibility Principle (SRP)
class Logger {
public:
    void log(const std::string& message) {
        std::cout << "Log: " << message << std::endl;
    }
};

// Open/Closed Principle (OCP)
class AreaCalculator {
public:
    virtual double calculateArea() const = 0;
};

class Rectangle : public AreaCalculator {
private:
    double width, height;

public:
    Rectangle(double w, double h) : width(w), height(h) {}

    double calculateArea() const override {
        Logger logger;
        logger.log("Calculating area of rectangle");
        return width * height;
    }
};

class Circle : public AreaCalculator {
private:
    double radius;

public:
    Circle(double r) : radius(r) {}

    double calculateArea() const override {
        Logger logger;
        logger.log("Calculating area of circle");
        return 3.14 * radius * radius;
    }
};

// Liskov Substitution Principle (LSP)
void printArea(const AreaCalculator& shape) {
    Logger logger;
    logger.log("Printing area: " + std::to_string(shape.calculateArea()));
}

// Interface Segregation Principle (ISP)
class Printable {
public:
    virtual void print() const = 0;
};

class Document : public Printable {
public:
    void print() const override {
        Logger logger;
        logger.log("Printing document...");
    }
};

class Scanner {
public:
    void scan(const Printable& document) const {
        Logger logger;
        logger.log("Scanning document...");
        document.print();
    }
};

// Dependency Inversion Principle (DIP)
class DataProcessor {
private:
    const Logger& logger;

public:
    DataProcessor(const Logger& log) : logger(log) {}

    void processData(const Printable& data) const {
        logger.log("Processing data...");
        data.print();
    }
};

int main() {
    // Single Responsibility Principle (SRP)
    Logger logger;
    logger.log("Application started.");

    // Open/Closed Principle (OCP)
    Rectangle rectangle(4, 5);
    Circle circle(3);
    printArea(rectangle);
    printArea(circle);

    // Liskov Substitution Principle (LSP)
    printArea(rectangle);

    // Interface Segregation Principle (ISP)
    Document document;
    Scanner scanner;
    scanner.scan(document);

    // Dependency Inversion Principle (DIP)
    DataProcessor dataProcessor(logger);
    dataProcessor.processData(document);

    return 0;
}
