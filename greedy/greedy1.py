# 그리디 알고리즘의 매우 기초 코드
# 현재 상황에서 가장 좋은 것만 고르는 방법 

money = int(input("거스름 돈을 입력하세요.\n"))

five_hundred = 0
one_hundred = 0
fifty = 0
ten = 0

while money > 0 :
  if money >= 500 : 
    money -= 500
    five_hundred += 1
  
  elif 500 > money and money >= 100 :
    money -= 100
    one_hundred += 1
  
  elif 100 > money and money >= 50 :
    money -= 50 
    fifty += 1
  
  else :
    money -= 10 
    ten += 1
  
print(""""" 거슬러 줘야 할 총 동전의 개수는 :
500원 : {}개
100원 : {}개
50원 : {}개
10원 : {}개
총 : {} 개 입니다. """.format(five_hundred,one_hundred,fifty,ten,five_hundred+one_hundred+fifty+ten))