#include <iostream>
using namespace std;

int& fun(int &a) {
    // please do not return a reference to local variables
    return a;
}

int main() {
    int x = 10;
    fun(x) = 55;
    cout << x;
}