#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

bool search(Node *root, int key) {
    if(root == nullptr) {
        return false;
    }
    if(root -> data == key) {
        return true;
    }
    else if(root -> data > key) {
        return search(root -> left, key);
    }
    else {
        return search(root -> right, key);
    }
}

int main() {
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3)), 
        new Node(6, new Node(5), new Node(7)));
    cout << search(root, 6);
}