# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Problem 1: Cousins in Binary Tree
#Time Complexity: O(n)
#space compelxity: O(n) for the queue
'''
We do an order level traversal while keeping the parent value with the root in the stack.
When we find x and y check parents and return accordingly. if they are not same level return False.
'''

class Solution:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        #edge case
        if not root:
            return False
        if x is None or y is None:
            return False

        #initialising the queue
        q=collections.deque()
        q.append((root,None))
        prev=1
        tx=None
        ty=None
        while q:
            n=0
            next_n=0
            found=False
            while q and n< prev:
                t=q.popleft()
                n+=1
                if t[0].val==x:
                    tx=t[1]
                if t[0].val==y:
                    ty=t[1]
                if t[0].left:
                    q.append((t[0].left,t[0].val))
                    next_n+=1
                if t[0].right:
                    q.append((t[0].right,t[0].val))
                    next_n+=1
                if ty and tx:
                    if ty==tx:
                        return False
                    return True
            if tx or ty:
                #means not on the same level
                return False
            prev=next_n
        return False



#Problem 2: Rotting Oranges
#Time Complexity: O(m*n) n rows, m columns
#Space Complexity: O(m*n) worst case for the queue

'''
Brute force: at every step, check the neighbours of every element (iterating) and mark the ones that will become rotten. Then
iterate a second time to update
'''
'''
We could do a controlled BFS by considering the matrix a graph. We add all the rotten ones in the stack
and the length. we transform all the kids (neighbours) and add the kids to the stack while keeping
track of the length. We increment at each generation the minute count. We finally iterate through
the grid to check if there's a 1 left
'''

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        #edge case:
        if not grid:
            return 0

        n=len(grid)
        m=len(grid[0])
        prev=0
        q=collections.deque()

        for r in range(n):
            for c in range(m):
                if grid[r][c]==2:
                    q.append((r,c))
                    prev+=1

        #BFS
        dirs=[[-1,0],[0,1],[1,0],[0,-1]]
        mins=0
        went_in=False
        while q:
            went_in=True
            l=0
            prev=len(q)
            mins+=1
            while q and l<prev:
                r,c=q.popleft()
                l+=1
                for d in dirs:
                    next_r,next_c=r+d[0], c+d[1]
                    if 0<=next_r<n and 0<=next_c<m and grid[next_r][next_c]==1:
                        grid[next_r][next_c]=2
                        q.append((next_r,next_c))

        for r in range(n):
            for c in range(m):
                if grid[r][c]==1:
                    return -1

        if not went_in:
            mins+=1
        return mins-1



#Problem 3: Employee importance
#Time complexity: O(n) , n number of employees
#space complexity: O(n), n number of employees

"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
'''
idea:
Given the graph with the relations, we BFS from the employee id and add the values along
the way. As long as there's a path, the employee is a subordinate
'''
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        #edge case
        if not employees:
            return 0


        #construct the graph
        graph={i.id:i for i in employees}

        #BFS
        q=collections.deque()
        has_seen=set()
        q.append(id)
        total_value=0
        while q:
            root=q.popleft()
            has_seen.add(root)
            total_value+=graph[root].importance
            for child in graph[root].subordinates:
                if child not in has_seen:
                    q.append(child)
        return total_value
