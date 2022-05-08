from collections import deque

def bfs(adjacency_list, indegree):
    queue = deque()

    for i in range(len(indegree)):
        if indegree[i] == 0:
            queue.append(i)

    vertex_removed_from_queue = 0
    while len(queue) != 0:
        vertex = queue.popleft()
        vertex_removed_from_queue += 1

        for neighbour in adjacency_list[vertex]:
            indegree[neighbour] -= 1
            if indegree[neighbour] == 0:
                queue.append(neighbour)
    
    if vertex_removed_from_queue != len(adjacency_list):
        print("Cycle detected")
    else:
        print("Cycle not detected")


# this algo is also called Kahn's Algorithm
def topo_sort(adjacency_list, no_of_vertices):
    indegree = [0] * no_of_vertices

    for neighbour_list in adjacency_list:
        for neighbour in neighbour_list:
            indegree[neighbour] += 1

    bfs(adjacency_list, indegree)


adjacency_list = []
no_of_vertices = int(input())
for i in range(no_of_vertices):
    adjacency_list.append([int(v) for v in input().split()])

topo_sort(adjacency_list, no_of_vertices)

"""
6


3
1
0 1
0 2

6


3 5
1
0 1
0 2
"""
