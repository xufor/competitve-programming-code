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

Node* mid_point(Node *head) {
    if(!head) {
        return nullptr;
    }
    Node *fast = head, *slow = head;
    while(fast -> next != nullptr && fast -> next -> next != nullptr) {
        fast = fast -> next -> next;
        slow = slow -> next;
    }
    return slow;
}

int main() {
    Node *head = new Node(50, new Node(70, new Node(90, new Node(110))));
    cout << mid_point(head) -> data;
}