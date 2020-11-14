#include <iostream>

using namespace std;

int main() {
    // float values do not support %
    // only integer types and char do
    long x = 67678;
    cout << x % 400;
    // precedence is a help for compiler
    // so that it can parenthesize the unparanthesized expressions
    return 0;
};