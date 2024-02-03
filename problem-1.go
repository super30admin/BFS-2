/*time complexity : O(n)
space Complexity : O(n)*/

func rightSideView(root *TreeNode) []int {
	var result []int
	if root == nil {
		return nil
	}
	var current []*TreeNode
	var nextArray []*TreeNode
	nextArray = append(nextArray, root)

	for len(nextArray) != 0 {
		current = nextArray
		nextArray = []*TreeNode{}
		prev := 0
		for _, value := range current {
			prev = value.Val
			if value.Left != nil {
				nextArray = append(nextArray, value.Left)
			}
			if value.Right != nil {
				nextArray = append(nextArray, value.Right)
			}
		}
		result = append(result, prev)
	}
	return result
}
