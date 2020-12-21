#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

Node* build_bst(int *arr, int low, int high) {
    if(low >= high) {
        return nullptr;
    }
    int mid = low + (high - low)/2;
    Node *root = new Node(arr[mid]);
    root -> left = build_bst(arr, low, mid);
    root -> right = build_bst(arr, mid+1, high);
    return root;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Node *root = build_bst(arr, 0, 9);
    inorder_traversal(root);
}