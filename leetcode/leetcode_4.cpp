#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
    int t = nums1.size() + nums2.size();
    int c1 = t/2, c2 = c1+1, arr[2], cv, i = 0, j = 0, c = 0;
    nums1.push_back(INT_MAX);
    nums2.push_back(INT_MAX);
    while(i <= nums1.size() && j <= nums2.size()) {
        if(nums1[i] <= nums2[j]) {
            cv = nums1[i++];
        }
        else {
            cv = nums2[j++];
        }
        c++;
        if(c == c1) {
            arr[0] = cv;
        }
        else if(c == c2) {
            arr[1] = cv;
            break;
        }
    }
    if(t%2 == 0)
        return (double)(arr[0]+arr[1])/2;
    return (double)arr[1];
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
        int n1, n2;
        cin >> n1 >> n2;
        vector<int> v1(n1);
        vector<int> v2(n2);
        for(int i = 0; i < n1; i++) {
            cin >> v1[i];
        }
        for(int i = 0; i < n2; i++) {
            cin >> v2[i];
        }
        cout << findMedianSortedArrays(v1, v2) << nl;
    }
    return 0;
}