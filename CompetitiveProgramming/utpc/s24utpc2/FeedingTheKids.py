import sys

io = sys.stdin.read().splitlines()
n, k = map(int, io[0].split())
slices = list(map(int, io[1].split()))

total_slices = sum(slices)
max_slices = max(slices)

def works(slices_per_pizza):
	pizzas_left = k
	curr_slices = slices_per_pizza
	for kid in slices:
		if kid <= curr_slices:
			curr_slices -= kid
			if curr_slices == 0:
				pizzas_left -= 1
				curr_slices = slices_per_pizza
		else:
			pizzas_left -= 1
			if pizzas_left == 0:
				return False
			curr_slices = slices_per_pizza - kid
		if pizzas_left < 0 or curr_slices < 0:
			return False
	return True

l = max_slices
r = total_slices + 1
while l < r:
	mid = (l // 2) + (r // 2) + ((l % 2 + r % 2) // 2)
	if works(mid):
		r = mid
	else:
		l = mid + 1
print(l)