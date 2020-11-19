#include <iostream>

using namespace std;

class ZeroDivisionError: public exception {
    public:
        string what() {
            return "The divisor cannot be zero!";
        }
};

float division(float a, float b) {
    if(b == 0) 
        throw ZeroDivisionError();
    return a/b;
}

int main() {
    int a,b;
    cout << "Enter two numbers:\n";
    cin >> a >> b;
    try {
        float r = division(a, b);
        cout << "The quotient is: " << r; // if an error occurs this line is skipped
    }
    catch(ZeroDivisionError e) {
        cout << e.what();
    }
    catch(...) {
        cout << "Some error occured! :-<";
    }
    return 0;
}