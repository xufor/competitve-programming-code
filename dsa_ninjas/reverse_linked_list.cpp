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

Node* reverse(Node *current, Node *previous = nullptr) {
    if(current == nullptr) {
        return previous;
    }
    Node *save = reverse(current -> next, current);
    current -> next = previous;
    return save;
}

int main() {
    Node *head = new Node(4, new Node(1, new Node(-3, new Node(2, new Node(0)))));
    print_linked_list(reverse(head));
}