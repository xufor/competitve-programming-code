#include <bits\stdc++.h>
using namespace std;

int length_of_string_recursive(string s) {
    if(s[0] == '\0') {
        return 0;
    } else {
        return 1 + length_of_string_recursive(s.substr(1));
    }
}

int length_of_string_recursive(char s[]) {
    if(s[0] == '\0') {
        return 0;
    } else {
        return 1 + length_of_string_recursive(s+1);
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    char s[100];
    cin >> s;
    cout << length_of_string_recursive(s) << endl;
    string str(s); 
    // passed a null character terminated array to string class constructor
    cout << length_of_string_recursive(str);
}
