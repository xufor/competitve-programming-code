#include <iostream>

using namespace std;

int main() {
    int x = -1, y = 7;
    cout << (x << 1) << " " << (y << 1);
    //Note that -ve sign is reatined as the first bit is not disturbed
    return 0;
}