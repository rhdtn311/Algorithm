n, m = map(int,input().split())
result = 0

for i in range(n) : 
  lst = list(map(int,input().split()))

  min_val = min(lst)

  max_val = max(result,min_val)

print(max_val)