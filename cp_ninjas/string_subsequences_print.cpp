#include <bits\stdc++.h>
using namespace std;

void string_subsequences(string input, string output) {
    if(input.empty()) {
        cout << output << endl;
        return;
    }
    string_subsequences(input.substr(1), output);
    string_subsequences(input.substr(1), output + input[0]);
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    string input;
    cin >> input;
    string_subsequences(input, "");
}
