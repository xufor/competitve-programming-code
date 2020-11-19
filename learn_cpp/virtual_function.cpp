#include <iostream>
using namespace std;

class A {
public:
    virtual void f1() {
        cout << "f1-base" << endl;
    }

    void f2() { // not virtual
        cout << "f2-base" << endl;
    }
};

class B : public A {
public:
    void f1() {
        cout << "f1-derived" << endl;
    }

    void f2() {
        cout << "f2-derived" << endl;
    }
};

class C: public A {
public:
    void f2() {
        cout << "f2-derived" << endl;
    }
};

class E {
public:
    virtual void f1() = 0;

    void f2() { // you can have normal functions in abstract classes
        cout << "f2-base" << endl;
    }

    void f3() {
        cout << "f3-base" << endl;
    }
};

class F: public E {
public:
    void f2() {
        cout << "f2-derived" << endl;
    }
};

class G: public E {
public:
    void f1() {
        cout << "f1-derived" << endl;
    }

    void f2() {
        cout << "f2-derived" << endl;
    }    
};

int main() {
    A a; // can instantiate class A
    a.f1(); // f1-base
    a.f2(); // f2-base 
    cout << endl;

    B b;
    b.f1(); // f1-derived
    b.f2(); // f2-derived
    cout << endl;

    A *base_ptr = new A();
    base_ptr -> f1(); // f1-base
    base_ptr -> f2(); // f2-base
    cout << endl;

    B *derived_ptr = new B();
    derived_ptr -> f1(); // f1-derived
    derived_ptr -> f2(); // f2-derived
    cout << endl;
    
    // B *disaster = new A();
    // above statement gives error

    // B *even_bigger_disaster = new C();
    // above statement is a pure disaster

    A *special_base_ptr = new B();
    special_base_ptr -> f1(); // f2-derived -> run time binding coz its virtual
    special_base_ptr -> f2(); // f2-base -> compile time binding
    cout << endl;
    
    A *experiment_1 = new C();
    experiment_1 -> f1(); // f1-base -> coz its only present in base class
    // note that no error is given if not implemented in derived class
    experiment_1 -> f2(); // f2-base -> compile time binding
    cout << endl;

    // E *experiment_2 = new E();
    // does not work as you cannot instantiate abstract classes

    // F *experiment_3 = new F();
    // does not work as it is important to implement pure virtual function
    // this is due to the fact that if a derived class does not implement 
    // a pure virtual function it also becomes an abstract class
    // and therefore you cannot instantiate it as abstract classes are not 
    // allowed to instantiate in the first place

    G *experiment_4 = new G(); // peacefully allowed
    experiment_4 -> f1(); // f1-derived
    experiment_4 -> f2(); // f2-derived
    experiment_4 -> f3(); // f3-base
    cout << endl;

    // we cannot instantiate abstract class 
    // thus accessing the member functions is not possible directly
    // but then why allow defining them
    // yep we can access them if there is no definition in the derived class

    E *experiment_5 = new G();
    experiment_5 -> f1(); // f1-derived
    experiment_5 -> f2(); // f2-base
    experiment_5 -> f3(); // f3-base
    cout << endl;

    // using the base class pointer of an abstract class has usual behaviour
}