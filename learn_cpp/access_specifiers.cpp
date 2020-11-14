#include <iostream>

using namespace std;

class A { 
// public, private and protected are access specifiers
public:
    int a;

protected:
    int b;

private:
    int c;
};

class B: public A {
public:
    B(int a, int b, int c) {
        this -> a = a;
        this -> b = b;
        // this->c = c; here c becomes inaccessible
    }
};

int main() {
    B b = B(10, 20, 30);
    cout << b.a;
    // cout << b.b; here b becomes inaccessible
    // cout << b.c; here c becomes inaccessible
}