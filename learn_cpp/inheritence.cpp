#include <iostream>
using namespace std;

class Base {
public:
    string s = "<<<>>>";
    Base() {
        cout << "Constructor of base class!\n";
    }

    void display_base() {
        cout << "Display method of base class! " + s + "\n";
    }
};

class Derived : public Base
{
public:
    Derived() {
        cout << "Constructor of derived class!\n";
    }

    void display_derived() {
        cout << "Display method of derived class!\n";
    }
};

int main() {
    Base b;
    Derived d;
    d.display_base();
    d.display_derived();
    b.display_base();
    return 0;
}