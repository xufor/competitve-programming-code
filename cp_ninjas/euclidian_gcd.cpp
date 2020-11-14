#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
using namespace std;

int gcd(int a, int b) {
    if(b > a) { 
        // if b is greater then reverse and call 
        // and now the second parameter will never be larger than first parameter
        return gcd(b, a);
    }
    if(b == 0) {
        return a;
    }
    return gcd(b, a%b);
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int a, b;
    cin >> a >> b;
    cout << gcd(a, b);
    return 0;
}