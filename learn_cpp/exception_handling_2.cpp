#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

void func() {
	cout << "Fun 0" << nl;
	try {
		cout << "Fun 1" << nl;
		throw 0; // all statements after this statement skipped
		cout << "Fun 2" << nl;
	}
	catch(int x) { cout << x; } // the type of the value thrown is matched with matching catch block
	catch(string y) { cout << y; }
	catch(...) { cout << "General catch hit."; }
	cout << nl;
	cout << "Fun 3" << nl; // after the exception is resolved all statements after the try catch block are executed
}

int main() {
	cout << "Main 0" << nl;
	try {
		cout << "Main 1" << nl;
		func(); // all statements after this statement are executed
		cout << "Main 2" << nl;
	}
	catch(double z) { cout << z; }
	cout << "Main 3" << nl;
	return 0; 
} 
