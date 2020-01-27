"""
Time: O(n)
Space: O(n)
Leet: Accepted
Problems: None
"""

class Solution(object):
    def zigzagLevelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        def levelOrder(root):
            #returns level order traversal
            if not root:
                return []

            result = []
            current_level = [root] #init current level with root

            while len(current_level) > 0:
                level = [] #make a list with all values in current level
                for node in current_level:
                    level.append(node.val)
                result.append(level)
                next_level = [] #make list with values for next level
                for node in current_level:
                    if node.left:
                        next_level.append(node.left)
                    if node.right:
                        next_level.append(node.right)
                current_level = next_level #switch levels

            return result

        level_order_traversal = levelOrder(root)
        for i in range(len(level_order_traversal)):
            if i%2!=0:
                level_order_traversal[i].reverse() #reverse odd numbered levels
        return level_order_traversal
