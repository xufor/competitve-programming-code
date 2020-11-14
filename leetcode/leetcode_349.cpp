#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
    unordered_set<int> store, answers;
    for(int x: nums1) {
        store.insert(x);
    }
    for(int x: nums2) {
        if(store.find(x) != store.end()) {
            answers.insert(x);
        }
    }
    vector<int> result;
    for(int x: answers) {
        result.push_back(x);
    }
    return result;
}