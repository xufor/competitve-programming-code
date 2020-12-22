#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

Node* delete_node(Node *root, int key) {
    if(root == nullptr) {
        return nullptr;
    }
    if(key > root -> data) {
        root -> right = delete_node(root -> right, key);
        return root;
    }
    else if(key < root -> data) {
        root -> left = delete_node(root -> left, key);
        return root;
    }
    else {
        if(root -> left == nullptr && root -> right == nullptr) {
            delete root;
            return nullptr;
        }
        else if(root -> left == nullptr) {
            Node *temp = root -> right;
            delete root;
            return temp;
        }
        else if(root -> right == nullptr) {
            Node *temp = root -> left;
            delete root;
            return temp;
        }
        else {
            Node *inorder_successor = root -> right;
            while(inorder_successor -> left != nullptr) {
                inorder_successor = inorder_successor -> left;
            }
            root -> data = inorder_successor -> data;
            root -> right = delete_node(root -> right, inorder_successor -> data);
            return root;
        }
    }
}


int main() {
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3)), 
        new Node(6, new Node(5), new Node(7, nullptr, new Node(8))));
    inorder_traversal(root);
    cout << nl;
    delete_node(root, 7);
    inorder_traversal(root);
}