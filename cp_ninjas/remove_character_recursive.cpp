#include <bits\stdc++.h>
using namespace std;

void remove_character_recursive(char s[], char t) {
    if(s[0] == '\0') {
        return;
    } else if(s[0] != t) {
        remove_character_recursive(s+1, t);
    } else {
        int i = 1;
        for(; s[i] != '\0'; i++) {
            s[i-1] = s[i];
        }
        s[i-1] = s[i];
        remove_character_recursive(s, t);
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    char input[100], target;
    cin >> input >> target;
    remove_character_recursive(input, target);
    cout << input << endl;
}
