#include <bits\stdc++.h>
using namespace std;

int check_sorted_recursive(int a[], int n) {
    if(n == 0 || n == 1) {
        return true;
    } else if(a[0] < a[1]) {
        return check_sorted_recursive(a+1, n-1);
    } else {
        return false;
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int n;
    cin >> n;
    int a[n];
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    } 
    cout << check_sorted_recursive(a, n);
}