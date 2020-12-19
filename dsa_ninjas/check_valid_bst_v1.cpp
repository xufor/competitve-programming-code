#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

int maximum(Node *root) {
    if(root == nullptr) {
        return INT_MIN;
    }
    int left_max = maximum(root -> left);
    int right_max = maximum(root -> right);
    return max(root -> data, max(left_max, right_max));
}

int minimum(Node *root) {
    if(root == nullptr) {
        return INT_MAX;
    }
    int left_min = minimum(root -> left);
    int right_min = minimum(root -> right);
    return min(root -> data, min(left_min, right_min));
}

bool is_bst(Node *root) {
    if(root == nullptr) {
        return true;
    }
    int left_max = maximum(root -> left);
    int right_min = minimum(root -> right);
    bool output = (root -> data > left_max) && (root -> data < right_min) && 
        is_bst(root -> left) && is_bst(root -> right);
    return output;
}

int main() {
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3)), 
        new Node(6, new Node(5), new Node(7)));
    cout << is_bst(root);
}