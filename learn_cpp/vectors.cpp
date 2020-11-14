#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool fun(int x, int y) {
    return x>y;
}

int main() {
    vector<int> v = { 432,997,4,75,21 };
    cout << v[2] << "\n";

    // sorting
    sort(v.begin(), v.end());

    // binary search
    bool present = binary_search(v.begin(), v.end(), 75);
    cout << present << '\n';

    // inserting element at the end
    v.push_back(1000);
    v.push_back(1000);
    v.push_back(1000);
    v.push_back(1023);

    // iterators
    // we can now use auto i1 instead of vector<int>::iterator i1
    auto i1 = lower_bound(v.begin(), v.end(), 1000); // >=
    auto i2 = upper_bound(v.begin(), v.end(), 1000); // >
    cout << *i1 << " " << *i2 <<endl;
    cout << i2 - i1 <<endl; // O(1)

    // sorting in descending order
    sort(v.begin(), v.end(), fun);

    // printing the vector
    /* vector<int>::iterator i;
     for(i = v.begin(); i != v.end(); i++) {
       cout << *i << " ";
    } */

    // all of above material can be avoided nowadays
    for(int element: v) {
        cout << element << " "; // you can't alter the element yet though
    }
    cout<<endl;
    // for altering use pass by reference
    for(int &element: v) {
        element++;
    }
    // now again check
    for(int element: v) {
        cout << element << " "; // you can't alter the element yet though
    }
    cout << endl;
}

