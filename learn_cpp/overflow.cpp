#include <iostream>
using namespace std;

int main() {
    char c = 127; // which is the upper limit of char type
    c++;
    /* 
        => 127 is 1111111
        => 127 + 1 = 128 which is represented as 10000000
        => note that 10000000's 2's complement will be 100000000
        => thus binary representation of 128 is nothing but 2's complement of its binary
        => since negetive no.s are always represented as 2's complement
        => 128's binary representation here, becomes equivalent to -128's representation 
    */
    cout << (int)c << endl;
    // similarly
    char f = -128;
    f--;
    cout << (int)f << endl;
    // simple addition and subtraction is taking place
    // representation is what is making it weird
    return 0;
}