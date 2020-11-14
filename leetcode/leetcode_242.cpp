#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

bool isAnagram(string s, string t) {
    if(s.length() != t.length()) {
        return false;
    }
    unordered_map<char, int> store;
    for(char x: s) {
        store[x]++;
    }
    for(char x: t) {
        if(store[x]-- == 0) {
            return false;
        }
    }
    return true;
}