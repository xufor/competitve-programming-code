#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

Node* build_tree(int *inorder, int *preorder, int inorder_start, int inorder_end, 
int preorder_start, int preorder_end) {
    if(inorder_start > inorder_end) {
        return nullptr;
    }
    int root_index, root_data = preorder[preorder_start];
    for(int i = inorder_start; i <= inorder_end; i++) {
        if(inorder[i] == root_data) {
            root_index = i;
            break;
        }
    }
    int l_inorder_start = inorder_start;
    int l_inorder_end = root_index - 1;
    int l_preorder_start = preorder_start + 1;
    int l_preorder_end = l_preorder_start + (l_inorder_end - l_inorder_start);
    int r_inorder_start = root_index + 1;
    int r_inorder_end = inorder_end;
    int r_preorder_start = l_preorder_end + 1;
    int r_preorder_end = r_preorder_start + (r_inorder_end - r_inorder_start);
    Node *root = new Node(root_data);
    root->left = build_tree(inorder, preorder, l_inorder_start, l_inorder_end, 
    l_preorder_start, l_preorder_end);
    root->right = build_tree(inorder, preorder, r_inorder_start, r_inorder_end, 
    r_preorder_start, r_preorder_end); 
    return root;
}

int main() {
    int inorder[] = {8, 4, 2, 5, 1, 9, 6, 10, 3, 7};
    int preorder[] = {1, 2, 4, 8, 5, 3, 6, 9, 10, 7};
    Node *root = build_tree(inorder, preorder, 0, 9, 0, 9);
    inorder_traversal(root);
}