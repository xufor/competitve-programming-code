#include <iostream>

using namespace std;

int main() {
    int _d0 = 1;     // _ allowed as first character
    int d1(010);     // 0 at first place means octal number, and 010 is an integer literal
    int d2 = (0x41); // 0x at first place means hexadecimal number
    int d3{4};       // will give error that narrowing is being done for value 4.25
    long d4 = {5l};  // 5 is integer literal whereas 5l is a long literal
    // 12.5 is double literal by default, 12.5F or 12.5f is a float literal
    // 12.5L is long double literal
    float d5 = 12.5F;
    float d6 = 12.5e4;
    int d7(78.77);  // will not give error that narrowing is being done
    int d8 = 79.99; // will not give error that narrowing is being done
    // int d9 = {88.99}; will give error that narrowing is being done
    string s = "Hello World!";
    cout << _d0 << " " << d1 << " " << d2 << " " << d3 << " " << d4 << " " << d5 << " " << d6 << " " << s << endl;
    cout << d7 << " " << d8 << endl;
    return 0;
}
