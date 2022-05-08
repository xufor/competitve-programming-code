def detect_cycle(adjacency_list, current_vertex, previous_vertex, visited):
    visited[current_vertex] = True

    for neighbour_vertex in adjacency_list[current_vertex]:
        if not visited[neighbour_vertex]:
            result = detect_cycle(adjacency_list, neighbour_vertex, current_vertex, visited)
            # if any of the calls detects cycle then return True
            if result == True:
                return True
        else:
            if neighbour_vertex != previous_vertex:
                return True
    return False


adjacency_list = []
no_of_vertices = int(input())
for i in range(no_of_vertices):
    adjacency_list.append([int(v) for v in input().split()])

result = detect_cycle(adjacency_list, 0, -1, [False] * no_of_vertices)
print(result)

"""
5
3
4 3
3 4
2 1
2 1

5
3
3
3 4
2 1
2
"""
