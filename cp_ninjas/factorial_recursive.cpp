#include <bits\stdc++.h>
using namespace std;

int factorial_recursive(int n) {
    if(n == 0) {
        return 1;
    } else {
        return n * factorial_recursive(n-1);
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int n;
    cin >> n;
    cout << factorial_recursive(n);
}