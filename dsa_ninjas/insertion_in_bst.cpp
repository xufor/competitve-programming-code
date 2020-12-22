#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

Node* insert_node(Node *root, int key) {
    if(root == nullptr) {
        return new Node(key);
    } 
    if(root -> data == key) {
        cout << "Key already present!" << nl;
    }
    else if(key < root -> data) {
        root -> left = insert_node(root -> left, key);
    }
    else {
        root -> right = insert_node(root -> right, key);
    }
    return root;
}


int main() {
    Node *root = nullptr;
    vector<int> v = {23, 24, 19, 5, 1, 7, 6, 21};
    for(int x: v) {
        root = insert_node(root, x);
    }
    inorder_traversal(root);
}