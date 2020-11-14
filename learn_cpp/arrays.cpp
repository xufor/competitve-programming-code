#include <iostream>
using namespace std;

int main() {
    int a[5] = {1, 2, 3, 4}; // last value defaulted to 0
    for(int i = 0; i < *(&a + 1) - a; i++) {  // a way to find length of array
        cout << a[i] << " ";
    }
    cout << '\n';
    // much more simpler way
    for (int x : a)
        cout << x << " ";
    cout << '\n';
    // even more simpler way
    for (auto x : a)
        cout << x << " ";
    return 0;
}