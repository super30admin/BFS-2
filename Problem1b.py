class Solution(object):
    def rightSideView(self, root):
        """
        Time complexity: O(N), where N is the number of nodes in the binary tree.
        Space complexity: O(M), where M is the maximum number of nodes at any level of the tree.
        :type root: TreeNode
        :rtype: List[int]
        """
        result = []  # Initialize the result list to store the rightmost values

        def dfs(root, level, result):
            if root is None:
                return result  # If the root is None, return the result list
            if len(result) == level:
                # Add the rightmost value at each level to the result list
                result.append(root.val)
            # Recursively traverse the right subtree
            dfs(root.right, level+1, result)
            # Recursively traverse the left subtree
            dfs(root.left, level+1, result)

        # Call the DFS function starting from the root node with initial level 0
        dfs(root, 0, result)

        return result  # Return the list of rightmost values
