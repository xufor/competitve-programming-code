#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

bool check_bracket(string &exp) {
    stack<char> s;
    for(char c: exp) {
        if(c == '{' || c == '(' || c == '[') {
            s.push(c);
        }
        else if (c == '}' && s.top() == '{') {
            s.pop();
        }
        else if (c == ')' && s.top() == '(') {
            s.pop();
        }
        else if (c == ']' && s.top() == '[') {
            s.pop();
        }
    }
    return s.empty();
}

int main() {
    string s;
    cin >> s;
    cout << (check_bracket(s) ? "Balanced" : "Unbalanced");
}