#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

vector<vector<int>> threeSum(vector<int>& nums) {
    vector<vector<int>> answer;
    unordered_set<int> handled;
    int sum = 0, j , k, l = nums.size(), cur_sum;
    sort(nums.begin(), nums.end());
    for(int i = 0; i < l - 2; i++) {
        int arr[2] = {-9999,-9999};
        if(binary_search(nums.begin(), nums.begin()+i, nums[i])) {
            continue;
        }
        j = i + 1;
        k =  l - 1;
        while(j < k) {
            cur_sum = nums[i] + nums[j] + nums[k];
            if(cur_sum > sum)
                k--;
            else if(cur_sum < sum)
                j++;
            else {
                if(nums[j] != arr[0] || nums[k] != arr[1]) {
                    answer.push_back({nums[i], nums[j], nums[k]});
                    arr[0] = nums[j];
                    arr[1] = nums[k];
                }
                j++;
                k--;
            }
        }
    }
    return answer;
}




