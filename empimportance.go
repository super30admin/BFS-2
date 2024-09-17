// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
first make a map of id and its employee object to quicken the search
add id to queue
while q not empty loop
add current node importance to res
add each of its subordinate ids to q
return res
*/
package main

import "fmt"

type Employee struct {
	Id int
	Importance int
	Subordinates []int
}
/*
//bfs
func getImportance(employees []*Employee, id int) int {
	if len(employees) < 1 {
		return 0
	}
	ma := make(map[int]*Employee)
	for i:=0;i<len(employees);i++ {
		ma[employees[i].Id] = employees[i]
	}
	q := []int{}
	q = append(q, id)
	res := 0
	for len(q) > 0 {
		v := q[0]
		q = q[1:]
		res += ma[v].Importance
		for j:=0;j<len(ma[v].Subordinates);j++ {
			q = append(q, ma[v].Subordinates[j])
		}
	}
	return res
}
*/

var res int
var ma map[int]*Employee
func getImportance(employees []*Employee, id int) int {
	ma = make(map[int]*Employee)
	if len(employees) < 1 {
		return 0
	}
	for i:=0;i<len(employees);i++ {
		ma[employees[i].Id] = employees[i]
	}
	dfs(id)
	return res
}

func dfs(id int) {
	//no need of base case
	res+=ma[id].Importance
	for i:=0;i<len(ma[id].Subordinates);i++ {
		dfs(ma[id].Subordinates[i])
	}
}

func MainImporatnce() {
	fmt.Println(getImportance([]*Employee{{1, 5, []int{2, 3}}, {2, 3, []int{}}, {3, 3, []int{}}}, 1)) //expected 11
}
