#include <bits/stdc++.h>
using namespace std;

void max_heapify(vector<int> &heap, int target, int &heap_size) {
    int left = target * 2 + 1;
    int right = left + 1;
    
    int largest = target;
    if(left < heap_size && heap[left] > heap[largest]) {
        largest = left;
    }
    if(right < heap_size && heap[right] > heap[largest]) {
        largest = right;
    }
    if(largest != target) {
        swap(heap[largest], heap[target]);
        max_heapify(heap, largest, heap_size);
    }
}

void build_max_heap(vector<int> &heap, int heap_size) {
    for(int i = heap_size/2-1; i >= 0; i--) {
        max_heapify(heap, i, heap_size);
    }
}

void heap_sort(vector<int> &heap) {
    int heap_size = heap.size();
    build_max_heap(heap, heap_size);
    for(int i = heap_size-1; i >= 1; i--) {
        swap(heap[i], heap[0]);
        heap_size--;
        max_heapify(heap, 0, heap_size);
    }
}

int main() {
    vector<int> heap = { 1,7,8,4,2,5,0,9,3,6 };
    heap_sort(heap);
    for(int x: heap) {
        cout << x << " ";
    }
}