
result = 0
n, m = map(int,input().split()) # 열과 행을 정함

for i in range(n) :  # 열의 수 만큼 반복
  a = list(map(int,input().split())) # 행을 입력
  min_value = 10001 # 원소의 최솟값을 구하기 위한 기준
  

  for j in a :  # 행의 최솟값 구하기
    if j > min_value :
      pass
    else : 
      min_value = j
  

    
  if min_value > result : # 각 행의 최솟값중 가장 큰 값 구하기
    result = min_value 
  else : 
    pass
    
print(result)
