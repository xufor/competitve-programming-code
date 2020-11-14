#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

int reverse(int x) {
    int d, r = 0;
    while(x) {
        d = x % 10;
        if(r > INT32_MAX/10 || (r == INT32_MAX/10 && d > 7)) return 0;
        if(r < INT32_MIN/10 || (r == INT32_MIN/10 && d < -8)) return 0;
        r = r * 10 + d;
        x = x / 10;
    }
    return r;
}

int main()
{
    #ifndef ONLINE_JUDGE
        freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    #endif
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int ntc;
    cin >> ntc;
    while(ntc--) {
        int n;
        cin >> n;
        cout << reverse(n) << nl;
    }
    return 0;
}