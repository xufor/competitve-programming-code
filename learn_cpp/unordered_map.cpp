#include <iostream>
#include <unordered_map>
#include <map>

using namespace std;

int main() {
    map<char, int> m;
    unordered_map<char, int> u;
    string s = "Hello! I am using WhatsApp.";
    for(char c: s) m[c]++;
    for(char c: s) u[c]++;
    // using at method of unordered maps
    cout<<u.at('a');
    // map accessing tips
    unordered_map< int, pair<int, int> > um;
    um[0] = make_pair(1, 3);
    cout << um[0].second << '\n';
    cout << um.begin() -> second.second << '\n';
    cout << (*um.begin()).second.second << '\n';
}
