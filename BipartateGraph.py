"""
The approach here is to maintain a hashmap which stores colors of the nodes and also a stack. now we
iterate over the array and set the color as 0 and also push the node value to the stack. now we pop 
the stack and check for the neighbours of the node in the graph, if the neighbours are not in the hashmap
then we color the neighbours to 1 - color[node] and again append the neighbours to the stack and redo 
the process. else we check if color node == color of neighbour if so we return false else true.

Leetcode running
Time complexity - O(N^N)
Space complexity - O(N)

"""
    def isBipartite(self, graph):
        color = {}
        for node in range(len(graph)):
            if node not in color:
                stack = [node]
                color[node] = 0
                while stack:
                    node = stack.pop()
                    for neighbour in graph[node]:
                        if neighbour not in color:
                            color[neighbour] = 1 - color[node]
                            stack.append(neighbour)
                        elif color[node] == color[neighbour]:
                            return False
        return True