#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

void subsequences(string input, string output) {
    if(input.empty()) {
        cout << output << nl;
        return;
    }
    subsequences(input.substr(1), output);
    subsequences(input.substr(1), output + input[0]);
}

int main() {
    string str;
    cin >> str;
    subsequences(str, "");
}