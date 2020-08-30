# 내가 짠 그리디보다 더 간단하고 잘 짜여진 코드

n = 1250
count = 0

coin_types = [500,100,50,10]

for coin in coin_types :
   count += n//coin 
   n %= coin
    

print(count)