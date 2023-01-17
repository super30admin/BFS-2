/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
// approach: level order using BFS
// time: o(n)
// space: o(maxWidthOfTree)
// func rightSideView(root *TreeNode) []int {
//     if root == nil {return nil}
//     out := []int{}
//     q := []*TreeNode{root}
//     for len(q) != 0 {
//         qSize := len(q)
//         for qSize != 0 {
//             dq := q[0]
//             q = q[1:]
//             if qSize == 1 {
//                 out = append(out, dq.Val)
//             }
//             if dq.Left != nil {
//                 q = append(q, dq.Left)
//             }
//             if dq.Right != nil {
//                 q = append(q, dq.Right)
//             }
//             qSize--
//         }
//     }
//     return out
// }


// approach: level order using DFS
// time: o(n)
// space: o(h) or o(n) worst case
func rightSideView(root *TreeNode) []int {
    out := []int{}
    var dfs func(r *TreeNode, level int) 
    dfs = func(r *TreeNode, level int) {
        // base
        if r == nil {return }
        // logic
        if len(out) == level {
            out = append(out, r.Val)
        } else {
            out[level] = r.Val
        }
        dfs(r.Left, level+1)
        dfs(r.Right, level+1)
    }
    dfs(root, 0)
    return out
}
