# 백준 1138 한 줄로 서기
# 인덱스가 작은 사람이 더 키가 작은 사람이다.

n = int(input())
array = list(map(int,input().split()))    

# 한 명의 사람만 있다면 1을 출력
if n == 1 :
    print(1)

# 줄을 표현하기 위한 배열 선언
result = []

# 키가 가장 큰 맨 뒤부터 배열(array)을 차례대로 꺼낸다.
# 여기서 count는 현재 꺼낸 인덱스보다 큰 인덱스의 수이고 (더 키가 큰)
# count의 값이 i보다 큰 사람의 수(array[i])와 같다면 result의 (i+1)인덱스에 넣어준다.
# 그리고 가장 키가 큰 값부터 검사하므로 검사 주기가 한 번 돌 때마다 count의 값은 1씩 증가시킨다.
# n이 2일 경우에 <for j 구문>을 한 번 밖에 돌지 않기 때문에 else:에 result.insert 구문을 추가해주어야 한다.

# 정리) 배열에 뒤에서부터 검사하여 자신보다 뒤에 검사받는 값들은 무조건 자신보다 키가 작기 때문에 앞에있던 뒤에있던
# count의 값에는 영향을 끼치지 않는다. 따라서 자신보다 큰 값만 신경써서 +1을 해주고 그 count값이 실제로 내 앞에 있는 사람의 수와 같다면 
# 그 인덱스에 값을 추가한다.

for i in range(n - 1, -1, -1) :
    count = 0
    for j in range(n - 2, -1, -1) :
        if array[i] == count :
            result.insert(count, i+1)
            break
        else: 
            count += 1
            if array[i] == count :
                result.insert(count, i+1)
                break
            continue
        
for i in result : 
    print(i, end = " ")
