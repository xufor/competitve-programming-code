#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

int threeSumClosest(vector<int>& nums, int target) {
    sort(nums.begin(), nums.end());
    int sum = 9999, j, k, cur_sum;
    for(int i = 0; i < nums.size()-2; i++) {
        j = i + 1;
        k = nums.size() - 1;
        while(j < k) {
            int cur_sum = nums[i] + nums[j] + nums[k];
            if(cur_sum > target) {
                k--;
            }
            else if(cur_sum < target) {
                j++;
            }
            else {
                sum = cur_sum;
                k--;
                j++;
                continue;
            }
            if(abs(target - cur_sum) < abs(target - sum)) {
                sum = cur_sum;
            }
        }
    }
    return sum;
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
        int n, x, t;
        vector<int> v;
        cin >> n >> t;
        while(n--) {
            cin >> x;
            v.push_back(x);
        }
        cout << threeSumClosest(v, t) << nl;
    }
    return 0;
}