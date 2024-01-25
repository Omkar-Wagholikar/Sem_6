class Solution:
    def solveNQueens(self, n: int):
        solns = []
        self.getSol([], n, solns)
        boards = [self.make_board(i) for i in solns]
        return boards
    
    def check(self, l, n):
        vals = [i+1 for i in range(n)]

        for i in l:
            if i in vals:
                vals.remove(i)

        for i in range(len(l)):
            if l[i] - len(l) +i in vals:
                vals.remove(l[i] - len(l) +i)
        
            if l[i] + len(l) -i in vals:
                vals.remove(l[i] + len(l) -i)
        return vals
    
    def getSol(self, l, n, solns):
        if(len(solns) == 1): 
            return
        if len(l) == n:
            solns.append(l.copy())
            return
        poss = self.check(l,n)
        if len(poss) == 0:
            return
        else:
            t = l[:]
            for v in poss:
                t.append(v)
                self.getSol(t,n, solns)
                t.pop()

    def make_board(self, l):
        board = []
        for i in range(len(l)):
            vals = " _ " * (l[i] -1) + " Q " + " _ " * (len(l) - l[i])
            board.append(vals)
        return board

a = Solution()
allAns = a.solveNQueens(int(input("Enter nxn board size: ")))
for temp in allAns:
    for m in temp:
        print(m)
    print("DONE")
