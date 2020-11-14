#include <iostream>
using namespace std;

int main() {
    int x = 1, y = 7;
    int z = x++ + x++; // this is dangerous as depends con compiler
    cout << z << endl;
    cout << y++ << " " << --y << " " << y--;
    return 0;
}