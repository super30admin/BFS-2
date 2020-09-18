"""
690. Employee Importance

Time = O(n) where n = num of nodes
space = O(n) for queue and hashmap, where n = num of nodes 
Successfully excecuted on leetcode


Approach --
1. BFS + Queue with hashmap
2. In queue, append three data points - root,level,parent. Create hashmap to store node, level and parent
3. At each left and right child- append root,level+1 and parent as current node
4. At the end, compare level and parent of given values x and y

"""
class Cousins(object):
    def isCousins(self, root, x, y):
        nodes_level_parent = collections.defaultdict(list)
        queue = [(root,0,0)]
        while queue:
            node,level,parent = queue.pop(0)
            nodes_level_parent[node.val] = [level,parent]

            if node.left:
                queue.append((node.left,level+1,node.val))
            if node.right:
                queue.append((node.right,level+1,node.val))

        if nodes_level_parent[x][0]==nodes_level_parent[y][0] and nodes_level_parent[x][1] != nodes_level_parent[y][1]:
            return True

        return False