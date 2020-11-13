# 백준 1920번 수 찾기 문제
# 단순 이진탐색문제

import sys
n = int(input())
array_A = list(map(int,sys.stdin.readline().split()))
m = int(input())
array_B = list(map(int,sys.stdin.readline().split()))
array_A.sort()

for i in array_B : 
    count = 0
    start = 0
    end = len(array_A)-1
    while start <= end : 
        mid = (start + end) // 2
        if i == array_A[mid] : 
            count += 1 
            print(1)
            break
        elif array_A[mid] < i : 
            start = mid + 1
        else : 
            end = mid - 1
    if count == 0 :
        print(0)



