# sort와 sorted의 차이점을 알았다. (sort는 리스트 내에서 정렬, sorted는 리스트를 정렬하여 반환)
# sorted, lambda에 대해 알았다. 

n= int(input())
array = []
for i in range(n) :
    input_data = input().split() 
    array.append((str(input_data[0]),int(input_data[1])))

result = sorted(array,key = lambda x:x[1])

for j in result : 
    print(j[0],end =" ")