#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

vector<int> sortArray(vector<int>& nums) {
    sort(nums.begin(), nums.end());
    return nums;
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
        int n, x;
        cin >> n;
        vector<int> v;
        while(n--) {
            cin >> x;
            v.push_back(x);
        }
        for(int x: sortArray(v)) {
            cout << x << sp;
        }
    }
    return 0;
}