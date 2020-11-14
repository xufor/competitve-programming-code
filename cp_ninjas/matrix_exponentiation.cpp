#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define pb push_back
#define md 1000000007
#define br break
#define MAX 500001
typedef long long ll;
using namespace std;

void multiply(int A[2][2], int M[2][2]) {
    int v1 = A[0][0] * M[0][0] + A[0][1] * M[1][0];
    int v2 = A[0][0] * M[0][1] + A[0][1] * M[1][1];
    int v3 = A[1][0] * M[0][0] + A[1][1] * M[1][0];
    int v4 = A[1][0] * M[0][1] + A[1][1] * M[1][1];
    A[0][0] = v1;
    A[0][1] = v2;
    A[1][0] = v3;
    A[1][1] = v4;
}

void matrix_expo(int A[2][2], int n) {
    if(n == 1) { // n == 0 is handled in the nth_fibo function
        return;
    }
    matrix_expo(A, n/2);
    multiply(A, A); // Multiplying A^(n/2) with A^(n/2)
    if(n%2 != 0) {
        int M[2][2] = {{1,1}, {1,0}};
        multiply(A, M);
    }
}

int nth_fibo(int n) {
    int A[2][2] = {{1,1}, {1,0}};
    // We have to find A^(n-1) to find nth fibonacci number
    if(n == 0) {
        return 0;
    } else if (n == 1) {
        return 1;
    }
    matrix_expo(A, n-1);
    return A[0][0];
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int n;
    cin >> n;
    cout << nth_fibo(n) << nl;
    return 0;
}