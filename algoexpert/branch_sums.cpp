#include <bits/stdc++.h>
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
};

class Tree {
public:
    Node *root;
    Tree() {
        root = nullptr;
    }
    void branch_sums(Node *p, int sum);
    void create_tree();
};

void Tree::create_tree() {
    int x;
    Node *p, *t;
    queue<Node*> q;
    cout << "Enter root value:";
    cin >> x;
    root = new Node;
    root -> data = x;
    root -> left_child = root -> right_child = nullptr;
    q.push(root);
    while(!q.empty()) {
        p = q.front();
        q.pop();
        cout << "Enter the left child of " << p -> data << ":";
        cin >> x;
        if(x != -1) {
            t = new Node;
            t -> data = x;
            p -> left_child = t;
            q.push(t);
        }
        cout << "Enter the right child of " << p -> data << ":";
        cin >> x;
        if(x != -1) {
            t = new Node;
            t -> data = x;
            p -> right_child = t;
            q.push(t);
        }
    }
}

void Tree::branch_sums(Node *p, int sum) {
    if(p -> left_child)
        branch_sums(p -> left_child, sum + p -> data);
    if(p -> right_child)
        branch_sums(p -> right_child, sum + p -> data);
    if(!p -> left_child && !p -> right_child)
        cout << sum + p -> data << " ";
}

int main() {
    Tree binary_tree;
    binary_tree.create_tree();
    binary_tree.branch_sums(binary_tree.root, 0);
    return 0;
}