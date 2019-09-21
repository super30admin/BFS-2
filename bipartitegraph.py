# leetcode:accepted
# No doubts
# Leetcode:accepted
# time complexity: o(n)
# explaination:

# graph has edges in the respective indexes. so we don't have to create an adjacent list.

# since we need two sets, with each edge in separate stes we are marking it as 1 and 0's.


class Solution:
    def isBipartite(self, graph: List[List[int]]) -> bool:
        n = len(graph)  # number of nodes
        colour = [-1] * n  # creating an array wth intialised as -1

        for node in range(n):  # for every node
            if colour[node] == -1:  # if the node is unvisited we are pushing it in stack
                stack = []
                stack.append(node)  # push the univisted node in stack
                colour[node] = 0  # marking it as 0.. All the connections of 0 should be 1
                while (len(stack) != 0):

                    item = stack.pop()  # popping the item from stack

                    #                     print(item)

                    #                     print(colour)

                    for neighbour in graph[item]:  # traversing the connections of item
                        print("neighbour", neighbour)
                        if colour[neighbour] == -1:  # if the neighbours are unvisited

                            stack.append(neighbour)  # appending it to stack
                            colour[neighbour] = colour[
                                                    item] ^ 1  # and marking it opposited to item. The other side of the neighbout
                            print(colour)

                        elif colour[neighbour] == colour[
                            item]:  # if its visited and marked same as its other end, its not a bipartitie
                            return False
        return True

