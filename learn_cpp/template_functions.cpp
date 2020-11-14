#include <iostream>

using namespace std;

template <class T>
T maximum(T a, T b, T c = 999) { 
    // you cannot make b default and skip c 
    // start making default from rhs and don't skip any in between
    // defualt arguments are temporary to pass
    if(a >= b) {
        return a;
    } else {
        return b;
    }
}
// in call by reference the other function is copied to
// the caller function, so yep its weird
// whenever a function is copied in this manner
// these type of functions are called inline functions
int main() {
    cout<<maximum(5, 7);
}