n = int(input())
part = list(map(int,input().split()))
m = int(input())
request_part = list(map(int,input().split()))

part.sort()

def binary_search(array,target,start,end) :
    if start > end : 
        return None
    mid = (start+end)//2

    if target == array[mid] : 
        return mid + 1 
    if target > array[mid] : 
        return binary_search(array,target,mid+1,end)
    elif target < array[mid] : 
        return binary_search(array,target,start,mid-1)
    
for i in request_part : 
    if(bool(binary_search(part,i,0,len(part)-1))) == True :
        print("yes",end= " ")
    else : 
        print("no",end= " ")

