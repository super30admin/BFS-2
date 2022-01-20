# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach




'''DFS Left First'''

# If element already exists at index marked by level, simply over write.
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def recur(root, depth):
            nonlocal result
            
            if not root:
                return
            
            if depth == len(result):
                result.append(root.val)
            else:
                result[depth] = root.val            
            
            recur(root.left, depth + 1)
            recur(root.right, depth + 1)
            
        
        
        
        result = []
        recur(root, 0)
        return result

# Time Complexity : O(N)
# Space Complexity : O(H)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
        
'''DFS Right First'''
# Only add element to the list when the level is being reached for the first time.
class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        def recur(root, depth):
            nonlocal result
            
            if not root:
                return
            
            if depth == len(result):
                result.append(root.val)           
            
            recur(root.right, depth + 1)
            recur(root.left, depth + 1)

        result = []
        recur(root, 0)
        return result


'''BFS'''
# Time Complexity : O(N)
# Space Complexity : O(W) [Maximum Width of a Tree] [Worst Case Full Binary Tree W = 2 ^ (H - 1)]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

# ITERATIVE SOLUTION, ALWAYS HANDLE ROOT IS NONE

class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        if not root:
            return root

        q = deque([ ])
        q.append(root)
        result = []
        while q:
            size = len(q)
            for i in range(size):
                curr = q.popleft()
                
                if i == size - 1: # when we are at last element we can get answer
                    result.append(curr.val)
                
                if curr.left:
                    q.append(curr.left)
                
                if curr.right:
                    q.append(curr.right)
                
        return result