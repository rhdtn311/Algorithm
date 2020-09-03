# 백준 그리디 알고리즘 11047 동전 0 문제 
# python3 로 채점했을 때는 시간초과 떳는데 pypy3 로 채점했을때는 통과했다.

n,k = map(int,input().split())
array = []
count = 0
now = 0

for _ in  range(n) :
  array.append(int(input()))

array.sort(reverse=True)

while k != 0 :
  if k >= array[now]  :
    k -= array[now]
    count += 1

  else  : 
    now += 1 

print(count)