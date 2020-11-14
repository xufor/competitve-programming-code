#include <iostream>
using namespace std;

int g = 0;

int print_g() {
    cout << '\n' << g;
    return 0;
}

int main() {
    int g = 1;
    g++;
    {
        int g = 3;
        g++;
        cout << g << '\n';
    }
    cout << g << '\n' << ::g;
    print_g();
}