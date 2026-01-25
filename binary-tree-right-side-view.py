#-------------SOlution 1 :  BFS-------------
''' Time Complexity : O(n) 
    Space Complexity : O(n) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : 1. Traverse the tree level wise, 
              2. append the last element of each level to the list
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        q = deque()
        result = []
        q.append(root)
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                #if last element in the level
                if i == size-1:
                    result.append(curr.val)
                if curr.left:
                    q.append(curr.left)
                if curr.right:
                    q.append(curr.right)
        return result


#-------------SOlution 2 :  DFS-------------
''' Time Complexity : O(n) 
    Space Complexity : O(h) 
    Did this code successfully run on Leetcode : Yes
    Any problem you faced while coding this :  No

   Approach : 1. Maintain result list, traverse the tree in preorder,
              2. store the node at respective index in result
'''
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if root is None:
            return []
        result = []
        def helper(root, level):
            if root is None:
                return
            if level == len(result):
                result.append(root.val)
            else:
                result[level] = root.val
            helper(root.left,level+1)
            helper(root.right,level+1)
        
        helper(root, 0)
        return result