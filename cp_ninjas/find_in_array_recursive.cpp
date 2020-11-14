#include <bits\stdc++.h>
using namespace std;

bool find_in_array_recursive(int input[], int n, int x) {
	if(n == 0) {
        return false;
    } else if(input[0] == x) {
    	return true;
    } else {
        find_in_array_recursive(input+1, n-1, x);
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int n, x;
    cin >> n >> x;
    int a[n];
    for(int i = 0; i < n; i++) {
        cin >> a[i];
    } 
    cout << find_in_array_recursive(a, n, x);
}