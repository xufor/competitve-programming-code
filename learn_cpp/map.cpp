#include <iostream>
#include <map>

using namespace std;

int main() {
    map<int, int> m;
    m[1] = 100;
    m[2] = -1;
    m[3] = 200;
    m[4] = 1;
    cout << m[4] << " " << m[5] <<'\n';
    // counting the frequency of a character in string
    map<char, int> count_map;
    string s = "John Carter";
    for(char ch : s) {
        count_map[ch]++;
    }
    cout << count_map['a'] << " " << count_map['e'] << '\n';
    // finding keys
    auto x = m.find(2);
    if(x == m.end())
        cout << "Not present!\n";
    else
        cout << "Present!\n";
    // erasing keys
    m.erase(2);
    x = m.find(2);
    if(x == m.end())
        cout << "Not present!\n";
    else
        cout << "Present!\n";
}



