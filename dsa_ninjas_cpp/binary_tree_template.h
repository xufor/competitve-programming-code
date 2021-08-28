#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

class Node {
public:
    int data;
    Node *left;
    Node *right;
    Node() {
        left = right = nullptr;
    }
    Node(int data) : Node() {
        this -> data = data;
    }
    Node(int data, Node *left, Node *right) : Node(data) {
        this -> left = left;
        this -> right = right;
    }
};

void inorder_traversal(Node *root) {
    if(root) {
        inorder_traversal(root -> left);
        cout << root -> data << sp;
        inorder_traversal(root -> right);
    }
}

void preorder_traversal(Node *root) {
    if(root) {
        cout << root -> data << sp;
        preorder_traversal(root -> left);
        preorder_traversal(root -> right);
    }
}

void postorder_traversal(Node *root) {
    if(root) {
        postorder_traversal(root -> left);
        postorder_traversal(root -> right);
        cout << root -> data << sp;
    }
}