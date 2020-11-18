#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define md 1000000007
typedef long long ll;
using namespace std;

class Node {
public:
    int data;
    Node *left;
    Node *right;
    Node() {
        this -> data = -1;
        this -> left = nullptr;
        this -> right = nullptr;
    }
    Node(int data) {
        this -> data = data;
        this -> left = nullptr; 
        this -> right = nullptr;
    }
    Node(int data, Node *left, Node *right) {
        this -> data = data;
        this -> left = left; 
        this -> right = right;
    }
};

void inorder(Node *node) {
    if(node) {
        inorder(node -> left);
        cout << node -> data << sp;
        inorder(node -> right);
    }
}

void preorder(Node *node) {
    if(node) {
        cout << node -> data << sp;
        preorder(node -> left);
        preorder(node -> right);
    }
}

void postorder(Node *node) {
    if(node) {
        postorder(node -> left);
        postorder(node -> right);
        cout << node -> data << sp;
    }
}

int size(Node *node) {
    if(node == nullptr) {
        return 0;
    }
    return 1 + size(node -> left) + size(node -> right);
}

int maximum(Node *node) {
    if(node == nullptr) {
        return INT_MIN;
    }
    return max(node -> data, max(maximum(node -> left), maximum(node -> right)));
}

int height(Node *node) {
    if(node == nullptr) {
        return 0;
    }
    return max(height(node -> right), height(node -> right)) + 1;
}

void iterative_inorder(Node *node) {
    stack<Node *> s;
    while(node != nullptr || !s.empty()) {
        if(node != nullptr) {
            s.push(node);
            node = node -> left;
        }
        else {
            node = s.top();
            s.pop();
            cout << node -> data << sp;
            node = node -> right;
        }
    }
}

void iterative_preorder(Node *node) {
    stack<Node *> s;
    while(node != nullptr || !s.empty()) {
        if(node != nullptr) {
            cout << node -> data << sp;
            s.push(node);
            node = node -> left;
        }
        else {
            node = s.top();
            s.pop();
            node = node -> right;
        }
    }
}

void iterative_postorder(Node *node) {
    ll address;
    stack<Node *> s;
    while(node != nullptr || !s.empty()) {
        if(node != nullptr) {
            s.push(node);
            node = node -> left;
        }
        else {
            address = (long long)s.top();
            s.pop();
            if(address > 0) {
                s.push((Node *)-address);
                node = ((Node *)address) -> right;
            }
            else {
                cout << ((Node *)-address) -> data << " ";
                node = nullptr;
            }
        }
    }
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    Node *root = new Node(1);
    root -> left = new Node(2, new Node(4), new Node(5, nullptr, 
        new Node(6, new Node(7, new Node(8), new Node(9)), nullptr)));
    root -> right = new Node(3, nullptr, new Node(10, nullptr, new Node(11)));
    inorder(root); 
    cout << nl;
    preorder(root); 
    cout << nl;
    postorder(root); 
    cout << nl;
    cout << size(root) << nl;
    cout << maximum(root) << nl;
    cout << height(root) << nl;
    iterative_inorder(root); 
    cout << nl;
    iterative_preorder(root); 
    cout << nl;
    iterative_postorder(root); 
    cout << nl;
}