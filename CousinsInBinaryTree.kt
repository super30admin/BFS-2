// In this problem, we need to find out if x and y are cousins in a binary tree.
// we do level order traversal by keeping two queues, one for nodes and other for the parents. At each level we check if we have found the nodes and if their parents differ or not. 
// We add them to the queue if we have not found the nodes. 
// Time complexity is O(n) where n is number of nodes in the tree. Space complexity is O(n) where n is number of nodes in the tree.

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
        val q : ArrayDeque<TreeNode> = ArrayDeque()
        val parentQ : ArrayDeque<TreeNode> = ArrayDeque()

        if (root == null) return false
        q.addLast(root)
        parentQ.addLast(root)

        var xfound = false
        var yfound = false
        var xParent : TreeNode? = null
        var yParent : TreeNode? = null

        while(q.isNotEmpty()) {
            val size = q.size
            for(i in 0 until size) {
                val curr = q.removeFirst()
                val parent = parentQ.removeFirst()

                if(curr.`val` == x) {
                    xfound = true
                    xParent = parent
                }

                if(curr.`val` == y) {
                    yfound = true
                    yParent = parent
                }

                curr.left?.let{
                    q.addLast(it)
                    parentQ.addLast(curr)
                }

                curr.right?.let{
                    q.addLast(it)
                    parentQ.addLast(curr)
                }

            }
            if(xfound && yfound) return xParent != yParent
            if(xfound || yfound) return false
        }
        return false
    }
}