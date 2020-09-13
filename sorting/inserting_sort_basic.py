# 삽입 정렬
array = [9,2,5,3,4,7,6,1,0,8]

for i in range(1,len(array)) :
    for j in range(i,0,-1) : 
        if array[j] < array[j-1] : 
            array[j],array[j-1] = array[j-1],array[j]
        else : 
            break
