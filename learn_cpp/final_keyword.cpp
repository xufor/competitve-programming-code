#include <iostream>
using namespace std;

class A { 
public:
    virtual void fun() final { 
        cout<<"Hey!"; 
    };
};

class B: public A {
    public:
        // void fun() {}; is invalid because we cannot override a final function
};

int main() {
    B b;
    b.fun();
}