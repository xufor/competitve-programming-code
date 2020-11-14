#include <iostream>
using namespace std;

class A { 
    private:
        int a = 10;
        static int v;

    public:
        static int b;
        static void get_v() {
            // cout << a; => a static function cannot access non-static members
            cout << v << endl;
        }

        static void update_v() {
            v++;
        }
};

int A::v = 0; 
// this step is important
// this step helps us to convey that this is a variable that is global
// but we will use it inside the class only
// at the time of declaring it you can access it and assign values
// but after this you cannot use :: operator to access it if it is private
// on the other hand if it is public then no problem in accessing it later

int A::b = 10;

int main() {
    A a;
    A b;
    // cout << A::v; => can't do because v is private
    // cout << a.v;
    cout << A::b << '\n'; // 10
    A::b++;
    cout << A::b << '\n'; // 11
    a.update_v();
    a.get_v(); // 1
    A::update_v(); // can use :: operator to call static methods
    A::get_v(); // 2
    b.update_v(); // can use . operator too
    b.get_v(); // 3
}