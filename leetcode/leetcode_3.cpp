#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

int lengthOfLongestSubstring(string s) {
    int i = 0, j = 0, l = s.length(), m = -1;
    unordered_set<char> us;
    while(i < l && j < l) {
        if(us.find(s[j]) == us.end()) {
            us.insert(s[j]);
            j++;
        }
        else {
            m = max(m,  j-i);
            while(s[i] != s[j]) {
                us.erase(s[i]);
                i++;
            }
            i++;
            j++;
        }
    }
    return max(m, j-i);
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
        cout << lengthOfLongestSubstring(s) << nl;
    }
    return 0;
}
