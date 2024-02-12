import sys

io = sys.stdin.read().splitlines()

n = int(io[0])

points = []

for i in range(n):
	x, y, v = map(int, io[i + 1].split())
	points.append((x, y, v))

dp = [[0 for _ in range(n + 1)] for _ in range(n)]
endpoints = [[(None, None) for _ in range(n + 1)] for _ in range(n + 1)]

def area(point, endpoints):
	if endpoints[0] == None:
		return 0
	p0 = points[endpoints[0]]
	p1 = points[endpoints[1]]
	v0 = (p0[0] - point[0], p0[1] - point[1])
	v1 = (p1[0] - point[0], p1[1] - point[1])
	return v0[0] * v1[1] - v0[1] * v1[0]

dp[0][0] = points[0][2]
endpoints[0][1] = (0, 0)

for i in range(1, n):
	dp[i][0] = dp[i - 1][0] + points[i][2]
	dp[i][i + 1] = dp[i - 1][i] + area(points[i], endpoints[i - 1][i])
	endpoints[i][i + 1] = (endpoints[i - 1][i][0], i)
	for j in range(1, i + 1):
		sell_point = dp[i - 1][j] + points[i][2]
		add_to_poly = dp[i - 1][j - 1] + area(points[i], endpoints[i - 1][j - 1])
		if sell_point < add_to_poly:
			endpoints[i][j] = (endpoints[i - 1][j - 1][0], i)
		else:
			endpoints[i][j] = endpoints[i - 1][j]
		dp[i][j] = max(sell_point, add_to_poly)

print(max(dp[n - 1]))
