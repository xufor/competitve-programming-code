#include <iostream>
using namespace std;

int main() {
    int x(55);
    int *p = &x;
    cout << x << " " << (int)p << " " << *p << " " << (int)&p << endl;
    int a[5];              // this declaration occurs in stack m/m not heap m/m
    int *arr = new int[5]; // this declaration occurs in heap m/m not stack m/m
    for(int i = 0; i < 5; i++) {
        arr[i] = i; // now you can treat arr as if it were an normal array name
        cout << arr[i] << endl;
    }
    delete[] p; // this is the way to deallocate heap memory of array type
    // and it is necessary to do that when the memory is no longer needed
    p = nullptr; // now assign nullptr to p
    return 0;
}