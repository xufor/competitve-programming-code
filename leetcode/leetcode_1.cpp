#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

vector<int> twoSum(vector<int>& nums, int target) {
    int a, b;
    unordered_map<int, int> um;
    for(int i = 0; i < nums.size(); i++) {
        auto it = um.find(target - nums[i]);
        if(it != um.end()) {
            a = it -> second; 
            b =  i;
            break;
        } 
        else {
            if(um.find(nums[i]) == um.end()) {
                um[nums[i]] = i;
            }
        }
    }
    vector<int> v{a, b};
    return v;
}

int main()
{
    #ifndef ONLINE_JUDGE
        freopen("input.txt", "r", stdin);
        freopen("output.txt", "w", stdout);
    #endif
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int ntc;
    cin >> ntc;
    while(ntc--) {
        int n, t;
        cin >> n >> t;
        vector<int> v(n);
        for(int i = 0; i < n; i++) {
            cin >> v[i];
        }
        auto r = twoSum(v, t);
        cout << r[0] << sp << r[1] << nl;
    }
    return 0;
}