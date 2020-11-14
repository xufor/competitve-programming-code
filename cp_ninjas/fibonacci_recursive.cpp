#include <bits\stdc++.h>
using namespace std;

int fibonacci_recursive(int n) {
    if(n == 0) {
        return 0;
    } else if (n == 1) { 
        return 1;
    } else {
        return fibonacci_recursive(n-1) + fibonacci_recursive(n-2);
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int n;
    cin >> n;
    cout << fibonacci_recursive(n);
}