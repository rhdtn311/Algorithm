# greedy5 의 다른 방식으로 문제풀이
# 다시 보니까 똑같은 말인 것 같다.

n = int(input())
people = list(map(int,input().split()))
result = 0

people.sort()

for i in range(len(people)-1) : 
  i = i+1
  people[i] = people[i] + people[i-1]
  result += people[i] 


print(result+people[0])  
