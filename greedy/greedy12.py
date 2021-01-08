# 백준 1541번 잃어버린 괄호 문제 2021/01/07

# 이 문제는 식의 - 뒤에 (를 붙이고 그 다음 - 앞에 ) 를 붙여 모든 +의 합을 -로 바꾸면 된다.
# 처음에 eval로 문제를 풀었다가 01+02 와 같이 숫자 앞에 0이 붙을 때를 계산하지 못하여 다른 방법을 사용했다.

# 계산식을 입력 받고 -를 기준으로 배열로 바꿈 
array = input().split('-')

# 맨 처음 값에서 차례로 뒤에 - 값들을 빼주면 되기 때문에 처음 값을 count에 넣는다.
# 맨 처음 값이 +로 이루어져 있을 수 있기 때문에 +를 기준으로 배열로 놓고 하나씩 꺼내어 int로 바꾼 후 count에 더해줌
firstArray = array[0].split('+')
count = 0
for i in firstArray :
    count += int(i)

# -(num + num + ... ) 의 형태로 이루어진 모든 식들을 하나하나씩 count에서 빼줌
for j in range(1,len(array)) : 
    sentence = array[j].split('+')
    for k in sentence :
        count -= int(k)

# 결과 출력
print(count)


