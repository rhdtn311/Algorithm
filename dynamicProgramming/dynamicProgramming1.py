# 백준 1463번 

n = int(input())
array = [0] * 1000001   # n을 구하기위해 수행되는 연산의 최솟값을 저장하는 배열

for i in range(2,n+1) : 
    array[i] = array[i-1] + 1   # 우선 1을 빼는 것은 아무 조건이 없기 때문에 n-1의 연산 최솟값에서 1을 더해줌
    if i % 2 == 0 :    # 만약 그 수가 2로 나누어 떨어진다면 n-1 에서 1을 더했을 때 연산 횟수와  n/2 에서 2를 곱했을 때의 연산 횟수중 더 적은 것을 저장
        array[i] = min(array[i],array[i//2]+1)
    if i % 3 == 0 :    # 그 수가 3으로 나누어 떨어진다면 위와 동일
        array[i] = min(array[i],array[i//3]+1)

print(array[n])