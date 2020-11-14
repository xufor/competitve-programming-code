#include <iostream>
using namespace std;

string fun() {
    return "Hey There!";
}

int main() {
    auto x = 8 / 1.537;
    auto s = fun();
    cout << s << '\n' << x;
    decltype(s) y = "Hello World\n";
    cout << '\n' << y;
}