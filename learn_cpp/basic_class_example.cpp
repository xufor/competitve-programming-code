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
    Rectangle r1;
    r1.length = 44;
    r1.breadth = 55;
    cout << r1.area() << " " << r1.perimeter();
    return 0;
}