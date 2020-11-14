#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

int myAtoi(string str) {
    int result = 0;
    bool f = false, n = false, s = false; 
    for(char c: str) {
        if(isdigit(c)) {
            if(abs(result) > INT32_MAX/10) {
                if(n)
                    return INT32_MIN;
                else 
                    return INT32_MAX;    
            }
            if(abs(result) == INT32_MAX/10) {
                if(!n && stoi(string(1, c)) > 7) {
                    return INT32_MAX;
                }
                else if(n && stoi(string(1, c)) > 8) {
                    return INT32_MIN;
                }
            }
            if(n) {
                result = (result * 10) + -stoi(string(1, c));
            }
            else {
                result = (result * 10) + stoi(string(1, c));
            }
            if(!f) {
                f = true;
            }
        }
        else {
            if(f) {
                break;
            }
            else {
                if(!s && c == ' ') {
                    continue;
                }
                else if(!s && c == '-') {
                    n = true;
                    s = true;
                }
                else if(!s && c == '+') {
                    n = false;
                    s = true;
                }
                else {
                    return 0;
                }
            }
        }
    }
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
        cout << myAtoi(s) << nl;
    }
    return 0;
}