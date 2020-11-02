# 백준 10814 나이순 정렬 문제 

n = int(input())    
array = [] 
for i in range(n) : 
    array.append(list(input().split()))

array.sort(key= lambda x : int(x[0]))   # key는 정렬 기준으로 매개변수 x의 반환값이 기준이된다. 즉 0번 인덱스의 값을 기준으로 정렬

for i,j in array : 
    print(i,j)