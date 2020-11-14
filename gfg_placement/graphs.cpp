#include <bits/stdc++.h>
#define nl '\n'
#define sp " "
#define md 1000000007
typedef long long ll;
using namespace std;

void add_edge_adj_matrix(int g[][4], int u, int v, bool dir = false) {
    g[u][v] = 1; // undirected graph using adjacency matrix
    if(!dir) {
        g[v][u] = 1;
    }
}

void print_adj_matrix(int g[][4], int V) {
    for(int i = 0; i < V; i++) {
        cout << i << sp << "=>" << sp;
        for(int j = 0; j < V; j++) {
            if(g[i][j]) {
                cout << j << sp;
            }
        }
        cout << nl;
    }
}

void add_edge_adj_list(vector<int> g[], int u, int v, bool dir = false) {
    g[u].push_back(v); // undirected graph using adjacency list
    if(!dir) {
        g[v].push_back(u);
    }
}

void print_adj_list(vector<int> g[], int V) {
    for(int i = 0; i < V; i++) {
        cout << i << sp << "=>" << sp;
        for(int x: g[i]) {
            cout << x << sp;
        }
        cout << nl;
    }
}

void bfs(vector<int> g[], int V) {
    vector<bool> visited(V);
    queue<int> q;
    q.push(0);
    visited[0] = true;
    while(!q.empty()) {
        int t = q.front();
        cout << t << sp;
        q.pop();
        for(int x: g[t]) {
            if(!visited[x]) {
                visited[x] = true;
                q.push(x);
            }
        }
    }
}

void bfs_modified(vector<int> g[], int V, int s, vector<bool> &visited) {
    queue<int> q;
    q.push(s);
    visited[s] = true;
    while(!q.empty()) {
        int t = q.front();
        q.pop();
        for(int x: g[t]) {
            if(!visited[x]) {
                visited[x] = true;
                q.push(x);
            }
        }
    }
}

int bfs_disconnected(vector<int> g[], int V) {
    int connected_components = 0;
    vector<bool> visited(V, false);
    for(int i = 0; i < V; i++) {
        if(!visited[i]) {
            connected_components += 1;
            bfs_modified(g, V, i, visited);
        }
    }
    return connected_components;
}

void dfs_recursive(vector<int> g[], int s, vector<bool> &visited) {
    visited[s] = true;
    cout << s << sp;
    for(int x: g[s]) {
        if(!visited[x]) {
            dfs_recursive(g, x, visited);
        }
    }
}

void dfs(vector<int> g[], int V, int s) {
    vector<bool> visited(V);
    dfs_recursive(g, s, visited);
}

void dfs_iterative(vector<int> g[], int V, int s) {
    vector<bool> visited(V);
    stack<int> st;
    st.push(s);
    visited[s] = true;
    while(!st.empty()) {
        int t = st.top();
        cout << t << sp;
        st.pop();
        for(int x: g[t]) {
            if(!visited[x]) {
                visited[x] = true;
                st.push(x);
            }
        }
    }
}

bool dfs_cycle_detector(vector<int> g[], int s, vector<bool> &visited, int parent) {
    // parent is last node you visited before coming to the current node
    visited[s] = true;
    for(int x: g[s]) {
        if(!visited[x]) {
            if(dfs_cycle_detector(g, x, visited, s)) {
                return true;
            }
        }
        else if(x != parent) {
            return true;
        }
    }
    return false;
}

bool undirected_cycle(vector<int> g[], int V, int s) {
    vector<bool> visited(V);
    return dfs_cycle_detector(g, s, visited, -1);
}

bool dfs_cycle_detector(vector<int> g[], int s, vector<bool> &visited, vector<bool> &rec_stack) {
    visited[s] = true;
    rec_stack[s] = true;
    for(int x: g[s]) {
        if(!visited[x]) {
            if(dfs_cycle_detector(g, x, visited, rec_stack)) {
                return true;
            }
        }
        else if(rec_stack[x]) {
            return true;
        }
    }
    rec_stack[s] = false;
    return false;
}

bool directed_cycle(vector<int> g[], int V) {
    vector<bool> visited(V);
    vector<bool> rec_stack(V);
    for(int i = 0; i < V; i++) {
        if(!visited[i]) {
            if(dfs_cycle_detector(g, i, visited, rec_stack)) {
                return true;
            }
        }
    }
    return false;
}

void topological_sort_bfs(vector<int> g[], int V) {
    vector<int> indegree(V);
    for(int i = 0; i < V; i++) {
        for(int x: g[i]) {
            indegree[x]++;
        }
    }
    queue<int> q;
    for(int i = 0; i < V; i++) {
        if(indegree[i] == 0) {
            q.push(i);
        }
    }
    while(!q.empty()) {
        int u = q.front();
        q.pop();
        cout << u << sp;
        for(int v: g[u]) {
            indegree[v]--;
            if(indegree[v] == 0) {
                q.push(v);
            }
        }
    }
}

void dfs_topo(vector<int> g[], int s, vector<bool> &visited, stack<int> &st) {
    visited[s] = true;
    for(int x: g[s]) {
        if(!visited[x]) {
            dfs_topo(g, x, visited, st);
        }
    }
    st.push(s);
}

void topological_sort_dfs(vector<int> g[], int V, int s = 0) {
    stack<int> st;
    vector<bool> visited(V);
    for(int i = 0; i < V; i++) {
        if(!visited[i]) {
            dfs_topo(g, i, visited, st);
        }
    }
    while(!st.empty()) {
        cout << st.top() << sp;
        st.pop();
    }
}

bool kahn_cycle_detector(vector<int> g[], int V) {
    vector<int> indegree(V);
    for(int i = 0; i < V; i++) {
        for(int x: g[i]) {
            indegree[x]++;
        }
    }
    queue<int> q;
    for(int i = 0; i < V; i++) {
        if(indegree[i] == 0) {
            q.push(i);
        }
    }
    int count = 0;
    while(!q.empty()) {
        int u = q.front();
        q.pop();
        for(int v: g[u]) {
            indegree[v]--;
            if(indegree[v] == 0) {
                q.push(v);
            }
        }
        count++;
    }
    return (count != V);
}

int main() {
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    int V, E, u, v;
    cin >> V >> E;
    vector<int> g[V]; 
    for(int i = 0; i < E; i++) {
        cin >> u >> v;
        add_edge_adj_list(g, u, v, true);
    }
    cout << kahn_cycle_detector(g, V);
    return 0;
}