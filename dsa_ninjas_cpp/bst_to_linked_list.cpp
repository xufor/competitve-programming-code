#include <bits/stdc++.h>
#include "binary_tree_template.h"
#define nl '\n'
#define sp " "
using namespace std;

class LLNode {
public:
    int data;
    LLNode *next;
    LLNode() {
        next = nullptr;
    }
    LLNode(int data) : LLNode() {
        this -> data = data;
    }
    LLNode(int data, LLNode *next) : LLNode(data) {
        this -> next = next;
    }
};

class HeadTailPair {
public:
    LLNode *head, *tail;
    HeadTailPair() {
        head = tail = nullptr;
    }
    HeadTailPair(LLNode *head, LLNode *tail) {
        this -> head = head;
        this -> tail = tail;
    }
    bool isEmptyPair() {
        return (head == nullptr && tail == nullptr);
    }
};

HeadTailPair bst_to_LL(Node* root) {
    if(root == nullptr) {
        return HeadTailPair();
    }
    HeadTailPair left_pair = bst_to_LL(root -> left);
    HeadTailPair right_pair = bst_to_LL(root -> right);
    if(left_pair.isEmptyPair() && right_pair.isEmptyPair()) {
        LLNode *fresh_node = new LLNode(root -> data);
        return HeadTailPair(fresh_node, fresh_node);
    }
    else if(left_pair.isEmptyPair()) {
        LLNode *fresh_node = new LLNode(root -> data);
        fresh_node -> next = right_pair.head;
        return HeadTailPair(fresh_node, right_pair.tail);
    }
    else if(right_pair.isEmptyPair()) {
        LLNode *fresh_node = new LLNode(root -> data);
        left_pair.tail -> next = fresh_node;
        return HeadTailPair(left_pair.head , fresh_node);
    }
    else {
        LLNode *fresh_node = new LLNode(root -> data);
        left_pair.tail -> next = fresh_node;
        fresh_node -> next = right_pair.head;
        return HeadTailPair(left_pair.head , right_pair.tail);
    }
}

int main() {
    Node *root = new Node(4, new Node(2, new Node(1), new Node(3, new Node(-1), nullptr)), 
        new Node(6, new Node(5), new Node(7, nullptr, new Node(8))));
    HeadTailPair result = bst_to_LL(root);
    LLNode *head = result.head;
    while(head != nullptr) {
        cout << head -> data << sp;
        head = head -> next;
    }
}