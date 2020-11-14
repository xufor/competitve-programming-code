#include <iostream>
#include <math.h>
using namespace std;

int display() {
    cout << "Hello World\n";
    return 0;
}

int cube(int num) {
    return pow(num, 3);
}
// a function pointer can point to any fuction of same signature
int main() {
    int (*pointer_to_function)(); // declaration
    // pointer to functions are alwys encloced in ()
    pointer_to_function = display; // initializtion
    (*pointer_to_function)();

    // declaration + initialization in one line
    int (*another_pointer_to_function)() = display;
    (*another_pointer_to_function)();

    // function pointer to a function with parameters
    int (*yet_another_pointer_to_function)(int) = cube;
    cout << (*yet_another_pointer_to_function)(7);
    return 0;
}