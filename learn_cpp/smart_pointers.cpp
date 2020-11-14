#include <iostream>
#include <memory>

using namespace std;

int main() {
    unique_ptr<string> p(new string("Hello World!"));
    cout << p->length();
}