#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

class priority_q {
private:
    vector<int> pq;
public:
    void print() {
        for(int x: pq) {
            cout << x << sp;
        }
        cout << nl;
    }

    void insert(int key) {
        pq.push_back(key);
        // up-heapify
        int child_index = pq.size() - 1;
        while(child_index > 0) {
            int parent_index = (child_index - 1) / 2;
            if(pq[child_index] < pq[parent_index]) {
                swap(pq[child_index], pq[parent_index]);
            }
            else {
                break;
            }
            child_index = parent_index;
        }   
    }

    int remove() {
        if(pq.size() == 0) {
            return INT_MIN;
        }
        int removed_key = pq[0];
        pq[0] = *(pq.rbegin());
        pq.pop_back();
        // down-heapify
        int parent_index = 0;
        while(true) {
            int left_child_index = (parent_index * 2) + 1;
            int right_child_index = (parent_index * 2) + 2;
            int min_index = parent_index;
            // LEAF NODE CASE
            // if we reach a leaf node, no if block executes
            // both left and right child indices will become invalid
            // no change will occur to min_index and loop will break
            // SINGLE CHILD CASE
            // if one child is only there, only one if block executes
            // if min_index is updated then case becomes leaf node case
            // if no change occurs to min_index, loop will break
            // BOTH CHILD CASE
            // if both children are present, both if blocks execute
            // if min_index is updated then can become any of all three cases
            // if no change occurs to min_index, loop will break
            if(left_child_index < pq.size() && pq[left_child_index] < pq[min_index]) {
                min_index = left_child_index;
            }
            if(right_child_index < pq.size() && pq[right_child_index] < pq[min_index]) {
                min_index = right_child_index;
            }
            if(min_index == parent_index) {
                break;
            }
            swap(pq[min_index], pq[parent_index]);
            parent_index = min_index;
        }
        return removed_key;
    }
};

int main() {
    vector<int> v = {100, 10, 15, 4, 17, 21, 67};
    priority_q p;
    for(int x: v) {
        p.insert(x);
    }
    p.print();
    while(true) {
        int result = p.remove();
        if(result == INT_MIN) {
            break;
        }
        cout << result << sp;
    }
}