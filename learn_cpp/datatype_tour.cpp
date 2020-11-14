#include <iostream>
#include <limits.h>
using namespace std;

int main() {
    bool v1 = true; // 0 is false any other number is true
    char v2 = 'a';  // 1 byte
    cout << CHAR_MIN << " " << CHAR_MAX << endl;
    cout << 0 << " " << UCHAR_MAX << endl; // for unsigned char
    // A=65 Z=90 a=97 z=122 0=48 9=57
    wchar_t v3 = 'b';  // 2 bytes (wide char)
    char16_t v4 = 'c'; // 2 bytes (unicode char)
    char32_t v5 = 'd'; // 4 bytes (unicode char)
    cout << v1 << " " << v2 << " " << v3 << " " << v4 << " " << v5 << endl;
    cout << v1 << " " << v2 << " " << (char)v3 << " " << (char)v4 << " " << (char)v5 << endl;

    int v6 = 1; // 4 bytes (highly depends on architecture)
    // when 16 bit architecture range of integer varies from -32768 to 32767
    short v7 = 2;     // 2 bytes
    long v8 = 3;      // 4 bytes (can be 8 bytes on other architectures)
    long long v9 = 4; // 8 bytes
    cout << sizeof(v6) << " " << sizeof(v7) << " " << sizeof(v8) << " " << sizeof(v9) << endl;

    float v10 = 5.5;       // 4 bytes
    double v11 = 5.6;      // 8 bytes
    long double v12 = 5.7; // 12 bytes
    cout << sizeof(v10) << " " << sizeof(v11) << " " << sizeof(v12) << endl;
    return 0;
}