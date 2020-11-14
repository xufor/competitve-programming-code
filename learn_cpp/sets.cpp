#include <iostream>
#include <set>
#define print cout

using namespace std;

void print_set(set<int> &s) {
    for(int x: s) {
        cout << x << " ";
    }
}

int main() {
    set<int> s;
    // entering values in sets
    s.insert(1);
    s.insert(2);
    s.insert(-10);
    s.insert(-4);
    s.insert(1); // duplicate is ignored
    // printing in sets
    print_set(s);
    cout << '\n';
    // searching for values in sets
    auto it = s.find(-4);
    if(it == s.end())
        cout << "Not present!\n";
    else
        cout << "The value is present!\n";
    // using lower bound and upper bound on sets
    it = s.upper_bound(-1); // strictly greater than -1
    cout << *it << '\n';
    it = s.lower_bound(0); // not strictly greater than -1
    cout << *it << '\n';
    // check if upper bound even exists
    if(s.upper_bound(2) == s.end()) {
        print << "Does not exist!\n";
    }
    // deleting an element
    s.erase(-10);
    print_set(s);
    return 0;
}

