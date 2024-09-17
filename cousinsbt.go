// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
add root to queue
while q not empty loop till size
for current node if x value or y value is found and set it to true
if xfound or y found is set to true already check if other y or x is found then return true
if node and its children are not nil check if we find both x, y as siblings then return false
append left, right children to queue
*/
package main

import "fmt"

type TreeNode struct {
	Val int
	Left *TreeNode
	Right *TreeNode
}

func isCousins(root *TreeNode, x int, y int) bool {
	if root == nil {
		return false
	}
	q := []*TreeNode{root}
	for len(q) > 0 {
		size := len(q)
		x_found := false
		y_found := false
		for i:=0;i<size;i++ {
			n := q[0]
			q = q[1:]
			if n != nil {
				if n.Val == x {
					x_found = true
				}
				if n.Val == y {
					y_found = true
				}
			}
			if x_found {
				if n != nil && n.Val == y {
					return true
				}
			}
			if y_found {
				if n != nil && n.Val == x {
					return true
				}
			}
			if n != nil && n.Left != nil && n.Right != nil {
				if n.Left.Val == x && n.Right.Val == y {
					return false
				}
				if n.Left.Val == y && n.Right.Val == x {
					return false
				}
			}
			if n != nil && n.Left != nil {
				q = append(q, n.Left)
			}
			if n != nil && n.Right != nil {
				q = append(q, n.Right)
			}
		}
	}
	return false
}

func MainCousin() {
	root := &TreeNode{Val: 1, Left: &TreeNode{Val: 2, Left: &TreeNode{Val:4}}, Right: &TreeNode{Val: 3}}
	fmt.Println(isCousins(root, 4, 3)) //expected false
}
