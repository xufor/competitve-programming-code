#include <iostream>
using namespace std;

class Rectangle {
public:
    // by default everything is private
    int breadth;
    int length;

    int area() {
        return length * breadth;
    }
    int perimeter() {
        return 2 * (length + breadth);
    }
};

int main() {
    Rectangle r;
    // we use pointers here but objects are still in stack m/m
    // Rectangle *p = &r;
    // p->length = 10;
    // p->breadth = 20;
    // cout<<p->area()<<" "<<p->perimeter(); */
    Rectangle *p = new Rectangle;
    // you can omit () after classname if parameterized constructor is not present
    // we use pointers here and objects are in heap m/m
    p -> length = 10;
    p -> breadth = 20;
    cout << p -> area() << " " << p -> perimeter();
    return 0;
}