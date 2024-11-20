from collections import deque
class Solution:
	def orangesRotting1(self, grid):
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

	def orangesRotting2(self, grid):
		# Time Complexity : O(mn) where m is the number of rows in the grid and n is the number of columns in the grid
		# Space Complexity : O(mn) because we are storing every element in the queue
		# Doubt is at a point we are not storing all the elements in the queue. But I'm not sure.
		rows = len(grid)
		columns = len(grid[0])
		fresh = 0
		queue = deque()
		for i in range(rows):
			for j in range(columns):
				if grid[i][j] == 1:
					fresh += 1
				elif grid[i][j] == 2:
					queue.append([i,j])
		mins = 0
		if fresh == 0:
			return 0
		while len(queue) != 0:
			size = len(queue)
			for i in range(size):
				r, c = queue.popleft()
				if r > 0 and grid[r - 1][c] == 1:
					grid[r - 1][c] = 2
					fresh -= 1
					queue.append([r - 1, c])
				if r < rows - 1 and grid[r + 1][c] == 1:
					grid[r + 1][c] = 2
					fresh -= 1
					queue.append([r + 1, c])
				if c > 0 and grid[r][c - 1] == 1:
					grid[r][c - 1] = 2
					fresh -= 1
					queue.append([r, c - 1])
				if c < columns - 1 and grid[r][c + 1] == 1:
					grid[r][c + 1] = 2
					fresh -= 1
					queue.append([r, c + 1])
			mins += 1
		if fresh == 0:
			return mins - 1
		else:
			return -1

if __name__ == '__main__':
	ORot = Solution()
	grid = [[2,1,1],[1,1,0],[0,1,1]]
	print(ORot.orangesRotting2(grid))