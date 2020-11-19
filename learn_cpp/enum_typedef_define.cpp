#include <iostream>
#define jan 0
#define w cout
#define sqr(x) (x*x)
#define to_str(m) #m
#ifndef pi
    #define pi 3.1425
#endif
typedef int integer;
using namespace std;

enum day { mon, tue=3, wed, thu, fri, sat=1, sun=mon+6 };

int main() {
    integer num = 987;
    cout << mon << " " << tue << " " << wed << " " << sun << endl;
    cout << jan << " " << num << endl;
    w << sqr(5) << " " << to_str(is the square of 5);
    w << " " << to_str(and the value of pi is) << " " << pi;
    return 0;
}