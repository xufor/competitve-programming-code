#include <bits\stdc++.h>
using namespace std;

void sieve_of_eratosthenes(bool sieve[], int n) {
    sieve[0] = sieve[1] = false;
    for(int i = 2; i <= sqrt(n); i++) {
        if(sieve[i]) {
            // start from i*i not i*2
            // if you are going for multiples of 5
            // 5*2 is already covered as 2*5
            // 5*3 is already covered as 3*5
            // 5*4 is already covered as 2*10
            // 5*5 is where you begin checking the multiples from
            for(int j = i*i; j <= n; j+=i) { 
                sieve[j] = false;
            }
        }
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int n;
    cin >> n;
    bool sieve[n+1];
    memset(sieve, true, n+1);
    sieve_of_eratosthenes(sieve, n);
    for(int i = 0; i <= n; i++) {
        cout << i << " : " << sieve[i] << endl;
    }
}