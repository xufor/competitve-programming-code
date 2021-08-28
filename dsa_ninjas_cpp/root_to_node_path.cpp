#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

vector<int>* root_to_node(Node *root, int key) {
    if(root == nullptr) {
        return nullptr;
    } 
    else if(root -> data == key) {
        vector<int> *fresh_vector = new vector<int>;
        fresh_vector -> push_back(key);
        return fresh_vector;
    }
    vector<int> *left_path = root_to_node(root -> left, key);
    if(left_path != nullptr) {
        left_path -> push_back(root -> data);
        return left_path;
    }
    vector<int> *right_path = root_to_node(root -> right, key);
    if(right_path != nullptr) {
        right_path -> push_back(root -> data);
        return right_path;
    }
    return nullptr;
}


int main() {
    int key;
    cin >> key;
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3, new Node(-1), nullptr)), 
        new Node(6, new Node(5), new Node(7, nullptr, new Node(8))));
    vector<int> *result = root_to_node(root, key);
    if(result) {
        for(int x: *result) {
            cout << x << sp;
        }
    }
    else {
        cout << "Not Found!";
    }
}