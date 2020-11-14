#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

int main()
{
    vector<int> arr = { -8, -6, 1, 2, 3, 5, 6, 12 };
    int sum = 0, j , k, l = arr.size();
    sort(arr.begin(), arr.end());
    for(int i = 0; i < l - 2; i++) {
        j = i + 1;
        k =  l - 1;
        while(j < k) {
            if(arr[i] + arr[j] + arr[k] > sum)
                k--;
            else if(arr[i] + arr[j] + arr[k] < sum)
                j++;
            else {
                cout << arr[i] << sp << arr[j] << sp << arr[k] << nl;
                j++;
                k--;
            }

        }
    }
    return 0;
}





