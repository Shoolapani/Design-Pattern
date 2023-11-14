#include <bits/stdc++.h>
using namespace std;

// Factory Pattern
class Shape
{
public:
    virtual void draw() = 0;
};

class Circle : public Shape
{
public:
    void draw() override
    {
        cout << "Shape is Circle" << endl;
    }
};

class Rectangle : public Shape
{
public:
    void draw() override
    {
        cout << "Shape is Rectangle" << endl;
    }
};

class ShapeFactory
{
public:
    Shape *getShape(string strInput)
    {
        if (strInput == "Circle")
        {
            return new Circle();
        }
        else if (strInput == "Rectangle")
        {
            return new Rectangle();
        }
        else
        {
            return nullptr;
        }
    }
};

int main()
{
    ShapeFactory *shapeFactoryObj = new ShapeFactory();
    Shape *rectangle = shapeFactoryObj->getShape("Circle");
    rectangle->draw();
    return 0;
}