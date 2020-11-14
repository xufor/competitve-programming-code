#include <iostream>

using namespace std;

// in C you couldn't declare the variable later in the program 
// but in C++ you can do it wherever needed 
int main() {
    if (int x = 9 & 1; x == 1) { // C++17 feature
        cout << "Lifetime of x is limited to this if block!";
    }
    return 0;
}