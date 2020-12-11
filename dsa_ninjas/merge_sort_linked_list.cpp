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

Node* merge(Node *head1, Node *head2) {
    if(!head1) {
        return head2;
    }
    if(!head2) {
        return head1;
    } 
    Node *final_head, *final_tail, *save;
    final_head = final_tail = (head1 -> data <= head2 -> data) ? head1 : head2;
    while(head1 != nullptr && head2 != nullptr) {
        // we do not need to put check heads as nullptr 
        // in this if statement because the above while is enough
        if(head1 -> data <= head2 -> data) {
            save = head1;
            // the condition head1 != nullptr handles the conditon
            // when any list exhausts while we are traversing it
            while(head1 != nullptr && (head1 -> data <= head2 -> data)) {
                save = head1;
                head1 = head1 -> next;
            }
            save -> next = final_tail = head2;
        }
        else {
            save = head2;
            while(head2 != nullptr && (head2 -> data < head1 -> data)) {
                save = head2;
                head2 = head2 -> next;
            }
            save -> next = final_tail = head1;
        }
    }
    return final_head;
}

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

Node* merge_sort(Node *head) {
    // the head == nullptr condition handles the condition
    // when list has no elements
    // the other condition is important for merge sort logic
    if(head == nullptr || head -> next == nullptr) {
        return head;
    }
    //-----splitting process-----//
    Node *mid = mid_point(head);
    Node *other_head =  mid -> next;
    mid -> next = nullptr;
    //-----splitting process-----//
    head = merge_sort(head);
    other_head = merge_sort(other_head);
    return merge(head, other_head);
}

int main() {
    Node *head = new Node(4, new Node(1, new Node(-3, new Node(2, new Node(0)))));
    print_linked_list(merge_sort(head));
}