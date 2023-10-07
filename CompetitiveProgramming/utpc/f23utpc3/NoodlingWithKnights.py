from collections import deque


n = int(input())
start = [int(x) for x in input().split()]
end = [int(x) for x in input().split()]
queue = deque()
visited = [[False for _ in range(n)] for _ in range(n)]
queue.append((start[0], start[1], 0))
visited[start[0]][start[1]] = True
diff_r = [-2, -1, 2, 1, -2, -1, 2, 1]
diff_c = [-1, -2, -1, -2, 1, 2, 1, 2]
while queue:
	curr = queue.popleft()
	if curr[0] == end[0] and curr[1] == end[1]:
		print(curr[2])
		exit()
	for i in range(8):
		new_r = curr[0] + diff_r[i]
		new_c = curr[1] + diff_c[i]
		if new_r >= 0 and new_r < n and new_c >= 0 and new_c < n:
			if not visited[new_r][new_c]:
				queue.append((new_r, new_c, curr[2] + 1))
				visited[new_r][new_c] = True
print(-1)