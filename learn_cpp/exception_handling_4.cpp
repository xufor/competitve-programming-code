#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

class SizeZeroException { };
class SizeNegativeException { };

void func(int size) {
	cout << "Fun 0" << nl;
	try {
		cout << "Fun 1" << nl;
		if(size == 0) throw SizeZeroException(); 
		if(size < 0) throw SizeNegativeException();
		cout << "Fun 2" << nl;
	}
	catch(SizeZeroException &e) { cout << "Size is zero."; } 
	catch(SizeNegativeException &e) { cout << "Size is negative."; }
	cout << nl;
	cout << "Fun 3" << nl;
}

int main() {
	cout << "Main 0" << nl;
	func(0);
	func(-10);
	cout << "Main 1" << nl;
	return 0; 
} 
