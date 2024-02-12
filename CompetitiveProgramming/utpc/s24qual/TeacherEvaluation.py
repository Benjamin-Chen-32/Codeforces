import sys
import math

io = sys.stdin.read().splitlines()

n, p = map(int, io[0].split())

scores = list(map(int, io[1].split()))

adds = 0

if p == 100:
	print("impossible")
else:
	score_sum = sum(scores)
	target_sum = p * n
	while target_sum > score_sum:
		adds += 1
		target_sum += p
		score_sum += 100
	print(adds)