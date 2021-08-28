#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

vector<string> key_data = { "", "", "abc", "def", "ghi", 
    "jkl", "mno", "pqrs", "tuv", "wxyz" };

void keypad(int seq, vector<string> &v) {
    if(seq == 0) {
        v.push_back("");
        return;
    }
    keypad(seq / 10, v);

    int orig_size = v.size();
    for(char c: key_data[seq % 10]) {
        for(int i = 0; i < orig_size; i++) {
            v.push_back(c + v[i]);
        }
    }
    for(int i = 0; i < orig_size; i++) {
        v.erase(v.begin());
    }
}

int main() {
    int seq;
    vector<string> ans;
    cin >> seq;
    keypad(seq, ans);
    for(string s: ans) {
        cout << s << nl;
    }
}