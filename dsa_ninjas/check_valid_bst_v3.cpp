#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

bool is_bst(Node *root, int minimum, int maximum) {
    if(root == nullptr) {
        return true;
    }
    if(root -> data < minimum || root -> data > maximum) {
        return false;
    }
    bool is_left_valid = is_bst(root -> left, minimum, root -> data - 1);
    bool is_right_valid = is_bst(root -> right, root -> data - 1, maximum);
    return is_right_valid && is_left_valid;
}

int main() {
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3)), 
        new Node(6, new Node(5), new Node(7)));
    cout << is_bst(root, INT_MIN, INT_MAX);
}