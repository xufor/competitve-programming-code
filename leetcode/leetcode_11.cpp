#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

int maxArea(vector<int>& h) {
    int i = 0, j = h.size() - 1, ms;
    while(i < j) {
        ms = max(ms, min(h[i], h[j]) * (j-i));
        if(h[i] > h[j]) 
            j--;
        else 
            i++;
    }
    return ms;
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
        int n, e;
        cin >> n;
        vector<int> v;
        while(n--) {
            cin >> e;
            v.push_back(e);
        }
        cout << maxArea(v) << nl;
    }
    return 0;
}