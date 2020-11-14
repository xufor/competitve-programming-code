#include <iostream>
using namespace std;

int main() {
    int z = 15;
    int &x = z;
    // references should be initialized immediately
    // moreover they can refer to only one variable
    x++;
    z++;
    cout << x << " " << z;
}