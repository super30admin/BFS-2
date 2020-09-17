#** https://leetcode.com/problems/rotting-oranges/
#// Time Complexity : O(n) where n is number of j x k nodes in the grid
#// Space Complexity : O(1) queue can contain max 4 neighbors at any time
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# I had my push and pop on my queue wrong!  I have to be careful to use a queue not a stack!!!
#
#// Your code here along with comments explaining your approach
#
# iterate through all cells
# increment fresh count if cell value == 1
# push cell coord if value == 2
#
# do a level traversal starting at root
# the children of root will be the 4 directions left, right, above, below
# turn any fruit to rotten as necessary
# update the fresh-- as you make fruit rotten
# if fresh hits 0 return current minutes (aka current level)

orangesRotting = (grid) ->
  queue = []
  fresh = 0
  minutes = 0

  # Count fresh fruit, push rotten fruit into queue.
  for i in [0...grid.length]
    for j in [0...grid[0].length]
      if grid[i][j] is 1
        fresh += 1
      else if grid[i][j] is 2
        queue.push([i, j])

  directions = [[-1,0],[1,0],[0,-1],[0,1]]

  while queue.length isnt 0
    if fresh is 0
      return minutes

    for i in [0...queue.length]
      front = queue.shift()

      for j in [0...directions.length]
        r = front[0] + directions[j][0]
        c = front[1] + directions[j][1]

        if r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] is 1
          queue.push([r,c])
          grid[r][c] = 2
          fresh -= 1

    minutes += 1

  if fresh > 0
    return -1

  return minutes

orangesRotting([[2,1,1],[1,1,0],[0,1,1]]) is 4
orangesRotting([[0,2]]) is 0
orangesRotting([[1,2]]) is 1
