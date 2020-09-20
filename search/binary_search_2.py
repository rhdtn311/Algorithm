# 반복문을 이용한 이진 탐색

def binary_search(array,target,start,end) :     
    while start<=end : 
        mid = (start+end)//2          
        if target == array[mid] :
            print(mid+1)
            return
        elif target > array[mid] :
            start = mid+1            
        else :
            end = mid-1 
    return None            

array = [1,3,5,7,9,11,13,15,17,19]

binary_search(array,13,0,len(array)-1)