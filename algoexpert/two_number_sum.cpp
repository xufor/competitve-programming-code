#include <bits/stdc++.h>
using namespace std;

int main()
{
    int arr[5], sum;
    unordered_set<int> um;
    for(int &i: arr)
        cin >> i;
    cin >> sum;
    // Maintain an additional store that will keep record of all numbers that have
    // occurred before the current index any any other index. If the number required
    // to form the sum is already in our store then two number sum is possible.
    for(int &x: arr)
        if(um.find(sum-x) != um.end()) {
            cout << 1;
            break;
        }
        else
            um.insert(x);
    cout << 0;
    return 0;
}





