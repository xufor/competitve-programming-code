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


int find_closest_value_in_bst(int num) {
    int closest = INT_MAX;
    Node *temp = root;
    // Remember that the subtree which has more probability of having value num will also
    // have more probability of having value closest to num, thus we kind of follow the
    // procedure as if we were searching for num. Now even if we are kind of searching num we
    // will check all the numbers in our way that are closest to num.
    while(temp != nullptr) {
        if(num == temp -> data)
            return temp -> data;
        if(num < temp -> data) {
            if(abs(num - closest) > abs(num - temp -> data))
                closest = temp -> data;
            temp = temp -> left_child;
        }
        else {
            if(abs(num - closest) > abs(num - temp -> data))
                closest = temp -> data;
            temp = temp -> right_child;
        }
    }
    return closest;
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
    cout << find_closest_value_in_bst(58) << '\n';
}

