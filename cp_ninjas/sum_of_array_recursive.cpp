#include <bits\stdc++.h>
using namespace std;

int sum_of_array_recursive(int input[], int n) {
	if(n == 0) {
        return 0;
    } else {
    	return input[0] + sum_of_array_recursive(input+1, n-1);
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
    cout << sum_of_array_recursive(a, n);
}