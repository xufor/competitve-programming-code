#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

int main() {
    string s1, s2;
    // Please note that s1 changes to s2.
    cin >> s1 >> s2;
    int l1 = s1.length();
    int l2 = s2.length();
    // See that we are putting the source string characters on the columns of matrix.
    int dp[l2+1][l1+1], i, j;
    dp[0][0] = 0;
    for(i = 1; i <= l1; i++)
        dp[0][i] = i;
    for(i = 1; i <= l2; i++)
        dp[i][0] = i;
    for(i = 1; i <= l2; i++) {
        for(j = 1; j <= l1; j++) {
            if(s1[j-1] == s2[i-1])
                dp[i][j] = dp[i-1][j-1];
            else
                dp[i][j] = min(dp[i-1][j-1], min(dp[i-1][j], dp[i][j-1])) + 1;
        }
    }
    cout << dp[l2][l1];
    return 0;
}