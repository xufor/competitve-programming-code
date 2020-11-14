#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

string longestPalindrome(string s) {
    int m = -1, mi = 0;
    int l = s.length();
    if(!l) return "";
    bool dp[l][l];
    memset(dp, false, sizeof(dp)); 
    for(int i = 0; i < l; i++) {
        dp[i][i] = true;
    }
    for(int k = 1; k < l; k++) {
        int i = 0, j = k; 
        while(i < l && j < l) {
            if(s[i] != s[j]) {
                dp[i][j] = false;
            }
            else if(i+1 == j || dp[i+1][j-1]) {
                dp[i][j] = true;
                if(j-i+1 > m) {
                    mi = i;
                    m = j-i+1;
                }
            }
            i++;
            j++;
        }
    }
    if(m == -1) 
        return s.substr(0, 1);
    return s.substr(mi, m);
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
        string s;
        cin >> s;
        cout << longestPalindrome(s) << nl;
    }
    return 0;
}