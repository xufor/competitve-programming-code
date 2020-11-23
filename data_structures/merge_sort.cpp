#include <bits/stdc++.h>
using namespace std;

void merge(vector<int> &arr, int low, int mid, int high) {
    vector<int> left, right, result;
    for(int i = low; i <= mid; i++) {
        left.push_back(arr[i]);
    }
    for(int i = mid+1; i <= high; i++) {
        right.push_back(arr[i]);
    }
    left.push_back(INT_MAX);
    right.push_back(INT_MAX);
    int i = 0, j = 0;
    while(result.size() <= high-low+1) {
        if(left[i] < right[j]) {
            result.push_back(left[i++]);
        }
        else {
            result.push_back(right[j++]);
        }
    }
    for(i = low, j = 0; i <= high; i++, j++) {
        arr[i] = result[j];
    }
}

void merge_sort(vector<int> &arr, int low, int high) {
    if(low < high) {
        int mid = (low + high)/2;
        merge_sort(arr, low, mid);
        merge_sort(arr, mid+1, high);
        merge(arr, low, mid, high);
    }
}

int main() {
    vector<int> arr = {1, 7, 8, 4, 2, 5, 0, 9, 3, 6};
    merge_sort(arr, 0, arr.size() - 1);
    for(int x: arr) {
        cout << x << " ";
    }
}