#include <bits/stdc++.h>
#define sp " "
#define nl '\n'
using namespace std;

class Node {
public:
    int data;
    Node *left_child;
    Node *right_child;

    Node() {
        data = 0;
        left_child = nullptr;
        right_child = nullptr;
    }
} *root = nullptr;

Node * search(int key) {
    // this function returns nullptr if node is found
    // otherwise it returns node where insertion should take place
    Node *temp = root, *save = nullptr;
    while(temp != nullptr) {
        save = temp;
        if(key < temp -> data)
            temp = temp -> left_child;
        else if(key > temp -> data)
            temp = temp -> right_child;
        else
            return nullptr;
    }
    return save;
}

void insert(int key) {
    Node *target = search(key);
    if (!target)
        cout << "Element " << key << " already present.\n";
    else {
        Node *fresh_node = new Node;
        fresh_node->data = key;
        if (key < target->data)
            target->left_child = fresh_node;
        else
            target->right_child = fresh_node;
    }
}


void validate_bst(Node *p, int min, int max) {
    if(p -> data > min && p -> data < max) {
        if(p -> left_child)
            validate_bst(p -> left_child, min, p -> data);
        if(p -> right_child)
            validate_bst(p -> right_child, p -> data, max);
    }
    else {
        cout << "Node" << sp << p -> data<< sp << "is at invalid position." << nl;
    }
}

int main() {
    root = new Node;
    root -> data = 50;
    insert(30);
    insert(20);
    insert(35);
    insert(55);
    insert(60);
    insert(53);
    root -> left_child -> right_child -> data = 90;
    root -> right_child -> data = 12;
    validate_bst(root, -INT_MAX, INT_MAX);
}








