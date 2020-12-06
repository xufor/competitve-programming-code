#include <iostream>

using namespace std;

class A {
int x, y;
public:
    A(int x, int y) {
        this -> x = x;
        this -> y = y;
    }

    A() : A(1, 1) {}
    // This feature means that you do not have to write
    // A() {
    //     this -> x = 1;
    //     this -> y = 1;
    // }
    void display() {
        cout << x << " " << y << '\n';
    }
};

int main() {
    A a1(10, 5), a2;
    a1.display();
    a2.display();
}