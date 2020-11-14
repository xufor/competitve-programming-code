#include <iostream>
#include <set>
#include <climits>

using namespace std;

int main() {
    set< pair<int, int> > s;
    // inserting pairs
    s.insert({ 30, 400 });
    s.insert({ 2, 3} );
    s.insert({ 10, 20} );
    s.insert({ 401, 450} );
    // printing pairs
    for(auto x: s) {
        cout << x.first << " " << x.second << '\n';
    }
    // searching if a point resides in the range of any of the pairs above
    auto it = s.upper_bound({ 50, INT_MAX});
    if (it == s.begin())
        cout << "Does not exist!\n";
    else {
        it--;
        if(it->first <= 50 && it->second >= 50) // accessing the values of a pair
            cout << "Exists!\n";
        else
            cout << "Does not exist!\n";
    }
}
