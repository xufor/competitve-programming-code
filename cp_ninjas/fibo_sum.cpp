#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define md 1000000007
#define pb push_back
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
    if(n == 1 || n == 0) {
        return;
    }
    matrix_expo(A, n/2);
    multiply(A, A); // Multiplying A^(n/2) with A^(n/2)
    if(n%2 != 0) {
        int M[2][2] = {{1,1}, {1,0}};
        multiply(A, M);
    }
}

int fiboSum(int m, int n) {
    // find sum of fibonacci number n to m (both inclusive)
    if(m < n) 
        swap(m, n);
    int M[2][2] = {{1,1}, {1,0}}, N[2][2] = {{1,1}, {1,0}};
    // by derivation we found that fiboSum(n) = F(m+2) - F(n+1)
    matrix_expo(M, m+1); // m+2-1 => m+1
    matrix_expo(N, n); // n+1-1 => n
    return M[0][0] - N[0][0];
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int m, n;
    cin >> m >> n;
    cout << fiboSum(m, n) << nl;
    // So fiboSum(5,1) => sum of F(1) to F(5) is 12
    // Acc. to the derivation fiboSum(n) = F(m+2) - F(n+1)
    // So F(7)-F(2) => 13-1 => 12
    return 0;
}