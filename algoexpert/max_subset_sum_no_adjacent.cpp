#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

int main() {
     vector<int> arr = { 7, 10, 12, 7, 9, 14 };
     vector<int> tmp;
     tmp.push_back(arr[0]);
     tmp.push_back(arr[1]);
     for(int i = 2; i < arr.size(); i++)
         tmp.push_back(max(tmp[i-1], tmp[i-2] + arr[i]));
     cout << *tmp.rbegin();
     return 0;
}











