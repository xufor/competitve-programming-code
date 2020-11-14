#include <iostream>

using namespace std;

class Outer {
public:
    int o_v = 30;

    class Inner {
    public:
        int i_v = 40;
    } d;

    void print() {
        cout << d.i_v << " " << o_v << endl;
    }
};

int main() {
    Outer o;
    o.print();
    cout << o.d.i_v;
}