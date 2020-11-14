#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

int main() {
    int target = 10;
    vector<int> den = { 1, 5, 10, 25 };
    vector<int> ways(target+1, 0);
    ways[0] = 1;
    for(int d: den) {
        for (int i = 1; i <= target; i++) {
            if(ways[i] <= d) {
                ways[i] += ways[i - d];
            }
        }
    }
    cout << *ways.rbegin();
    return 0;
}

