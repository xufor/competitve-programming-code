#include <iostream>
using namespace std;

class A {
public:
    void fun1() { 
        cout << 1; 
    }
    void fun2() { 
        cout << 2; 
    }
    void fun3() { 
        cout << 3; 
    }
};

class B : public A {
public:
    void fun3() { 
        cout << -3; 
    }
    void fun4() { 
        cout << -4; 
    }
    void fun5() { 
        cout << -5; 
    }
};

int main() {
    A *a = new B(); 
    // base class pointer can point to derived class object
    // inverse is not possible
    a -> fun1(); // 1
    // if fun is present in both the classes then the base class fuction
    // will be called, but this not wanted and thus we use virtual functions
    a -> fun2(); // 2
    a -> fun3(); // 3
    // a -> fun4(); not possible
    // a -> fun5(); not possible
}