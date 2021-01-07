# 백준 5585번 거스름돈 문제. 알고리즘 차근차근 다시 시작! 2021/01/07

money = [500, 100, 50, 10, 5 ,1]
n = int(input())    # 지불할 물건의 값
remain_money = 1000 - n     # 거스름 돈
count = 0   # 잔돈의 개수

while remain_money >= 0 :
    # 거스름 돈이 500원 보다 많다면 거스름돈을 500으로 나눈 몫을 잔돈의 개수에 추가하고 나머지를 거스름돈으로 설정
    if remain_money >= 500 :       
        count += remain_money // 500
        remain_money %= 500 
    elif remain_money >= 100 :
        count += remain_money // 100
        remain_money %= 100
    elif remain_money >= 50 :
        count += remain_money // 50
        remain_money %= 50
    elif remain_money >= 10 :
        count += remain_money // 10
        remain_money %= 10
    elif remain_money >= 5 :
        count += remain_money // 5
        remain_money %= 5
    else :
        count += remain_money
        break

print(count)