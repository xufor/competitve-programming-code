#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

int main()
{
    vector<int> a1 = { -1, 5, 10, 20, 28, 3 };
    vector<int> a2 = { 26, 134, 135, 15, 17, 222, 321};
    // In simple words try to bring the number closer to other number0
    // so that the difference remains minimum. Don't worry about the numbers
    // already seen before as they are only gonna make difference larger.
    int i1 = 0, i2 = 0, d = INT_MAX, l1 = a1.size(), l2 = a2.size(), ans[2];
    sort(a1.begin(), a1.end());
    sort(a2.begin(), a2.end());
    while(i1 < l1 && i2 < l2) {
        if(a1[i1] == a2[i2]) {
            d = 0;
            break;
        }
        else if(a1[i1] < a2[i2]) {
            i1++;
            if(abs(a1[i1] - a2[i2]) < d) {
                d = abs(a1[i1] - a2[i2]);
                ans[0] = a1[i1];
                ans[1] = a2[i2];
            }
        }
        else {
            i2++;
            d = min(d, abs(a1[i1] - a2[i2]));
            if(abs(a1[i1] - a2[i2]) < d) {
                d = abs(a1[i1] - a2[i2]);
                ans[0] = a1[i1];
                ans[1] = a2[i2];
            }
        }
    }
    cout << ans[0] << sp << ans[1];
    return 0;
}






