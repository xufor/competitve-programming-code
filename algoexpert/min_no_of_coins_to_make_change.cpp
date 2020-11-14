#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

int main() {
    int sum = 11, den[3] = { 1, 2, 5 };
    vector<int> dp(12, sum+1);
    dp[0] = 0;
    for(int i = 1; i <= sum; i++) {
        for(int d: den) {
            if(i >= d) {
                dp[i] = min(dp[i-d] + 1, dp[i]);
            }
        }
    }
    cout << *dp.rbegin();
    return 0;
}
