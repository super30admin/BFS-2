#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Oct 18 08:34:57 2019

@author: tanvirkaur
"""

class Solution(object):
    def orangesRotting(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        rotten orange are pushed into queue
        count for the fresh oranges is maintained.
        time complexity = 0(n)
        space complexity = 0(n)
        """
        q = collections.deque()
        self.R = len(grid)
        self.C = len(grid[0])
        fresh_oranges = 0
        for r, row in enumerate(grid):
            for c , val in enumerate(row):
                if val == 2 :
                    q.append((r,c,0))
                if val == 1:
                    fresh_oranges += 1 #increment the fresh oranges if val = 1
        if fresh_oranges == 0:
            return 0
        d = 0
        while q:
            r,c,d = q.popleft()
            for nr , nc in self.neighbours(r,c):
                if grid[nr][nc] == 1:
                    grid[nr][nc] =2
                    fresh_oranges += -1 # after making the fresh oranges to rotten oranges decrement the count of fresh oranges
                    q.append((nr,nc,d+1))
        return d if fresh_oranges == 0 else -1 #if the count of fresh oranges = 0 while itreating through the entire queue return d
    
    
    def neighbours(self, r,c):
        for nr , nc in ((r-1,c), (r,c-1), (r+1,c), (r,c+1)):
            if 0<=nr< self.R and 0<=nc < self.C:
                yield nr,nc
            