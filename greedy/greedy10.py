# 코드업 그리디 3321번 문제 처음으로 기분 좋게 정답.ㅠㅠ

n = int(input())    # n은 토핑 종류
a,b = map(int,input().split())  # a는 도우 값, b는 토핑 값
c = int(input())    # 도우의 칼로리

calorie = []          # 토핑의 칼로리
for i in range(n) : 
    calorie.append(int(input()))
    
calorie.sort(reverse= True)

best_calorie = c/a
sum_calorie = 0
sum_toping_price = 0
for i in calorie : 
    if best_calorie < i/b :
        sum_calorie += i
        sum_toping_price += b
        best_calorie = (sum_calorie+c) / (a+sum_toping_price)
        
    
print(int(best_calorie))