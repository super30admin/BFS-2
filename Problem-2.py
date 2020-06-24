# Time Complexity :O(n^2)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


# Your code here along with comments explaining your approach
class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid or not grid[0]:
            return 0
        queue = set()
        fresh =0
        #check all fresh and rotten put rotten location in queue
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 1:
                    fresh +=1
                elif grid[i][j] == 2:
                    queue.add((i,j))
        sol = 0
        #make a BFS 
        while queue:
            #if no more fresh break
            if fresh <= 0:
                break
            tempQ = set()
            for curr in queue:
                #check all 4 directions and if fresh add them
                if curr[0] > 0 and grid[curr[0]-1][curr[1]] == 1:
                    tempQ.add((curr[0]-1,curr[1]))
                if curr[0] < len(grid)-1 and grid[curr[0]+1][curr[1]] == 1:
                    tempQ.add((curr[0]+1,curr[1]))
                if curr[1] >0 and grid[curr[0]][curr[1]-1] == 1:
                    tempQ.add((curr[0],curr[1]-1))
                if curr[1] < len(grid[0])-1 and grid[curr[0]][curr[1]+1]:
                    tempQ.add((curr[0],curr[1]+1))
            #change fresh that will be rotten to rotten and decrease them from number of fresh
            for i in tempQ:
                if grid[i[0]][i[1]] ==1:
                    grid[i[0]][i[1]] = 2
                    fresh-=1
            # get ride of old queue and ude new q
            queue = tempQ
            # add 1 minute to time
            sol+=1
        # if there is still fresh return -1
        if fresh >0:
            return -1
        # else return solution
        return sol