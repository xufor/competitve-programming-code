#include <iostream>

using namespace std;

int print() {
    static int v = 0;
    // this variable willl get initialized only on first function call
    // its value will live throughout function calls
    v++;
    cout << v << " ";
    return 0;
}

int main() {
    print(); // 1
    print(); // 2
    print(); // 3
}