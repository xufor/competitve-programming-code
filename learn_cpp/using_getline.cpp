#include <iostream>

// use namespace to avoid writing std::
using namespace std;

// main must always return int
int main() {
    string input_string;
    cout<<"Enter a string: ";
    // always use getline to enter a string which has spaces
    getline(cin, input_string);
    cout<<"You entered: " + input_string;
}