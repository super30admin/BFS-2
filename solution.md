# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 1: DFS.
        class Solution:
            def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
                def dfs(root: TreeNode, x, y, depth, parent: TreeNode):
                    if not root:
                        return False

                    if root.val==x:
                        self.x_depth=depth
                        self.x_parent=parent

                    if root.val==y:
                        self.y_depth=depth
                        self.y_parent=parent

                    dfs(root.left,x,y,depth+1,root)
                    dfs(root.right,x,y,depth+1,root)    
                self.x_depth,self.y_depth=0,0
                self.x_parent=TreeNode(0)
                self.y_parent=TreeNode(0)
                #Edge Case
                if not root:
                    return False
                dfs(root,x,y,0,None)
                return self.x_depth==self.y_depth and self.x_parent!=self.y_parent


# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 2: BFS.        
        import queue
        class Solution:
            def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
                #Edge Case
                if not root:
                    return False
                q=queue.Queue()
                q.put(root)
                while not q.empty():
                    x_found,y_found=False,False
                    for i in range(q.qsize()):
                        node=q.get()
                        if node.val==x:
                            x_found =True
                        if node.val==y:
                            y_found =True
                        if (node.right!=None and node.left!=None):
                            if (node.left.val==x and node.right.val==y):
                                return False
                            if (node.left.val==y and node.right.val==x):
                                return False
                        if (node.left!=None):
                            q.put(node.left)
                        if (node.right!=None):
                            q.put(node.right)
                    if(x_found and y_found):
                        return True
                    if(x_found or y_found):
                        return False
                return False

# Problem 2
## Time Complexity :
O(m*n)

## Space Complexity :
O(m*n)

## Did this code successfully run on Leetcode :
No.

## Any problem you faced while coding this :
Yes. I understood the working of the problem, but cannot resolve the issue.

## Your code here along with comments explaining your approach
### Solution

        import queue
        class Solution:
            def orangesRotting(self, grid: List[List[int]]) -> int:
                if not grid or len(grid)==0:
                    return 0
                m = len(grid)
                n=len(grid[0])
                q=queue.Queue()
                fresh=0
                for i in range(m):
                    for j in range(n):
                        if(grid[i][j]==1):
                            fresh+=1
                        if(grid[i][j]==2):
                            q.put([i,j])
                time=0
                dirs=[[0,1],[0,-1],[1,0],[-1,0]]
                while not q.empty():
                    for i in range(q.qsize()):
                        curr=[q.get()]
                        for dir in dirs:
                            r=dir[0]+curr[0]
                            c=dir[1]+curr[1]
                            if(r>=0 and r<m and c<n and grid[r][c]==1):
                                grid[r][c]=2
                                fresh-=1
                                q.put([r,c])
                    time+=1
                if fresh>0:
                    return -1
                if time>0:
                    return t-1
                else:
                    return 0


# Problem 3
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 1: BFS.
        import queue
        class Solution:
            def getImportance(self, employees: List['Employee'], id: int) -> int:
                #Edge Case
                if(len(employees)==0):
                    return 0
                result=0
                map=dict()
                for emp in employees:
                    map[emp.id]=emp
                q=queue.Queue()
                q.put(id)
                while not q.empty():
                    eid=q.get()
                    e=map[eid]
                    subs=e.subordinates
                    result+=e.importance
                    if(len(subs)!=0):
                        for subid in subs:
                            q.put(subid)
                return result


# Problem 3
## Time Complexity :
O(n)

## Space Complexity :
O(n)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 2: DFS.
        class Solution:
            def getImportance(self, employees: List['Employee'], id: int) -> int:
                def dfs(id):
                    e=self.map[id]
                    self.result+=e.importance
                    subs=e.subordinates
                    for i in range(len(subs)):
                        dfs(subs[i])
                #Edge Case
                if(len(employees)==0):
                    return 0
                self.result=0
                self.map=dict()
                for emp in employees:
                    self.map[emp.id]=emp
                dfs(id)
                return self.result
