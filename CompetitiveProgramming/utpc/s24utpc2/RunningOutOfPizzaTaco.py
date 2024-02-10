import sys

io = sys.stdin.read().splitlines()
n = int(io[0])
x, y, z = map(int, io[1].split())

extras = min(z // 2, n)
if 2 * n + extras >= x or 2 * n + extras >= y:
	print("yes")
else:
	print("no")