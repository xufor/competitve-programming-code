#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

class validation_data {
public:
    bool is_valid_bst;
    int minimum;
    int maximum;
};

validation_data is_bst(Node *root) {
    if(root == nullptr) {
        validation_data output;
        output.is_valid_bst = true; // empty tree is always bst
        output.minimum = INT_MAX;
        output.maximum = INT_MIN;
        return output;
    }
    validation_data left_output = is_bst(root -> left);
    validation_data right_output = is_bst(root -> right);
    validation_data output;
    output.minimum = min(root -> data, min(left_output.minimum, right_output.minimum));
    output.maximum = max(root -> data, max(left_output.maximum, right_output.maximum));
    output.is_valid_bst = left_output.is_valid_bst && left_output.is_valid_bst && 
        (root -> data > left_output.maximum && root -> data < right_output.minimum);
    return output;
}

int main() {
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3)),
        new Node(6, new Node(5), new Node(7)));
    cout << is_bst(root).is_valid_bst;
}