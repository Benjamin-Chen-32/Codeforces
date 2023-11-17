import sys

io = sys.stdin.read().splitlines()
c = int(io[0])
for i in range(c):
	n, *input_arr = list(map(int, io[i + 1].split()))
	grade_sum = sum(input_arr)
	ans = sum(map(lambda x: x * n > grade_sum, input_arr))
	print(f"{round(ans * 100 / n, 3):.3f}%")