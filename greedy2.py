# 리스트의 sort 함수를 이용하여 최대, 최소 값을 더욱 쉽게 구할 수 있다.


# N.M,K를 공백으로 구분하여 입력 받기
N,M,K = map(int,input().split())
# N개의 리스트를 공백으로 구분하여 리스트로 입력받기 
number = list(map(int,input().split()))

firstnum = 0  # 가장 큰 수 
secondnum = 0 # 두 번째로 큰 수 
count = 0
result = 0  # 결과 값

for i in number : 
  if i > firstnum : 
    firstnum = i  # 리스트에서 첫 번째로 큰 수 정하기 

number.remove(firstnum) # 첫 번째로 큰 수와 두 번째로 큰 수가 같을 것을 대비해 첫 번째로 큰 수 삭제
      
for j in number :  
  if j <= firstnum : 
    if j > secondnum :
      secondnum = j # 두 번째로 큰 수 정하기
    else :
      continue
  
for k in range(M) : # 총 M번 더해야 함
  if count < K : # K번 이상 같은수를 더하면 안되기 때문에 
    result += firstnum  
    count += 1 # 더하면 카운트를 1씩 올림
  
  else :
    result += secondnum # 가장 큰 수가 K번 이상 연속으로 더해진다면
    count = 0 # 카운트 초기화

print(result)