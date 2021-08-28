#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

class Queue {
private:
    int *arr, front, rear, max_size;
public:
    Queue(int size) {
        arr = new int[size];
        front = -1;
        rear = -1;
        max_size = size;
    }

    void enqueue(int value) {
        if((rear+1) % max_size == front) {
            cout << "Overflow!" << nl;
        }
        else if (front == -1 && rear == -1) {
            front = rear = 0;
            arr[front] = value;
        }
        else {
            rear = (rear + 1) % max_size;
            arr[rear] = value;
        }
    }

    void dequeue() {
        if (front == -1 && rear == -1) {
            cout << "Underflow!" << nl;
        }
        else if(front == rear) {
            cout << arr[front] << sp << "deleted!" << nl;
            front = rear = -1;
        }
        else {
            cout << arr[front] << sp << "deleted!" << nl;
            front = (front + 1) % max_size;
        }
    }

    void print() {
        if(front == -1 and rear == -1) {
            return;
        }
        else if(front == rear) {
            cout << arr[front] << nl;
            return;
        }
        else {
            int f = front, r = rear;
            if(front > rear) {
                for(int i = front; i < max_size; i++) {
                    cout << arr[i] << sp;
                }
                for(int i = 0; i <= rear; i++) {
                    cout << arr[i] << sp;
                }
            }
            else {
                for(int i = front; i <= rear; i++) {
                    cout << arr[i] << sp;
                }
            }
            cout << nl;
        }
    }
};

int main() {
    Queue *q = new Queue(5);
    for(int i = 1; i <= 5; i++) {
        q -> enqueue(i*i);
    }
    q -> print();
    q -> enqueue(0);
    for(int i = 1; i <= 3; i++) {
        q -> dequeue();
    }
    q -> print();
    for(int i = 1; i <= 3; i++) {
        q -> enqueue(-i*i);
    }
    q -> print();
    q -> enqueue(0);
    for(int i = 1; i <= 6; i++) {
        q -> dequeue();
    }
}