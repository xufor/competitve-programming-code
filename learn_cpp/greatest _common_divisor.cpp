#include <iostream>
using namespace std;

int main() {
    int x, y;
    cout << "Enter two numbers: \n";
    cin >> x >> y;
    while(x != y) {
        if (x > y)
            x = x - y;
        else
            y = y - x;
    }
    cout << "The greatest common divisor is: " << x;
    return 0;
}