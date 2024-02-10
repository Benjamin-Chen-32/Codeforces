import sys

io = sys.stdin.read().splitlines()

n, p = map(int, io[0].split())
mod = 1000000007

dp = [[0 for j in range(p + 1)]]
dp[0][0] = 1

for i in range(1, n): # (i + 1) is the current stack height
	dp.append([0 for j in range(p + 1)])
	dp[i][0] = 1
	running_sum = dp[i - 1][0]
	for j in range(1, p + 1): # j is the current number of proper pairs
		running_sum += dp[i - 1][j]
		if j - i > 0:
			running_sum -= dp[i - 1][j - i - 1]
		running_sum %= mod
		dp[i][j] = running_sum	
		if dp[i][j] == 0:
			break

print(dp[n - 1][p] % mod)