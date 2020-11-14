#include <iostream>
using namespace std;

class B; 
// just declaring so that compiler does't get sad at line 9

class A { 
    int v = 123;
    friend B;
};

class B { // we did not inherit from A
public:
    A a; // has-a not is-a relationship
    void fun() {
        cout << a.v << endl;
    }
};

int main() {
    B b;
    b.fun();
}