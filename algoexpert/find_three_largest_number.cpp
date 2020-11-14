#include <bits/stdc++.h>
#define sp " "
using namespace std;

int main()
{
    int arr[10], largest[3] = { -1, -1, -1 };
    unordered_set<int> um;
    for(int &i: arr)
        cin >> i;
    for(int &x: arr) {
        if(x > largest[0]) {
            largest[2] = largest[1];
            largest[1] = largest[0];
            largest[0] = x;
        }
        else if(x > largest[1]) {
            largest[2] = largest[1];
            largest[1] = x;
        }
        else if(x > largest[2])
            largest[2] = x;
    }
    cout << largest[0] << sp << largest[1] << sp << largest[2];
    return 0;
}





