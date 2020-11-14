#include <bits/stdc++.h>

using namespace std;

class Node {
public:
    int data;
    Node *left_child;
    Node *right_child;
};

class Tree {
public:
    Node *root;
    Tree() {
        root = nullptr;
    }
    void create_tree();
    static void pre_order(Node *p);
    static void post_order(Node *p);
    static void in_order(Node *p);
    static void pre_order_iter(Node *p);
    static void post_order_iter(Node *p);
    static void in_order_iter(Node *p);
    static void level_order(Node *p);
    static int height(Node *p);
    static int count(Node *p);
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
            t -> right_child = t -> left_child = nullptr;
            p -> left_child = t;
            q.push(t);
        }
        cout << "Enter the right child of " << p -> data << ":";
        cin >> x;
        if(x != -1) {
            t = new Node;
            t -> data = x;
            t -> right_child = t -> left_child = nullptr;
            p -> right_child = t;
            q.push(t);
        }
    }
}

void Tree::pre_order(Node *p) {
    if(p) {
        cout << p -> data << " ";
        pre_order(p -> left_child);
        pre_order(p -> right_child);
    }
}

void Tree::pre_order_iter(Node *p) {
    stack<Node *> s;
    while(p != nullptr || !s.empty()) {
        if(p != nullptr) {
            cout << p -> data << " ";
            s.push(p);
            p = p -> left_child;
        }
        else {
            p = s.top();
            s.pop();
            p = p -> right_child;
        }
    }
}

void Tree::in_order_iter(Node *p) {
    stack<Node *> s;
    while(p != nullptr || !s.empty()) {
        if(p != nullptr) {
            s.push(p);
            p = p -> left_child;
        }
        else {
            p = s.top();
            s.pop();
            cout << p -> data << " ";
            p = p -> right_child;
        }
    }
}

void Tree::post_order_iter(Node *p) {
    stack<Node *> s;
    long long address;
    while(p != nullptr || !s.empty()) {
        if(p != nullptr) {
            s.push(p);
            p = p -> left_child;
        }
        else {
            address = (long long)s.top();
            s.pop();
            if(address > 0) {
                s.push((Node *)-address);
                p = ((Node *)address) -> right_child;
            }
            else {
                cout << ((Node *)-address) -> data << " ";
                p = nullptr;
            }
        }
    }
}

void Tree::post_order(Node *p) {
    if(p) {
        post_order(p -> left_child);
        post_order(p -> right_child);
        cout << p -> data << " ";
    }
}

void Tree::in_order(Node *p) {
    if(p) {
        in_order(p -> left_child);
        cout << p -> data << " ";
        in_order(p -> right_child);
    }
}

void Tree::level_order(Node *p) {
    queue<Node *> lq;
    cout << p -> data << " ";
    lq.push(p);
    while(!lq.empty()) {
        p = lq.front();
        lq.pop();
        if(p -> left_child) {
            cout << p -> left_child -> data << " ";
            lq.push(p -> left_child);
        }
        if(p -> right_child) {
            cout << p -> right_child -> data << " ";
            lq.push(p -> right_child);
        }
    }
}

int Tree::height(Node *p) {
    int x, y;
    if(p == nullptr)
        return 0;
    x = height(p -> left_child);
    y = height(p -> right_child);
    if(x > y)
        return x + 1;
    return y + 1; // behaves as else
}

int Tree::count(Node *p) {
    int x, y;
    if(p != nullptr) {
        x = count(p -> right_child);
        y = count(p -> left_child);
        return x + y + 1;
    }
    return 0;
}

int main() {
    Tree binary_tree;
    binary_tree.create_tree();
    binary_tree.level_order(binary_tree.root); cout << endl;
    binary_tree.in_order(binary_tree.root); cout << endl;
    binary_tree.pre_order(binary_tree.root); cout << endl;
    binary_tree.post_order(binary_tree.root); cout << endl;
    binary_tree.in_order_iter(binary_tree.root); cout << endl;
    binary_tree.pre_order_iter(binary_tree.root); cout << endl;
    binary_tree.post_order_iter(binary_tree.root); cout << endl;
    cout << binary_tree.height(binary_tree.root)<< " ";
    cout << binary_tree.count(binary_tree.root);
}