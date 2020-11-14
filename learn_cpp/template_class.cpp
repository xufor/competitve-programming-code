#include <iostream>

using namespace std;

template <class T>
class Stack {
    private:
        T *stk;
        int top;
        int size;
    public:
        Stack(int sz) {
            size = sz;
            top = -1;
            stk = new T[size];
        }
    void push();
    void pop();
    void display();
};

template <class T>
void Stack<T>::push() {
    if(top==size-1) {
        cout<<"Overflow!"<<endl;
    } 
    else {
        T x;
        cout<<"Enter an element: ";
        cin>>x;
        top++;
        stk[top] = x;
    }
}

template <class T>
void Stack<T>::pop() {
    if(top==-1) {
        cout<<"Underflow!"<<endl;
    } 
    else {
        cout<<stk[top]<<" got popped!"<<endl;
        top--;
    }
}

template <class T>
void Stack<T>::display() {
    if(top==-1) {
        cout<<"Stack is empty!"<<endl;
    } 
    else {
        cout<<"Top to Bottom";
        for(int i=top; i>=0; i--)
            cout<<" -> "<<stk[i];
        cout<<endl;
    }
}

int main() {
    Stack<float> s(5);
    while(1) {
        int choice;
        cout<<"Enter a choice: ";
        cin>>choice;
        switch(choice) {
            case 1:
                s.push(); break;
            case 2:
                s.pop(); break;
            case 3:
                s.display(); break;
            case 4:
                exit(0); break;
            default:
                cout<<"Invalid choice!"<<endl;
        }
    }
}