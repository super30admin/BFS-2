class Solution:
	def orangesRotting(self, grid: List[List[int]]) -> int:
		# Used an approach similar to the game of life problem
		# But if its not possible to convert everything to stale don't know the stopping condition
		rows = len(grid)
		columns = len(grid[0])
		res = 0
		count = 0
		while True:
			breakcount = sum([i.count(1) for i in grid])
			tempgrid = [x[:] for x in grid]
			if breakcount == 0:
				count = sum([i.count(2) for i in grid])
				count += sum([i.count(0) for i in grid])
				break
			for row in range(rows):
				for column in range(columns):
					if grid[row][column] == 2:
						# top
						if row > 0 and tempgrid[row - 1][column] == 1 :
							tempgrid[row - 1][column] = 2 
						# bottom
						if row < rows - 1 and tempgrid[row + 1][column] == 1:
							tempgrid[row + 1][column] = 2
						# left
						if column > 0 and tempgrid[row][column - 1] == 1:
							tempgrid[row][column - 1] = 2
						# right
						if column < columns - 1 and tempgrid[row][column + 1] == 1:
							tempgrid[row][column + 1] = 2
			print(tempgrid)
			grid = [x[:] for x in tempgrid]
			res += 1
		if count == (rows * columns):
			return res
		else:
			return -1