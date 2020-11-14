#include <iostream>

using namespace std;

class A {
    int a = 9;
    int b = 8;

    public: 
        void fun() const { 
            // a++ becomes invalid as we put a const in the header
            // this fuction is not supposed to edit the data members
            cout << a << endl;
        }
};

void foo(const int &x) {
    // x++ becomes invalid as we made the parameter const type
    cout << x << endl;
};

int main() {
    int x = 90;
    const int y = 100;
    x++; // allowed
    // y++ is not allowed
    int *ptr1 = &x;
    (*ptr1)++;
    cout << *ptr1 << '\n';
    const int *ptr2 = &x; // int const *ptr2 = &x is the same thing
    // ++(*ptr2) is not allowed
    cout << *ptr2 << '\n';
    ptr2 = &y;
    cout << *ptr2 << '\n';
    int *const ptr3 = &x;
    cout << ptr3 << '\n';
    //ptr3 = &y is not allowed
    const int *const ptr4 = &x;
    // ptr4 = &y  and ++(*ptr4) both are not allowed
    cout << *ptr4;
}