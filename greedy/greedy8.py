# 코드업 그리디 2001번 문제 : 최소대금 (https://codeup.kr/problem.php?id=2001)

pasta = []
juice = []
most_cheap = 9999999 

for i in range(5) : 
  price = int(input())
  if i<3 : 
    pasta.append(price)
  else : 
    juice.append(price)

for i in pasta : 
  for j in juice : 
    total_price = (i + j)*1.1

    if most_cheap > total_price : 
      most_cheap = total_price
    
print(round(most_cheap,2))
