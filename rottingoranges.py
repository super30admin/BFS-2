# time cmplexity
# leetcode: Accepted
# explaination: O(n)
# 1.append the rotten mangoes in the queu
# 2.check the four directions of the rotten mangoes in the queue and and make the fresh mangoes as rotten magoes and append them into the queue
# 3.make this until all the fresh mangoes are rotten
# 4.d is the depth. for every depth it takes 1 minute

class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        queue = collections.deque()  # we are using deque so we can add tuples
        fresh = 0  # to keep a count of fresh oranges
        for r in range(len(grid)):  # iterating through the matrix to append allindexes of the rotten mangoes
            for c in range(len(grid[0])):
                # print(grid[r][c])
                if grid[r][c] == 2:  # if the mangoe is rotten, you append it in the queue along with he indexes
                    queue.append((r, c, 0))  # append the index of the rooten mangies along with the depth in the  queue
                elif grid[r][c] == 1:  # if the mango is fresh, increase the count of the mangoes
                    fresh += 1
        if fresh == 0:  # if there are no fresh mangoes, return 0
            return 0

        # print(fresh)

        d = 0  # make the depth has 0
        while queue:
            r, c, d = queue.popleft()  # removing the indexed of the rooten angoes
            for nr, nc in self.neighbours(r, c, grid):  # checking the four directions of the mangoes
                if grid[nr][nc] == 1:  # if the magoes if fresh
                    grid[nr][nc] = 2  # make the mango rotten
                    fresh -= 1  # decrement the count of the mango
                    # print(fresh)
                    queue.append((nr, nc, d + 1))  # add the indexes of the rotten mango in the queue
                    # print
        return d if fresh == 0 else -1

    def neighbours(self, r, c, grid):
        for nr, nc in ((r + 1, c), (r - 1, c), (r, c + 1), (r, c - 1)):  # four side directions
            if 0 <= nr < len(grid) and 0 <= nc < len(grid[0]):
                yield nr, nc

