#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

vector<string> key_data = { "", "", "abc", "def", "ghi", 
    "jkl", "mno", "pqrs", "tuv", "wxyz" };

void keypad(int input, string output) {
    if(input == 0) {
        cout << output << nl;
        return;
    }
    for(char c: key_data[input % 10]) {
        keypad(input / 10, output + c);
    }
}

int main() {
    int seq;
    cin >> seq;
    keypad(seq, "");
}