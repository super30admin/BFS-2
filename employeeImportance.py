# Maiintain a queue and add the first node then keep adding the subordinates until you exhaust the tree
#Time Complexity: O(v+e)
#Space Complexity: O(v+e)
arr = [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]]
st = 1
import queue
#from collections import defaultdict
def imp(arr,st):
    if arr is None or len(arr)==0:
        return 0
    map = dict() #O(v)
    for i in range(len(arr)):
        employee = arr[i]
        map[employee.id] = employee
    q = queue.Queue() #O(n)
    q.append(st)
    while(len(q)!=0):
        eid = q.get()
        e = map[eid]
        result = result + e.importance
        for sid in e.subordinates:
            q.put(sid)
    return result

res = imp(arr,st)
print(res)