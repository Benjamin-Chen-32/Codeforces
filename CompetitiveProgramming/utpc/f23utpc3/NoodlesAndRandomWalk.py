n = int(input())
mod: int = 1000000007

def gcd(a, b):
	if a == 0:
		return b, 0, 1
	else:
		g, x, y = gcd(b % a, a)
		return g, y - (b // a) * x, x


def modular_inverse(b, x):
	g, x1, y1 = gcd(b, x)
	return x1 % x

facs = [1]
inverses = []
for i in range(2000):
	facs.append(facs[i] * (i + 1) % mod)



def choose(n, r) -> int:
	return (facs[n]) * (modular_inverse((facs[r] * facs[n - r]), mod) % mod) % mod

for _ in range(n):
	t, m = map(int, input().split())
	if m > t:
		print(0)
	elif (t + m) % 2 == 0:
		print(choose(t, int((t + m) / 2)))
	else:
		print(choose(t, int((t + m + 1) / 2)))