// In this problem, we need to provide right side view of a tree. We do a level order traversal and take the last element of each level and add it to the result. 
// Time complexity is O(n) where n is number of nodes in the tree. Space complexity is O(n) where n is number of nodes in the tree.

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = mutableListOf<Int>()
        if(root == null) return result
        val q :ArrayDeque<TreeNode>  = ArrayDeque()
        q.addLast(root)
        while(q.isNotEmpty()) {
            val size = q.size

            for(i in 0 until size) {
                val curr = q.removeFirst()
                if(i == size - 1) {
                    result.add(curr.`val`)
                }

                curr.left?.let{q.add(it)}
                curr.right?.let{q.add(it)}

            }
        }
        return result
    }
}