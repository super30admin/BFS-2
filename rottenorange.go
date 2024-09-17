// Time Complexity : O(m2n2)
// Space Complexity : O(v+e)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
create q of int[]
first check grid and add 1 to fresh count for each 1 in grid
and append all rotten locations to q
if fresh == 0 return time 0
create all dir array
till q is not empty loop till size
get all adjacent locations and check if they are in range and fresh if so then
add location to q, reduce fresh, set location to rotten
after size loop increment time
return time
*/
package main

import "fmt"

func orangesRotting(grid [][]int) int {
	if len(grid) < 1 {
		return -1
	}
	fresh := 0
	m := len(grid)
	n := len(grid[0])
	q := [][]int{}
	for i:=0;i<m;i++ {
		for j:=0;j<n;j++ {
			if grid[i][j] == 1 {
				fresh++
			}
			if grid[i][j] == 2 {
				q = append(q, []int{i, j})
			}
		}
	}
	time := 0
	if fresh == 0 {
		return time
	}
	dirs := [][]int{{0, 1},{1, 0},{-1, 0},{0, -1}}
	for len(q) > 0 {
		size := len(q)
		for i:=0;i<size;i++ {
			v := q[0]
			q = q[1:]
			for j:=0;j<len(dirs);j++ {
				r := dirs[j][0] + v[0]
				c := dirs[j][1] + v[1]
				if r >= 0 && r < m && c >= 0 && c < n && grid[r][c] == 1{
					q = append(q, []int{r,c})
					fresh--
					grid[r][c] = 2
				}
			}
		}
		time++
	}
	if fresh > 0 {
		return -1
	}
	return time - 1
}

func MainRottenOrange() {
	fmt.Println(orangesRotting([][]int{{2,1,1},{1,1,0},{0,1,1}})) // expected 4
}
