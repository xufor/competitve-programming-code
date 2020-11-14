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


void invert_bst_iterative() {
    queue<Node *> q;
    q.push(root);
    while(!q.empty()) {
        Node *cur = q.front(), *temp;
        q.pop();
        if(cur -> left_child)
            q.push(cur -> left_child);
        if(cur -> right_child)
            q.push(cur -> right_child);
        if(!(cur -> left_child && cur -> right_child)) {
            temp = cur -> left_child;
            cur -> left_child = cur -> right_child;
            cur -> right_child = temp;
        }
    }
}

void invert_bst_recursive(Node *p = root) {
    if(!p)
        return;
    Node * temp;
    temp = p -> left_child;
    p -> left_child = p -> right_child;
    p -> right_child = temp;
    invert_bst_recursive(p -> left_child);
    invert_bst_recursive(p -> right_child);
}

int main() {
    root = new Node;
    root -> data = 1;
    insert(2);
    insert(3);
    insert(4);
    insert(5);
    insert(6);
    insert(7);
    insert(8);
    insert(9);
    invert_bst_iterative();
    invert_bst_recursive();
}









