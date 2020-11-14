#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define md 1000000007
#define pb push_back
#define br break
#define MAX 500001
typedef long long ll;
using namespace std;

int mode_expo(int a, int n) {
    if(n == 0)
        return 1;
    else if(n % 2 == 0)
        return mode_expo((1LL * a * a) % md, n/2);
    return (1LL * a * mode_expo(a, n-1)) % md;
}

int fermet_theorem(int a, int p) {
    // Note that if (a*b) % m = 1
    // Then b is multiplicative modulo inverse of a
    return mode_expo(a, p-2) % p;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    // p -is a prime no.
    // (a^p) % p = p
    // (a^(p-1)) % p = 1
    // after some magic
    // (a^(-1)) % p = (a^(p-2)) % p
    // (a^(p-2)) % p can be done using modular exponentiation
    int a, p;
    cin >> a >> p;
    cout << fermet_theorem(a, p);
    return 0;
}