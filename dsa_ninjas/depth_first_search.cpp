#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

void breadth_first_search(int **graph, int V, bool *visited, int start) {
    cout << start << nl;
    visited[start] = true;
    for(int v = 0; v < V; v++) {
        if(!visited[v] && graph[start][v]) {
            breadth_first_search(graph, V, visited, v);
        }
    }
}

int main() {
    int V, E;
    cin >> V >> E;
    int **graph = new int*[V];
    for(int i = 0; i < V; i++) {
        graph[i] = new int[V];
        for(int j = 0; j < V; j++) {
            graph[i][j] = 0;
        }
    }
    int s, d;
    for(int i = 0; i < E; i++) {
        cin >> s >> d;
        graph[s][d] = 1;
        graph[d][s] = 1;
    }
    bool visited[V] = {false};
    breadth_first_search(graph, V, visited, 0);
}