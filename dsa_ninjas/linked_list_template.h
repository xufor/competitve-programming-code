#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

class Node {
public:
    int data;
    Node *next;
    Node() {
        next = nullptr;
    }
    Node(int data) : Node() {
        this -> data = data;
    }
    Node(int data, Node *next) : Node(data) {
        this -> next = next;
    }
};

void print_linked_list(Node *head) {
    while(head != nullptr) {
        cout << head -> data << sp;
        head = head -> next;
    }
    cout << nl;
}