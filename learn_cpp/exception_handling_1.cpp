#include <iostream>

using namespace std;

float division(float a, float b)
{ 
    if(b == 0)
        throw 900;
    return a / b;
}

int main() {
    int a, b;
    cout << "Enter two numbers:\n";
    cin >> a >> b;
    try {
        float r = division(a, b);
        cout << "The quotient is: " << r; // if an error occurs this line is skipped
    }
    catch (int e) {
        if(e == 900)
            cout << "The divisor cannot be zero!";
    }
    return 0;
}