#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define pb push_back
#define md 1000000007 
#define br break
#define MAX 500001
typedef long long ll;
using namespace std;

int mod_expo(int a, int n) {
    if(n == 0)
        return 1;
    if(n%2 == 0)
        return mod_expo((1LL * a * a) % md , n/2);
    return (1LL * a * mod_expo(a, n-1)) % md ;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int a, b;
    cin >> a >> b;
    cout << mod_expo(a, b) << nl;
    return 0;
}