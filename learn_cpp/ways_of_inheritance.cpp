#include <iostream>

using namespace std;

class A { 
    // public, private and protected are access specifiers
    public:
        int a = 100;
    protected:
        int b = 200;
    private:
        int c = 300;

};

class B: protected A {}; 
// a, b become protected when they enter this class
// they will only be further accessible by the classes who inherit A
// c was never accessible to begin with

class C: private A {};
// a, b become private when they enter this class
// they will not be further accessible anywhere except for this class
// c was never accessible to begin with

class D: public B {
// a, b remain protected
// remember that they will not rise from protected to public
// access specifiers only go one way, i.e. public -> protected -> private
// they will only be further accessible by the classes who inherit A
// c was never accessible to begin with
    public:
        D() {
            cout << a << " " << b << '\n';
        }
};

int main() {
    A oa;
    B ob;
    C oc;
    D od;
    cout << oa.a; // this.the only accessible thig outside! LOL
}