# timecomplexity: O(n)
# leetcode : accepted
# no doubts

# a graph is said to be bipartite if the two edges of a line segmet are in two separate sets.

# carrying out a simple DFS


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)
        colour = [-1] * n  # a visited matrix

        for node in range(n):
            if colour[node] == -1:  # if the node is not visitd
                stack = []
                stack.append(node)  # append the unvisted node into stack
                colour[node] = 0  # and make the node in the colour list as zero
                while (len(stack) != 0):

                    item = stack.pop()  # pop the node

                    #                     print(item)

                    #                     print(colour)

                    for neighbour in graph[item]:  # for all its neighbours
                        print("neighbour", neighbour)
                        if colour[neighbour] == -1:  # if the neighbours are unvisited

                            stack.append(neighbour)  # add them to  stack
                            colour[neighbour] = colour[item] ^ 1  # and invert the colours. 0->1  or 1 ->0
                            print(colour)

                        elif colour[neighbour] == colour[item]:  # ifs already visited, then its not a biparitiie
                            return False  # retuning flase
        return True
