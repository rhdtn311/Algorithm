n,k = map(int,input().split())
count = 0

while n != 1 :   # n의 값이 1이 아닐 때 반복

  if n % k == 0 :   # n을 k로 나눈 나머지가 0이라면 ( 나누어 떨어진다면 )
    n = n // k  # n은 n을 k로 나눈 몫이 된다.
    count += 1  # 연산을 했으니 count 를 1 올려준다.
    
  else :    # 나누어 떨어지지 않는다면
    n -= 1  # n 에서 1을 뺀다.
    count += 1  # 빼기 연산을 했으니 count 를 1 올려준다.

print(count)
