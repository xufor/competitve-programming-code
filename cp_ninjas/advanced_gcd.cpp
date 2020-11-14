#include <bits\stdc++.h>
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

int mega_mod(string n, int m) {
    int next = 0;
    for(int i = 0; i < n.length(); i++) {
        next = (next * 10 + stoi(string(1, n[i]))) % m;
        cout << next << endl;
    }
    return next;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int b;
    string a;
    cin >> a >> b;
    cout << gcd(b, mega_mod(a, b));
    return 0;
}