#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

void print(Node *root, int low, int high) {
    if(root == nullptr) {
        return;
    }
    if(root -> data >= low && root -> data <= high) {
        cout << root -> data << sp;
        print(root -> left, low, high);
        print(root -> right, low, high);
    }
    else if (root -> data < low) {
        print(root -> right, low, high);
    }
    else if (root -> data > high){
        print(root -> left, low, high);
    }
}

int main() {
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3)), 
        new Node(6, new Node(5), new Node(7)));
    print(root, 2, 5);
}