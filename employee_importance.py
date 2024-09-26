from collections import deque
class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        if employees==None or len(employees)==0:
            return 0
        Hashmap=collections.defaultdict(List)
        for e in employees:
            Hashmap[e.id]=e
        result=0
        queue=deque()
        queue.append(id)
        while queue:
            eid=queue.popleft()
            e=Hashmap.get(eid)
            result+=e.importance
            for subID in e.subordinates:
                queue.append(subID)
        return result
#Time-Complexity: O(N)
#Space-Complexity: O(N)