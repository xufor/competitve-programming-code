#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
using namespace std;
typedef vector<vector<int>> adj_list;

void breadth_first_search(adj_list &graph, int V, bool *visited, int start) {
    int current;
    queue<int> pending;
    pending.push(start);
    visited[start] = true;
    while(!pending.empty()) {
        current = pending.front();
        pending.pop();
        cout << current << sp;
        for(int x: graph[current]) {
            if(!visited[x]) {
                pending.push(x);
                // the moment a vertex enters queue, mark it visited
                // otherwise it will enter the queue multiple times 
                // using other vertices
                visited[x] = true;  
            }
        }
    }
}

void disconnected_bfs(adj_list &graph, int V, bool *visited) {
    for(int i = 0; i < V; i++) {
        if(!visited[i]) {
            breadth_first_search(graph, V, visited, i);
        }
    }
}

int main() {
    int V, E, s, d;
    cin >> V >> E;
    adj_list graph(V);
    for(int i = 0; i < E; i++) {
        cin >> s >> d;
        graph[s].push_back(d);
        graph[d].push_back(s);           
    }
    bool visited[V];
    // Simple Graph BFS
    memset(visited, false, V);
    breadth_first_search(graph, V, visited, 0);
    cout << nl;
    // Disconnected Graph BFS
    memset(visited, false, V);
    disconnected_bfs(graph, V, visited);
}

/*
8 9
0 1
0 2
1 2
1 3
1 4
3 4
5 6
6 7
7 5
*/