//
// Created by zlq on 5/24/15.
//

#ifndef CMAKE_DEMO_GOOGLE_TEST_SHAPE_H
#define CMAKE_DEMO_GOOGLE_TEST_SHAPE_H

// Base class
class Shape
{
public:
    // pure virtual function providing interface framework.
    virtual int getArea() = 0;
    void setWidth(int w)
    {
        width = w;
    }
    void setHeight(int h)
    {
        height = h;
    }
protected:
    int width;
    int height;
};

// Derived classes
class Rectangle: public Shape
{
public:
    int getArea()
    {
        return (width * height);
    }
};

class Triangle: public Shape
{
public:
    int getArea()
    {
        return (width * height)/2;
    }
};

#endif //CMAKE_DEMO_GOOGLE_TEST_SHAPE_H
