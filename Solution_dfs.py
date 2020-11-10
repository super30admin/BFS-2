"""

Time complexity O(N)
Space complexity O(N)
 # DFS non recursive
"""


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution_dfs:
    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        if root is None:
            return False
        dic={}
        st=[]
        st.append((root,0,0))
        while st:
            node,parentVal,level=st.pop()
            if node:
                dic[node.val]=[parentVal,level]
                st.append((node.left,node.val,level+1))
                st.append((node.right,node.val,level+1))
        return dic[x][1]==dic[y][1] and  dic[x][0]!=dic[y][0]
        