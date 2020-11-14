#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

string longestCommonPrefix(vector<string>& strs) {
    if(strs.size() == 0) {
        return "";
    }
    int m = INT_MAX;
    string cp;
    for(string s: strs) {   
        m = min(m, (int)s.length());
    }
    for(int i = 0; i < m; i++) {
        char c = strs[0][i];
        bool flag = false;
        for(string s: strs) {
            if(s[i] == c)
                continue;
            flag = true;    
            break;
        }
        if(flag) {
            break;
        }
        else {
            cp += c;
        }
    }
    return cp;
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
        string s;
        vector<string> v;
        cin >> n;
        while(n--) {
            cin >> s;
            v.push_back(s);
        }
        cout << longestCommonPrefix(v) << nl;
    }
    return 0;
}