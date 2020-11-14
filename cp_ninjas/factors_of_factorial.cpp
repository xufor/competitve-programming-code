#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
#define pb push_back
#define br break
#define MAX 500001
typedef long long ll;
using namespace std;

bool sieve[MAX];
vector<int> primes;

void make_sieve() {
    memset(sieve, true, MAX);
    sieve[0] = sieve[1] = false;
    for(int i = 2; i < MAX; i++) {
        if(sieve[i]) {
            for(int j = i*i; j <= MAX; j+=i) {
                sieve[j] = false;
            }
        }
    }
    primes.pb(2);
    // do not check any even numbers
    for(int i = 3; i <= MAX; i+=2) {
        if(sieve[i]) {
            primes.pb(i);
        }
    }
}

ll divisors(int n) {
    ll result = 1;
    for(int p: primes) {
        if(p > n) br;
        ll t = n, c = 0, d;
        while(t >= p) {
            d = t/p;
            t = d;
            c += d;
        }
        result *= (c+1);
        result %= limit;
    }
    return result;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    make_sieve();
    int n;
    cin >> n;
    cout << divisors(n) << nl;
    return 0;
}