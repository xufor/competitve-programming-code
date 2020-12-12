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

Node* reverse_improved(Node *current) {
    // the first check is for detecting empty linked list
    // the second check is essential
    if(current == nullptr || current -> next == nullptr) {
        return current;
    }
    Node *save = reverse_improved(current -> next);
    current -> next -> next = current;
    // since we cannot know when we are dealing with
    // first node so we set nullptr for all
    current -> next = nullptr; 
    return save;
}

int main() {
    Node *head = new Node(4, new Node(1, new Node(-3, new Node(2, new Node(0)))));
    print_linked_list(reverse_improved(head));
}