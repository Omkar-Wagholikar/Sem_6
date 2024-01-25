class Graph: 

	def __init__(self, vertices): 
		self.V = vertices 
		self.graph = [] 

	# Function to add an edge to graph 
	def addEdge(self, u, v, w): 
		self.graph.append([u, v, w]) 

	def find(self, parent, i): 
		if parent[i] != i: 
			parent[i] = self.find(parent, parent[i]) 
		return parent[i] 
	def union(self, parent, rank, x, y): 
		if rank[x] < rank[y]: 
			parent[x] = y 
		elif rank[x] > rank[y]: 
			parent[y] = x 
		else: 
			parent[y] = x 
			rank[x] += 1
	def KruskalMST(self): 
		result = [] 
		i = 0
		e = 0

		# Sort all the edges in 
		# non-decreasing order of their 
		# weight 
		self.graph = sorted(self.graph, 
							key=lambda item: item[2]) 

		parent = [] 
		rank = [] 

		# Create V subsets with single elements 
		for node in range(self.V): 
			parent.append(node) 
			rank.append(0) 

		while e < self.V - 1: 

			u, v, w = self.graph[i] 
			i = i + 1
			x = self.find(parent, u) 
			y = self.find(parent, v) 

			if x != y: 
				e = e + 1
				result.append([u, v, w]) 
				self.union(parent, rank, x, y) 

		minimumCost = 0
		print("Edges in the constructed MST") 
		for u, v, weight in result: 
			minimumCost += weight 
			print("%d -- %d == %d" % (u, v, weight)) 
		print("Minimum Spanning Tree", minimumCost) 

vert = int(input("Vertex: "))
edge = int(input("Edges: "))
g = Graph(edge) 
for i in range(vert):
    a, b, c = map(int, input("S D W: ").split())
    g.addEdge(a, b, c)

g.KruskalMST()