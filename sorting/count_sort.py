# 계수정렬
array = [7,5,9,0,3,1,6,2,9,1,4,8,0,5,2]

count = [ 0 for i in range(max(array)+1)]   # 모든 데이터의 값이 0이고 array의 최대 값이 인덱스인 count 리스트를 생성

for i in range(len(array)) : 
    count[array[i]] += 1    # array의 값이 count의 인덱스에 삽입됌.

for i in range(len(count)) : # 출력
    for j in range(count[i]) : 
        print(i,end =" ")