class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:

        if employees is None or len(employees)==0:
            return 0

        hashmap ={}
        result=0
        for e in employees:
            hashmap[e.id] = e
        q = collections.deque()

        q.append(id)
        while len(q)!=0:
            curr = q.pop()

            e = hashmap[curr]
            result+= e.importance
            for s in e.subordinates:
                q.append(s)

        return result
