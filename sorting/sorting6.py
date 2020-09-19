# 백준 11650 좌표 정렬하기 문제

import sys

n= int(input())
array = [ tuple(map(int,sys.stdin.readline().split())) for _ in range(n)] 
array.sort()

for i in range(len(array)) : 
    for j in range(1) : 
        print(array[i][j],array[i][j+1])