# 순차탐색
#  n은 원소의 개수, target은 찾고자 하는 데이터, array는 target이 있는 리스트
def sequential_search(n,target,array) : 
    for i in range(n) : 
        if array[i] == target : 
            return i+1
