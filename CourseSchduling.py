from queue import Queue
# TC = O(V+E)
# SC = TC = O(V+E)
class Solution:
    
    def canFinish(self, numCourses : int, prerequisties : List[List[int]]) -> bool:
        if numCourses == 0:
            return 0
        q = Queue()
        indegree = [0 for i in range(numCourses)]
        map = dict()
        count =0 
        for i in range(len(prerequisties)):
            From = prerequisties[i][1]
            To = prerequisties[i][0]
            indegree[To] = indegree[To] + 1
            if From not in map:
                map[From] = []
            map[From].append(To)
            
        for i in range(numCourses):
            if indegree[i] == 0:
                q.put(i)
                count += 1
        
        if count == 0:
            return False
        
        while not q.empty():
            curr = q.get()
            if curr in map:
                edges = map[curr]
            for edge in edges:
                indegree[edge] = indegree[edge]-1
                if indegree[edge] == 0:
                    q.get(edge)
                    count +=1
        
        return count== numCourses
                
            