#include <bits/stdc++.h>
#include "linked_list_template.h"
#define nl '\n'
#define sp " "
using namespace std;

Node* recursive_reverse(Node *current, Node *previous = nullptr) {
    if(current == nullptr) {
        return previous;
    }
    Node *save = recursive_reverse(current -> next, current);
    current -> next = previous;
    return save;
}

Node* recursive_reverse_improved(Node *current) {
    // the first check is for detecting empty linked list
    // the second check is essential
    if(current == nullptr || current -> next == nullptr) {
        return current;
    }
    Node *save = recursive_reverse_improved(current -> next);
    current -> next -> next = current;
    // since we cannot know when we are dealing with
    // first node so we set nullptr for all
    current -> next = nullptr; 
    return save;
}

Node* iterative_reverse(Node *head) {
    Node *a = nullptr, *b = nullptr, *c = head;
    // as soon as c becomes nullptr all of the linked list is reversed
    // b will be pointing at the last node when c becomes nullptr
    // the pattern will be "Shift Then Reverse"
    while(c != nullptr) { 
        //----shifting the window----//
        a = b;
        b = c;
        c = c -> next;
        //----making the current node point to previous----//
        b -> next = a;
    }
    return b;
}

int main() {
    Node *head = new Node(4, new Node(1, new Node(-3, new Node(2, new Node(0)))));
    print_linked_list(iterative_reverse(head));
}