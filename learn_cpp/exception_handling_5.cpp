#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define limit 1000000007
typedef long long ll;
using namespace std;

class SizeZeroException: public exception { 
	virtual const char* what() const throw() {
		return "SizeZeroException Occured";
	}
};

void func(int size) {
	cout << "Fun 0" << nl;
	try {
		cout << "Fun 1" << nl;
		if(size == 0) throw SizeZeroException(); 
		cout << "Fun 2" << nl;
	}
	catch(exception &e) { 
		// when a base class object is created
		// and the virtual function is overidden in the derived class
		// the fuction of derived class will be called
		cout << e.what(); 
	} 
	cout << nl;
	cout << "Fun 3" << nl;
}

int main() {
	cout << "Main 0" << nl;
	func(0);
	cout << "Main 1" << nl;
	return 0; 
} 
