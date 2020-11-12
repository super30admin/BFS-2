#In matrix, if there are connected components, then we can use BFS/DFS hence I use BFS to solve this problem.
#Time Complexity: O(m*n)
#Space Complexity: O(M)
import queue
def isRotted(arr):
    if (arr is None or len(arr)==0):
        return 0
    fresh = 0
    m = len(arr)
    n = len(arr[0])
    bfsq = queue.Queue()
    for i in range(m):
        for j in range(n):
            if (arr[i][j]==1):
                fresh = fresh + 1
            if (arr[i][j]==2):
                bfsq.put((i,j))

    time = 0
    if fresh==0:
        return 0
    dirs = {(0,1),(1,0),(0,-1),(-1,0)}
    while(len(bfsq)!=0):
        size = len(bfsq)
        for i in range(size):
            curr = bfsq.get()
            for dir in dirs:
                r = dir[0] + curr[0]
                c = dir[1] + curr[1]
                if (r>=0 and r < m and c>=0 and c<n and arr[i][j]==1):
                    bfsq.put((r,c))
                    fresh = fresh - 1
                    arr[i][j] = 2
        time = time + 1
    if fresh > 0:
        return -1
    return time - 1

arr = [[2,1,1],[1,1,0],[0,1,1]]
time = isRotted(arr)
print(time)
