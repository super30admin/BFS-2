#DFS Level order approach and exploring first right child then left
#Time Complexity O(N)
#Space Complexity O(h)
#It successfully runs on leetcode
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result=[]
        if not root: return []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):
            if not root: return
            if level > len(self.result)-1:
                self.result.append(root.val)
            self. dfs(root.right,level+1)
            self.dfs(root.left,level+1)
            
#DFS with left child first and then overriding right most element
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        self.result=[]
        if not root: return []
        self.dfs(root,0)
        return self.result
    def dfs(self,root,level):
            if not root: return
            if level > len(self.result)-1:
                self.result.append(root.val)
            else:
                self.result[level]=root.val
            self. dfs(root.left,level+1)
            self.dfs(root.right,level+1)


#BFS Level order Approach and then taking the last element of each level
#Time Complexity O(N)
#Space Complexity O(N)
#It successfully runs on leetcode
from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if not root: return result
        q= deque()
        q.append(root)
        while q:
            l=[]
            for i in range(len(q)):
                cur= q.popleft()
                l.append(cur.val)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            result.append(l[-1])
        return result


from collections import deque
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result=[]
        if not root: return result
        q= deque()
        q.append(root)
        size=len(q)
        while q:
            for i in range(size):
                cur= q.popleft()
                if i == size-1:
                    result.append(cur.val)
                if cur.left: q.append(cur.left)
                if cur.right: q.append(cur.right)
            size = len(q)
        return result