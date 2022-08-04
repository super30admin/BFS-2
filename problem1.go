// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
//TC - O(N)
//SC - O(N)

//BFS
func rightSideView(root *TreeNode) []int {
    if root == nil{
        return []int{}
    }
    
    result := []int{}
    q := []*TreeNode{}
    q = append(q,root)
    
    for len(q) > 0{
        size := len(q)    
        for i:=0;i<size;i++{
            node := q[0]
            q = q[1:]
            if i == size-1{
                result = append(result,node.Val)
            }
            
            if node.Left != nil{
                q = append(q,node.Left)
            }
            
            if node.Right != nil{
                q = append(q,node.Right)
            }
        }
    }
    
    return result
}


//DFS
var result []int

func rightSideView(root *TreeNode) []int {
    if root == nil{
        return []int{}
    }
    
    result = []int{}
    
    helper(root,0)
    
    return result
}


func helper(root *TreeNode,level int){
    if root == nil{
        return
    }
    
    if level == len(result){
        result = append(result,root.Val)
    }
    
    
    helper(root.Right,level+1)
    helper(root.Left,level+1)
    
    
}
