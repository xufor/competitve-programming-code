#include <iostream>
#include <stdarg.h>
using namespace std;


int sum(int n, ...) {
    va_list list;
    va_start(list, n);
    int x, s = 0;
    for (int i = 0; i < n; i++) {
        x = va_arg(list, int);
        s += x;
    }
    va_end(list);
    return s;
}

int main() {
    cout << sum(5, 7, 8, 9, 7, 5);
}