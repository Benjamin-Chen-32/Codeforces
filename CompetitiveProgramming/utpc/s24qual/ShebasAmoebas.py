import sys
import math

io = sys.stdin.read().splitlines()

m, n = map(int, io[0].split())

grid = []

for i in range(m):
	grid.append([])
	for j in range(n):
		if io[i + 1][j] == '#':
			grid[i].append(1)
		else:
			grid[i].append(0)

visited = [[0 for _ in range(n)] for _ in range(m)]

def in_range(r, c):
	return r >= 0 and r < m and c >= 0 and c < n

amoebas = 0
for i in range(m):
	for j in range(n):
		if visited[i][j] or not grid[i][j]:
			continue
		is_loop = True
		root = (i, j)
		queue = []
		queue.append(root)
		amoebas += 1
		while queue:
			curr = queue.pop(0)
			visited[curr[0]][curr[1]] = 1
			for r in range(-1, 2):
				for c in range(-1, 2):
					try_r = curr[0] + r
					try_c = curr[1] + c
					if in_range(try_r, try_c) and not visited[try_r][try_c] and grid[try_r][try_c]:
						queue.append((try_r, try_c))
print(amoebas)