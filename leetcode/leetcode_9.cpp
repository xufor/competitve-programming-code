#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

bool isPalindrome(int x) {
    if(x == 0) {
        return true;
    }
    else if(x < 0) {
        return false;
    }
    else {
        long long n = x, d, r = 0;
        while(n) {
            d = n % 10;
            r = r * 10 + d;
            n = n / 10;
        }
        if (x == r) {
            return true;
        }
    }
    return 0;
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
        cout << isPalindrome(n) << nl;
    }
    return 0;
}