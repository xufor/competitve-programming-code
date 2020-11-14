#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define md 1000000007
typedef long long ll;
using namespace std;

void print(int *arr, int len) {
    for(int i = 0; i < len ; i++) {
        cout << arr[i] << sp;
    }
    cout << nl;
}

void insert(int *arr, int pos, int val, int len) {
    for(int i = pos-1; i < len - 1; i++) {
        arr[i+1] = arr[i];
    }
    arr[pos-1] = val;
}

int search(int *arr, int val, int len) {
    for(int i = 0; i < len; i++) {
        if(arr[i] == val) {
            return i;        
        }
    }
    return -1;
}

void remove(int *arr, int val, int len) {
    int p = search(arr, val, len);
    if(p != -1) {
        for(int i = p; i < len - 1; i++) {
            arr[i] = arr[i+1];
        }
    }
}

int second_largest(int *arr, int len) {
    int l = 0, sl = -1;
    for(int i = 1; i < len; i++) {
        if(arr[i] > arr[l]) {
            sl = l;
            l = i;
        }
        else if(arr[i] != arr[l]) {
            if(sl == -1 || arr[i] > arr[sl]) {
                sl = i;
            }
        }
    }
    return sl;
}

void reverse(int *arr, int low, int high) {
    for(int i = low; i < (high+1)/2; i++) {
        swap(arr[i], arr[high-i]);
    }
}

void left_rotate(int *arr, int len, int d) {
    reverse(arr, 0, d-1);
    reverse(arr, d, len-1);
    reverse(arr, 0, len-1);
}

int max_difference(int *arr, int len) {
    int max_diff = arr[1] - arr[0], min_element = arr[0];
    for(int i = 1; i < len; i++) {
        max_diff = max(max_diff, arr[i] - min_element);
        min_element = min(min_element, arr[i]);
    }
    return max_diff;
}

void move_zeroes_to_end(int *arr, int len) {
    int j = 0;
    for(int i = 0; i < len; i++) {
        if(arr[i] != 0) {
            swap(arr[i], arr[j++]);
        } 
    }
}

int maxp(int *price, int start, int end) {
    if(end <= start) {
        return 0;
    }
    int profit = 0;
    for(int i = start; i < end; i++) {
        for(int j = i+1; j <= end; j++) {
            if(price[j] > price[i]) {
                int curr_profit = price[j] - price[i] 
                    + maxp(price, start, i-1);
                    + maxp(price, j+1, end);
                profit = max(curr_profit, profit);
            }
        }
    }
    return profit;
}

int trapping_rainwater(int *arr, int len) {
    int i = 0, j = len-1, lmax  = 0, rmax = 0, result = 0;
    while(i <= j) {
        if(arr[i] < arr[j]) {
            if(arr[i] > lmax) {
                lmax = arr[i];
            }
            else {
                result += lmax - arr[i];
            }
            i++;
        }
        else {
            if(arr[j] > rmax) {
                rmax = arr[j];
            }
            else {
                result += rmax - arr[j];
            }
            j--;
        }
    }
    return result;
}

int max_sum_subarray(vector<int> arr) {
    int result = arr[0], current;
    for(int i = 1; i < arr.size(); i++) {
        current = max(arr[i], current + arr[i]);
        result = max(current, result);
    }
    return result;
}

int max_even_odd_subarray(vector<int> arr) {
    int result = 1, current = 1;
    for(int i = 1; i < arr.size(); i++) {
        if((arr[i] & 1) == (arr[i-1] & 1)) { // both are odd or both are even
            result = max(result, current);
            current = 1;
        } 
        else { 
            current += 1;
        }
    }
    return max(result, current);
}

int majority_element(vector<int> arr) {
    int counter = 1, result = 0;
    for(int i = 1; i < arr.size(); i++) {
        if(arr[i] != arr[result]) {
            counter--;
        } 
        else{
            counter++;
        }
        if(counter == 0) {
            result = i;
            counter = 1;
        }
    }
    counter = count(arr.begin(), arr.end(), arr[result]);
    if(counter > (arr.size()/2)) {
        return arr[result];
    }
    else {
        return -1;
    }
}

int max_sum_k_consecutive(vector<int> arr, int k) {
    int max_sum, cur_sum = 0; 
    for(int i = 0; i < k; i++) {
        cur_sum += arr[i]; 
    }
    max_sum = cur_sum;
    for(int i = k; i < arr.size(); i++) {
        cur_sum += arr[i] - arr[i-k];
        max_sum = max(max_sum, cur_sum);
    }
    return max_sum;
}

bool given_sum_subarray(vector<int> arr, int sum) {
    int cur_sum = arr[0], start = 0;
    for(int end = 1; end < arr.size(); end++) {
        while(cur_sum > sum && start < end-1) {
            cur_sum -= arr[start];
            start++;
        }
        if(cur_sum == sum) {
            return true;
        }
        if(end < arr.size()) {
            cur_sum += arr[end];
        }
    }
    return (cur_sum == sum);
}

bool equilibrium_point(vector<int> arr) {
    int left_sum = 0;
    int arr_sum = accumulate(arr.begin(), arr.end(), 0);
    for(int i = 0; i < arr.size(); i++) {
        if(left_sum == (arr_sum - arr[i])) {
            return true;
        }
        left_sum += arr[i];
        arr_sum -= arr[i];
    }
    return false;
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    vector<int> v = {1,1,7,5,3};
    cout << equilibrium_point(v);
}