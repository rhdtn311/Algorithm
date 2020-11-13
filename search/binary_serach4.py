# 백준 2110 공유기 설치 문제

import sys

n,c = map(int,input().split())
array = [] 

for i in range(n) :
    array.append(int(sys.stdin.readline())) 

array.sort()  # 좌표를 정렬해준다.

result = 0  # 결과 값 초기화
start = array[1] - array[0]  # 두 집 사이의 간격의 최솟값
end = array[-1] - array[0]  # 두 집 사이의 간격의 최댓값
while start <= end :  # 이진탐색
    count = 1  # array[0]에 공유기를 둔다 가정하므로 count 는 1부터 시작
    first_array = array[0]  
    mid = (start + end) // 2  # 중앙값은 간격의 최솟값과 최댓값의 중앙값

    # 집 사이의 간격이 집 + 중앙값(임의의 간격값)보다 크다면 count를 1 증가시킨다.
    for i in range(1,n) : 
        if array[i] >= first_array + mid :  # 집 사이의 간격이 집 + 중앙값(임의의 간격값)보다 크다면 
            first_array = array[i]
            count += 1 
    
    # count 가 전체 공유기 수보다 많다면 -> 임의의 간격을 모든 집에 수용할 수 있다면 간격을 늘려봄
    if count >= c :  
        start = mid + 1 
        result = mid
    else : 
        end = mid - 1 
    
print(result)
