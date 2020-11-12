# 이것이 코딩테스트다 떡볶이 떡 만들기 문제
import sys

n,m = map(int,input().split())
array = list(map(int,sys.stdin.readline().split()))

start = 0 
end = max(array)

while start <= end : 
    result = 0
    mid = ( start + end ) // 2 
    total = 0 
    
    for i in array : 
        if i > mid :
            total+=(i-mid)
    
    if total > m : 
        start = mid + 1 
    else : 
        end = mid - 1 
        result = mid
    
print(result)