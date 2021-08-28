#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

void subsequences(string s, vector<string> &v) {
    if(s.empty()) {
        v.push_back("");
        return;
    }
    subsequences(s.substr(1), v);
    for(int i = 0, c = v.size(); i < c; i++) {
        v.push_back(s[0] + v[i]);
    }
}

int main() {
    string str;
    vector<string> ans;
    cin >> str;
    subsequences(str, ans);
    for(string s: ans) {
        cout << s << nl;
    }
}