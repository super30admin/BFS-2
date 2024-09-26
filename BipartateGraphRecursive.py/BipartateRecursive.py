"""
uses the same as iterative approach but we use a recursion stack instead a intialized stack.
"""

def dfs(node):
            for neighbour in graph[node]:
                if neighbour not in color:
                    color[neighbour] = 1 - color[node]
                    
                    if not dfs(neighbour):
                        return False
                elif color[neighbour] == color[node]:
                    return False
            return True
                
            
            
        color = {}
        for node in range(len(graph)):
            if node not in color:
                color[node] = 0
                if not dfs(node):
                    return False
        return True