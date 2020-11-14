#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

string convert(string s, int n) {
    if(n == 1) return s;
    if(s == "") return "";
    string result;
    int l = s.length();
    int d = 2*n-3;
    vector< pair<int, int>> v;
    int i = 0, j = 0;
    while(true) {
        i = j;
        j = i+d+1;
        v.push_back(make_pair(i, j));
        if(j >= l) break;
    }
    for(auto &p: v) {
        result.push_back(s[p.first]);
        p.first++;
        p.second--;
    }
    for(i = 0; i <= d/2; i++) {
        for(auto it = v.begin(); it < v.end(); it++) {
            if(it -> first + i == it -> second - i) {
                if(it -> first + i < l)
                    result.push_back(s[it -> first + i]);
            } 
            else {
                if(it == v.end()-1) {
                    if(it -> first + i < l)
                        result.push_back(s[it -> first + i]);
                    if(it -> second - i < l)
                        result.push_back(s[it -> second - i]);
                } 
                else {
                    result.push_back(s[it -> first + i]);
                    result.push_back(s[it -> second - i]);
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
        int n;
        string s;
        cin >> s >> n;
        cout << convert(s, n) << nl;
    }
    return 0;
}   