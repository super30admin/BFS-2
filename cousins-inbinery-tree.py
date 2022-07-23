# Time Complexity : O(n) as visit every node 
# Space Complexity : O(D) diameter of the tree as BFS search do level order traversal
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :No


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def isCousins(self, root: Optional[TreeNode], x: int, y: int) -> bool:
        
        
        q=collections.deque()
        q.append(root)
        depth=1
        set_depth_parent={root.val:[depth,None]}
        
        while q:
            lenq=len(q)
            depth+=1
            for i in range(lenq):
                node=q.popleft()
                parent=node.val

                if node:
                    if node.left:
                        if node.left not in set_depth_parent:
                            set_depth_parent[node.left.val]=[depth,parent]
                        q.append(node.left)
                    if node.right:
                        if node.right not in set_depth_parent:
                            set_depth_parent[node.right.val]=[depth,parent]
                        q.append(node.right)
                        
        
        x_ref=set_depth_parent[x]
        y_ref=set_depth_parent[y]
        
        if x_ref[0]==y_ref[0] and x_ref[1]!=y_ref[1]:
            return True 
        # for key,val in set_depth_parent.items():
        #     print(key)
            
        return False
