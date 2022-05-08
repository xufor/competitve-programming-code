def dfs(adjacency_list, current_vertex, visited, result_stack):
    visited[current_vertex] = True

    for neighbour_vertex in adjacency_list[current_vertex]:
        if not visited[neighbour_vertex]:
            dfs(adjacency_list, neighbour_vertex, visited, result_stack)
    
    result_stack.append(current_vertex)
    
# this algo works on directed acyclic graphs i.e DAGs
def topo_sort(adjacency_list, no_of_vertices):
    visited = [False] * no_of_vertices
    result_stack = []

    for i in range(no_of_vertices):
        if not visited[i]:
            dfs(adjacency_list, i, visited, result_stack)

    result_stack.reverse()
    
    return result_stack


adjacency_list = []
no_of_vertices = int(input())
for i in range(no_of_vertices):
    adjacency_list.append([int(v) for v in input().split()])

result = topo_sort(adjacency_list, no_of_vertices)
print(result)

"""
6


3
1
0 1
0 2
"""