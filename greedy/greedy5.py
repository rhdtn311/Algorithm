# 백준 온라인 11399번 그리디 문제 (https://www.acmicpc.net/problem/11399)
# 책을 통해 배우면서 리스트의 최소값을 구하는 방법(sort() 함수를 이용하여) 을 통해 풀었다.


n = int(input())
people = list(map(int,input().split()))
result = []

people.sort()

for i in range(len(people)) : 

  result.append(sum(people[0:i+1]))

print(sum(result))  
