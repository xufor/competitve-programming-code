#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define md 1000000007
#define pb push_back
#define br break
#define MAX 500001
typedef long long ll;
using namespace std;

int mod_expo(int a, int n) {
    int multiplier = a, result = 1;
    while(n) {
        if(n&1 == 1) {
            // momentary implicit upgradation of expression to long ong
            result = (1LL * result % md * multiplier % md) % md;
        }
        multiplier = (1LL * multiplier % md * multiplier % md) % md;
        n /= 2;
    }
    return result;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int a, b;
    cin >> a >> b;
    cout << mod_expo(a, b) << nl;
    return 0;
}