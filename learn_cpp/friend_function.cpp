#include <iostream>
using namespace std;


class Complex {
private:
    int real;
    int img;
    
public:
    Complex(int r = 0, int i = 0) {
        real = r;
        img = i;
    }

    void display() {
        cout << real << "+i" << img << endl;
    }

    friend Complex operator+(Complex c1, Complex c2);
    friend ostream &operator<<(ostream &o, Complex &c);
};

// friend functions do not need scope resolution
// they can access private members also, too friendly
Complex operator+(Complex c1, Complex c2) {
    Complex temp;
    temp.real = c1.real + c2.real;
    temp.img = c1.img + c2.img;
    return temp;
}

// you really don't need to return ostream reference
// but if you want to add more things after custom cout 
// such as cout<<c3<<endl<<c2; then you can return a reference
// to extend the functionality

ostream& operator<<(ostream &cout_alias, Complex &c) {
    cout_alias << c.real << "+i" << c.img;
    // here o became a reference to cout which is an object of type ostream
    // note that cout gets passed to variable o and c3 gets passed to varible c
    return cout_alias;
}

int main() {
    Complex c1(5, 3), c2(10, 5), c3;
    c3 = c1 + c2; // can be done as operator+(c1, c2);
    cout << c3 << endl << c1; // can be done as operator<<(cout, c3);
}