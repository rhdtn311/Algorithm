n,m,k = map(int,input().split())
number = list(map(int,input().split()))
number.sort(reverse = True) # 첫 번째와 두 번째로 큰 수를 구하기 위해 내림차순 정렬
result = 0 

first_num = number[0]  # 가장 큰 수 
second_num = number[1]  # 두 번째로 큰 수 

count = (m // (k+1)) * k + (m % (k+1))  # 가장 큰 수가 더해지는 횟수 
# 첫 번째 항은 더해지는 순열이 m을 나눈 몫만큼 반복되고 그 값에 연속 횟수인 k를 곱하면 가장 큰 수의 총 더한 횟수가 되고,
# 두 번째 항은 m이 k+1로 나누어 떨어지지 않을 때 가장 큰 값이 m을 k+1로 나눈 나머지 만큼 더 더해진다. 

result = (first_num * count) + (m-count)*second_num
# 결과 값은 가장 큰 수 * 횟수 + (m - 횟수) * 두 번째로 큰 수가 된다.

print(result)

