#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

/* ---------- Stack Unwinding ---------- */

void func() {
	cout << "Fun 0" << nl;
	try {
		cout << "Fun 1" << nl;
		throw (double)11.22; // all statements after this statement skipped
		cout << "Fun 2" << nl;
	}
	catch(int x) { cout << x; } // the type of the value thrown is matched with matching catch block
	catch(string y) { cout << y; }
	cout << nl;
	cout << "Fun 3" << nl; // since no type matched this statement is also skipped
}

int main() {
	cout << "Main 0" << nl;
	try {
		cout << "Main 1" << nl;
		func(); // all statements after this statement are skipped as exception is still not caught
		cout << "Main 2" << nl;
	}
	catch(double z) { cout << z; } // a match is found here
	cout << nl;
	cout << "Main 3" << nl; // since the exception was caught this statement will execute 
	return 0; 
} 
