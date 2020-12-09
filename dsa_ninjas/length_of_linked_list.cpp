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

int length(Node *head) {
    if(head == nullptr) {
        return 0;
    }
    return 1 + length(head -> next);
}

int main() {
    Node *head = new Node(50, new Node(70, new Node(90, new Node(110))));
    cout << length(head);
}