#include <iostream>

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
    if(!target)
        cout << "Element " << key << " already present.\n";
    else {
        Node *fresh_node = new Node;
        fresh_node -> data = key;
        if(key < target -> data)
            target -> left_child = fresh_node;
        else
            target -> right_child = fresh_node;
    }
}

Node * recursive_insert(Node *p, int key) {
    if(p == nullptr) {
        Node * fresh_node = new Node;
        fresh_node -> data = key;
        return fresh_node;
    }
    else if(key < p -> data)
        p -> left_child = recursive_insert(p -> left_child, key);
    else if(key > p -> data)
        p -> right_child = recursive_insert(p -> right_child, key);
    return p;
}

int height(Node *p) {
    int x, y;
    if(p == nullptr)
        return 0;
    x = height(p -> left_child);
    y = height(p -> right_child);
    if(x > y)
        return x + 1;
    return y + 1; // behaves as else
}

Node * inorder_predecessor(Node * p) {
    while(p && p -> right_child) {
        p = p -> right_child;
    }
    return p;
}

Node * inorder_successor(Node * p) {
    while(p && p -> left_child) {
        p = p -> left_child;
    }
    return p;
}

Node * recursive_delete(Node *p, int key) {
    if(p == nullptr)
        return nullptr;
    else if(p -> left_child == nullptr && p -> right_child == nullptr) {
        if(p == root)
            root = nullptr;
        free(p);
        return nullptr;
    }
    else if(key < p -> data)
        p -> left_child = recursive_delete(p -> left_child, key);
    else if(key > p -> data)
        p -> right_child = recursive_delete(p -> right_child, key);
    else {
        if(height(p -> left_child) > height(p -> right_child)) {
            Node *result = inorder_predecessor(p -> left_child);
            p -> data = result -> data;
            p -> left_child = recursive_delete(p -> left_child, result -> data);
        }
        else {
            Node *result = inorder_successor(p -> right_child);
            p -> data = result -> data;
            p -> right_child = recursive_delete(p -> right_child, result -> data);
        }
    }
    return p;
}

void in_order(Node *p) {
    if(p != nullptr) {
        in_order(p -> left_child);
        cout << p -> data << " ";
        in_order(p -> right_child);
    }
}

int main() {
    root = new Node;
    root -> data = 50;
    insert(50);
    insert(30);
    insert(20);
    insert(40);
    insert(60);
    insert(20);
    insert(55);
    insert(80);
    in_order(root);
    if(!search(80))
        cout << "\nElement "<< 80 << " is present.";
    else
        cout << "\nElement "<< 80 << " is not present.";
    if(!search(90))
        cout << "\nElement "<< 90 << " is present.";
    else
        cout << "\nElement "<< 90 << " is not present.";
    recursive_insert(root, 48);
    recursive_insert(root, 90);
    recursive_insert(root, 43);
    recursive_insert(root, 12);
    cout << '\n';
    in_order(root);
    recursive_delete(root, 50);
    cout << '\n';
    in_order(root);
}
