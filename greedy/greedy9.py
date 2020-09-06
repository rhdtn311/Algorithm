# 백준 그리디 14659번 한조서열정리하고옴ㅋㅋ 문제 python3 로 하면 시간초과, pypy3로 하면 정답...

n = int(input())
array = list(map(int,input().split()))
k = 1
count = 0 
result = []

for i in array : 
    for j in array[k:] : 
        if i < j :
            break
        else : 
            count += 1
        
    k += 1
    result.append(count)
    count = 0

print(max(result))
    