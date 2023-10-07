from collections import defaultdict

n = int(input())
ciphers = []
for _ in range(n):
	ciphers.append(list(map(int, input().split()))[1:])

s = len(ciphers[0])
base = [x + 1 for x in range(s)]
dictionary = defaultdict(lambda: 0)
nonciphers = 0
for cipher in ciphers:
	for i in range(s):
		if cipher[i] == 1:
			break
	works = True
	for j in range(s):
		if cipher[(i + j) % s] != base[j]:
			works = False
			nonciphers += 1
			break
	if works:
		dictionary[i] += 1

ans = 0
unmatched = 0
for _, v in dictionary.items():
	ans += (v // 2) * 2
	unmatched += v % 2
random_match = min(unmatched, nonciphers)
unmatched -= random_match
unmatched = max(unmatched, 0)
print(ans + random_match + (unmatched // 2))