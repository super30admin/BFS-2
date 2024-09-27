#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Thu Dec 26 11:29:35 2019

@author: tanvirkaur
"""

#time complexity = O(n*m)
#space complexity = O(n) where n is the size of the q 
class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        # base case
        if len(grid) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        fresh_oranges = 0
        q = []
        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 1:
                    fresh_oranges += 1
                elif grid[i][j] == 2:
                    q.append((i,j))
        if fresh_oranges == 0:
            return 0
        dirs = [(1,0), (-1,0), (0,1), (0,-1)]
        while q:
            for i in range(len(q)):
                rotten = q.pop(0)
                for dir in dirs:
                    x = dir[0] + rotten[0]
                    y = dir[1] + rotten[1]
                    if x >= 0 and x < m and y >= 0 and y < n and grid[x][y] == 1:
                        grid[x][y] = 2
                        q.append((x,y))
                        fresh_oranges += -1
            count += 1
        if fresh_oranges == 0:
            return count-1
        return -1