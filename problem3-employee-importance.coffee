#** https://leetcode.com/problems/employee-importance/
#// Time Complexity : O(n) we run through the employees list, then bfs
#// Space Complexity : O(n) where n is number of employees, we build a hash
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# leetcode input drove me mad, they don't provide real input
# I thought it was really arrays, but when i run the code the data are objects
#
#// Your code here along with comments explaining your approach
#
# create a hash of employeeid => employee importance, subordinates
#
# start at employee id
# update importance sum with employee importance
# remove employee, add subordinates to queue
# repeate adding subordinate importance and removing / adding subordinates

GetImportance = (employees, id) ->
  hash = new Map()

  employees.forEach ({id, importance, subordinates}) ->
#    [employeeId, importance, subordinates] = employee
#    employeeId = employee[0]
#    importance = employee[1]
#    subordinates = employee[2]
    hash.set(
      id,
        importance: importance
        subordinates: subordinates
    )

  queue = []
  output = 0

  queue.push(id)
  while queue.length > 0
    front = queue.shift()

    output += hash.get(front).importance

    hash.get(front).subordinates.forEach (sub) ->
      queue.push(sub)

  output

# [1, 5, [2, 3]]: employee 1 has importance 5 and subordinates 2 and 3
#GetImportance([[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1)
#GetImportance([[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1) is 11
