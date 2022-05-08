def detect_cycle(adjacency_list, current_vertex, visited, visited_on_current_path):
    visited[current_vertex] = True
    visited_on_current_path[current_vertex] = True

    for neighbour_vertex in adjacency_list[current_vertex]:
        if not visited[neighbour_vertex]:
            result = detect_cycle(adjacency_list, neighbour_vertex, visited, visited_on_current_path)
            # if any of the calls detects cycle then return True
            if result == True:
                return True
        else:
            if visited_on_current_path[neighbour_vertex] == True:
                return True

    visited_on_current_path[current_vertex] = False

    return False

def is_cyclic(adjacency_list, no_of_vertices):
    visited = [False] * no_of_vertices
    visited_on_current_path = [False] * no_of_vertices
    cycles_are_present = False
    for i in range(no_of_vertices):
        if not visited[i]:
            cycles_are_present = cycles_are_present or detect_cycle(adjacency_list, i, visited, visited_on_current_path)
    return cycles_are_present


adjacency_list = []
no_of_vertices = int(input())
for i in range(no_of_vertices):
    adjacency_list.append([int(v) for v in input().split()])

result = is_cyclic(adjacency_list, no_of_vertices)
print(result)

"""
10
1
2
3
4 6
5

5
2 8
9
7

10
1
2
3
4 6
5

5
2 8
9
6
"""
