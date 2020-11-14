#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
    unordered_map<int, int> store;
    vector<int> result;
    for(int x: nums1) {
        store[x]++;
    }
    for(int &x: nums2) {
        if(store[x] > 0) {
            result.push_back(x);
            store[x]--;
        }
    }
    return result;
}