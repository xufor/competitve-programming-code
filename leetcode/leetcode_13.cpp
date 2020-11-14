#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

int v(char &c) {
    switch(c) {
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;

    }
    return 0;
}

int romanToInt(string s) {
    if(s.length() == 0) 
        return 0;
    int result = 0;
    for(int i = 0; i < s.length() - 1; i++) {
        if(v(s[i+1]) <= v(s[i])) {
            result += v(s[i]);
        }
        else {
            result -= v(s[i]);
        }
    }
    result += v(s[s.length()-1]);
    return result;
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
        cout << romanToInt(s) << nl;
    }
    return 0;
}