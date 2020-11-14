#include <iostream>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

int main() {
    // Test-1
    double x = 5.665;
    int y = x;
    cout << x << sp << y << nl; // 5.665 5
    // Test-2
    int d = 5;
    int z = d + x; // even though d is promoted z's type trims it anyways
    cout << z << nl; // 10
    // Test-3
    z = (double)(d + x); // explicit conversion is useless when z is of int type
    cout << z << nl; // 10
    // Test-4
    cout << d + x << nl; // 10.665, d is promoted to double 
    // Test-5
    int e = 9;
    double l = 1.1;
    double f = e + l; // e is IMPLICITLY converted to double, e's promotion occured
    cout << f << nl; // 10.1
    // Test-6
    double k = e + int(l); // l is EXPLICITLY converted to int 
    cout << k << nl; // 10
    // Test-7
    double i = 1.1, j = 2.2;
    int g = i + j; // the double converts to int beacause of the type of g 
    cout << g << nl; // 3
    // Test-8 => IMPORTANT
    int o = 2000000000; // we know that int type ranges from -2,147,483,648 to 2,147,483,647
    int p = 1000000000;
    cout << o << sp << p << nl;
    cout << o + p << nl; // doesn't work
    cout << (ll)(o + p) << nl; // doesn't work, the reason why above statement doesn't work because (o+p) results in overflowed
    // negative value now converting it to ll will still keep the same value 
    cout << (ll)o + p << nl; // works, as one of the operand is ll and other gets promoted
    cout << o + (ll)p << nl; // works, same as above
    cout << (ll)o + (ll)p << nl; // works, same as above
    // Test-9 => IMPORTANT
    ll sum = o + p;// doesn't work, same reason as for line 39
    cout << sum << nl;
    sum = (ll)o + p; // works, same reason as for line 41 
    cout << sum << nl;
    // Test-9 => IMPORTANT
    ll e1 = 20000000000;
    ll e2 = 30000000000;
    cout << e1 + e2 << nl; // works
    int e3 = e1 + e2;
    cout << e3 << nl; // doesn't work, float gets trimmed but as decimal part is removed
    // but when long gets trimmed it turns negative
    cout << (int)e1 + (int)e2 << nl; // disaster
    // Test-10 => IMPORTANT
    int r1 = 2000000000;
    int r2 = 1000000000;
    int r3 = ((ll)r1 + r2) % limit; // works
    int r4 = (r1 + (ll)r2) % limit; // works => USE OF EXPLICIT CONVERSION
    int r5 = (r1 + r2) % limit; // doesn't work
    int r6 = (r1 + r2 * 1LL) % limit; // works => USE OF IMPLICIT CONVERSION
    int r7 = (r1 + r2 + 0LL) % limit; // doesn't work
    cout << r3 << nl << r4 << nl << r5 << nl; // doesn't work
    cout << r6 << nl << r7;
    return 0;
}