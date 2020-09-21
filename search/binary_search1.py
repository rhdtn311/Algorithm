# 백준 10815 숫자 카드 문제

import sys

n = int(input()) #  갖고 있는 숫자 카드의 수
array = [int(i) for i in sys.stdin.readline().split()]  # 상근이 카드
m = int(input()) # 비교할 카드 수 
comp_array = [int(i) for i in sys.stdin.readline().split()] # 비교 할 리스트
comp_index = [0 for i in range(m)]  # 출력 리스트의 인덱스

def binary_search(array,comp_array,start,end) : # 이진 탐색
    array.sort()    # 이진 탐색을 하기위해 리스트를 정렬
    
    for i in range(len(comp_array)) : # 비교 대상 카드의 배열 수만큼 반복
        # target이 다음 배열로 넘어갈 때마다 초기화
        start = 0   
        end = len(array)-1
        mid = (start+end)//2
        while start <= end :    # 찾고자 하는 데이터가 배열 안에 없어서 end = mid-1 혹은 start = mid+1로 인해 start>end 가 되면 종료
            if i >= len(comp_array) : # i 값이 comp_array의 리스트 범위를 벗어나면 break
                break        
            mid = (start+end)//2
            target = comp_array[i]     # 찾고자 하는 데이터는 com_array의 모든 원소
            if array[mid] == target :    
                comp_index[i] = 1
                i += 1
                break   # 데이터를 찾았다면 break하여 다음 원소로 넘아간다.
            elif array[mid] > target : 
                end = mid - 1 
            else : 
                start = mid + 1 
    
    for i in comp_index :
        print(i,end= " ")

binary_search(array,comp_array,0,len(array)-1)