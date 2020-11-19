# 이것이 코딩 테스트다 with 파이썬 (나동빈) 다이나믹프로그래밍 개미전사 문제
n = int(input())
array = list(map(int,input().split()))
d = [0]*100  # array의 n번 인덱스까지의 최댓값을 저장하기 위한 DP테이블 초기화

d[0] = array[0]  # 0번 인덱스 까지의 최댓값은 0번 인덱스 값
d[1] = max(d[0],array[1])  # 1번 인덱스까지의 최댓값은 0번 인덱스 값과 1번 인덱스 중 최댓값

# 2번 인덱스부터의 최댓값은 n-1번 인덱스까지의 최댓값과 n-2번 인덱스까지의 최댓값 + n번 인덱스의 값 중 최댓값
for i in range(2,n) :
    d[i] = max(d[i-1],d[i-2]+array[i])  

print(d[n-1])