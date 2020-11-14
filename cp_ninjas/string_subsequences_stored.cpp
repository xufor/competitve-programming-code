#include <bits\stdc++.h>
using namespace std;

void string_subsequences(string input, vector<string>& output) {
    if(input.empty()) {
        output.push_back("");
        return;
    }
    string_subsequences(input.substr(1), output);
    int size = output.size();
    for(int i = 0; i < size; i++) {
        output.push_back(input[0] + output[i]);
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    string input;
    vector<string> result;
    cin >> input;
    string_subsequences(input, result);
    for(string s: result) {
        cout << s << endl;
    }
}
