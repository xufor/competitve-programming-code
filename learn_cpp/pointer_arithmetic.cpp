#include <iostream>
using namespace std;

int main() {
    int *arr = new int[5];
    for (int i = 0; i < 5; i++) { // note that i lives oly in this for block
        arr[i] = i+1; // now you can treat arr as if it were an normal array name
        cout << arr[i] << " " << i[arr] << " " << *(i + arr) << endl; // variety of options
    }
    // incrementing pointer
    int *t_arr = arr;
    for (int i = 0; i < 5; i++) {
        cout << *(t_arr++) << " ";
    }
    // increasing pointer value by 2
    int *tt_arr = arr;
    cout << endl;
    for (int i = 0; i < 2; i++) {
        cout << *tt_arr << " ";
        tt_arr += 2;
    }
    cout << endl << tt_arr - arr;
    // the answer is difference in positions of pointers not actual value
    delete []arr;
    return 0;
}