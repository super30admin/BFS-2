class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        d = dict()
        for node in employees:
            d[node.id] = node
            
        def Importance(node):
            if len(node.subordinates)==0:
                return node.importance
            else:
                S = node.importance
                for _id in node.subordinates:
                    S += Importance(d[_id])
                return S
                
        return Importance(d[id])
        #tc sc o(n)
