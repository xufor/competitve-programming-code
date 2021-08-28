#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;

void depth_first_search(int **graph, int V, bool *visited, int start) {
    cout << start << sp;
    visited[start] = true;
    for(int i = 0; i < V; i++) {
        if(!visited[i] && graph[start][i]) {
            depth_first_search(graph, V, visited, i);
        }
    }
}

void disconnected_dfs(int **graph, int V, bool *visited) {
    for(int i = 0; i < V; i++) {
        if(!visited[i]) {
            depth_first_search(graph, V, visited, i);
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
    bool visited[V];
    // Simple Graph DFS
    memset(visited, false, V);
    depth_first_search(graph, V, visited, 0);
    cout << nl;
    // Disconnected Graph DFS
    memset(visited, false, V);
    disconnected_dfs(graph, V, visited);
}

/*
7 7
0 1
0 2
1 2
3 4
3 5
4 5
4 6
*/