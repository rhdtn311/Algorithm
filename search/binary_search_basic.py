# 재귀 함수를 이용한 이진 탐색

def binary_search(array,target,start,end) : 
    if start>end :
        return None
    mid = (start+end)//2

    if array[mid] == target : 
        return mid+1    # 결과는 n 번쨰에 있다.
    if array[mid] > target : 
        return binary_search(array,target,start,mid-1)
    elif array[mid] < target : 
        return binary_search(array,target,mid+1,end)

array = [0,2,4,6,8,10,12,14,16,18]

print(binary_search(array,4,0,len(array)-1))